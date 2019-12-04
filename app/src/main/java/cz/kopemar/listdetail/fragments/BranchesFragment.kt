package cz.kopemar.listdetail.fragments

import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.BranchViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class BranchesFragment : BaseListFragment() {
    private val vm by viewModel<RepositoryDetailViewModel>()

    override var fragmentName = R.string.branches

    override fun waitForResponse() {
        vSwipeRefresh.isRefreshing = true
        if (vm.repositoryName != null) {
            vm.getAllBranchesInRepo(vm.repositoryName!!).observe(this, Observer<List<Branch>> {
                vList.adapter = BranchViewAdapter(it)
                if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
            })
        }
    }

    override fun refresh() {
        vm.branches = null
        waitForResponse()
    }
}