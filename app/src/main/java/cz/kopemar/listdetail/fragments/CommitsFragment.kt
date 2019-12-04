package cz.kopemar.listdetail.fragments

import android.util.Log
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.CommitListViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CommitsFragment : BaseListFragment() {

    private val observer = Observer<List<CommitWrapper>> {
        vList.adapter = CommitListViewAdapter(it, null)
        if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
    }

    private val vm by sharedViewModel<RepositoryDetailViewModel>()

    override var fragmentName = R.string.commits

    override fun waitForResponse() {
        vSwipeRefresh.isRefreshing = true
        vm.commits.observe(viewLifecycleOwner, observer)
    }

    override fun refresh() {
        vm.refreshCommits()
        waitForResponse()
    }
}