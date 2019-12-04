package cz.kopemar.listdetail.fragments

import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.CommitListViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class CommitsFragment : BaseListFragment() {

    private val vm by viewModel<RepositoryDetailViewModel>()

    override var fragmentName = R.string.commits

    override fun waitForResponse() {
        vSwipeRefresh.isRefreshing = true
        if (vm.repositoryName != null) {
            vm.getAllCommitsInRepo(vm.repositoryName!!).observe(this, Observer<List<CommitWrapper>> {
                vList.adapter = CommitListViewAdapter(it, null)
                if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
            })
        }
    }

    override fun refresh() {
        vm.commits = null
        waitForResponse()
    }
}