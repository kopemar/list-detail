package cz.kopemar.listdetail.fragments

import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.CommitListViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

/**
 * [BaseListFragment] for list of commits (observes changes of commits list and puts data into list with CommitListViewAdapter).
 */
class CommitsFragment : BaseListFragment() {

    private val observer = Observer<List<CommitWrapper>> {
        vList.adapter = CommitListViewAdapter(it, null)
        if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
    }

    private val vm by sharedViewModel<RepositoryDetailViewModel>()

    override var fragmentName = R.string.commits

    override fun waitForResponse() {
        if (checkConnection()) {
            vSwipeRefresh.isRefreshing = true
            vm.commits.observe(viewLifecycleOwner, observer)
        }
    }

    override fun refresh() {
        if (checkConnection()) {
            vm.refreshCommits()
            waitForResponse()
        }
    }
}