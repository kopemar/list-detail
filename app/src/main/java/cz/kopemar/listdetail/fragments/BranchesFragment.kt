package cz.kopemar.listdetail.fragments

import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.viewmodel.RepositoryViewModel
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.branches
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.repo
import cz.kopemar.listdetail.views.adapters.BranchViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class BranchesFragment : BaseListFragment() {
    private val vm by viewModel<RepositoryViewModel>()

    override var fragmentName = R.string.branches

    override fun waitForResponse() {
        vSwipeRefresh.isRefreshing = true
        if (repo != null) {
            vm.getAllBranchesInRepo(repo!!).observe(this, Observer<List<Branch>> {
                vList.adapter = BranchViewAdapter(it)
                if (vSwipeRefresh.isRefreshing) vSwipeRefresh.isRefreshing = false
            })
        }
    }

    override fun refresh() {
        branches = null
        waitForResponse()
    }
}