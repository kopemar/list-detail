package cz.kopemar.listdetail.fragments

import android.util.Log
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.CommitListViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class CommitsFragment : BaseListFragment() {

    private val vm by sharedViewModel<RepositoryDetailViewModel>()

    override var fragmentName = R.string.commits

    override fun waitForResponse() {
        Log.e("Commits", "waiting for response ${vm.repositoryName}")
        vSwipeRefresh.isRefreshing = true
        vm.getAllCommitsInRepo().observe(this, Observer<List<CommitWrapper>> {
            vList.adapter = CommitListViewAdapter(it, null)
            if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
        })
    }

    override fun refresh() {
        vm.commits = null
        waitForResponse()
    }
}