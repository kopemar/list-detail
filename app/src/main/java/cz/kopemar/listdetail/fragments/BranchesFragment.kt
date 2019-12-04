package cz.kopemar.listdetail.fragments

import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.BranchViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class BranchesFragment : BaseListFragment() {

    private val vm by sharedViewModel<RepositoryDetailViewModel>()

    private val observer = Observer<List<Branch>> {
        vList.adapter = BranchViewAdapter(it)
        if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
    }

    override var fragmentName = R.string.branches

    override fun waitForResponse() {
        vSwipeRefresh.isRefreshing = true
        vm.branches.observe(viewLifecycleOwner, observer)
    }

    override fun refresh() {
        vm.refreshBranches()
        waitForResponse()
    }
}