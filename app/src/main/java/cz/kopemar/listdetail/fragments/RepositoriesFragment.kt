package cz.kopemar.listdetail.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.activities.RepositoryDetailActivity
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.viewmodel.MainViewModel
import cz.kopemar.listdetail.views.adapters.RepositoryListViewAdapter
import cz.kopemar.listdetail.views.listener.OnListItemClickedListener
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * [BaseListFragment] for list of repositories (observes changes of repository list and puts data into list with RepositoryListViewAdapter).
 */
class RepositoriesFragment : BaseListFragment(), OnListItemClickedListener {

    private val vm by viewModel<MainViewModel>()

    override var fragmentName = R.string.repositories

    private val observer = Observer<List<Repository>> {
        vList.adapter = RepositoryListViewAdapter(it, this)
        if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
    }

    override fun waitForResponse() {
        if (checkConnection()) {
            vSwipeRefresh.isRefreshing = true
            vm.repositories.observe(viewLifecycleOwner, observer)
        }
    }

    override fun refresh() {
        vm.refreshRepositories()
        waitForResponse()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vList.listener = this
    }

    override fun onItemClick(position: Int) {
        context?.let {
            startIntent(it, position)
        }
    }

    private fun startIntent(context: Context, position: Int) {
        val intent = Intent(context, RepositoryDetailActivity::class.java)

        intent.putExtra(INTENT_TEXT, vm.repositories.value?.get(position)?.name)
        ContextCompat.startActivity(context, intent, null)
    }

    companion object {
        const val INTENT_TEXT = "OPEN_REPO"
    }
}