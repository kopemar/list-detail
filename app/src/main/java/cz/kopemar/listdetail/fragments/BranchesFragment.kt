package cz.kopemar.listdetail.fragments

import android.os.Bundle
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.viewmodel.RepositoryViewModel
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder
import cz.kopemar.listdetail.views.adapters.BranchViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class BranchesFragment: BaseListFragment() {
    private val vm by viewModel<RepositoryViewModel>()

    override fun getFragmentName() = "Branches"

    private var repositoryName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repositoryName = CommitsHolder.repo
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (CommitsHolder.repo != null) {
            vm.getAllBranchesInRepo(CommitsHolder.repo!!).observe(this, Observer<List<Branch>> {
                vList.adapter = BranchViewAdapter(it)
            })
        }

    }
}