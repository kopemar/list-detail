package cz.kopemar.listdetail.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.RepositoryDetailActivity
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.viewmodel.MainViewModel
import cz.kopemar.listdetail.viewmodel.holder.RepositoriesHolder.Companion.repositories
import cz.kopemar.listdetail.views.adapters.RepositoryListViewAdapter
import cz.kopemar.listdetail.views.listener.OnListItemClickedListener
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoriesFragment: BaseListFragment(), OnListItemClickedListener {

    private val vm by viewModel<MainViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vList.listener = this

        vm.getAllRepos().observe(this, Observer<List<Repository>> {
            vList.adapter = RepositoryListViewAdapter(it, this)
        })
    }

    override fun onItemClick(position: Int) {
        if (context != null) {
            startIntent(context!!, position)
        }
    }

    private fun startIntent(context: Context, position: Int) {
        val intent = Intent(context, RepositoryDetailActivity::class.java)

        intent.putExtra(intent_text, repositories?.value?.get(position)?.name)
        ContextCompat.startActivity(context, intent, null)
    }

    companion object {
        const val intent_text = "OPEN_REPO"
    }
}