package cz.kopemar.listdetail.fragments

import android.os.Bundle
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.viewmodel.RepositoryViewModel
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.repo
import cz.kopemar.listdetail.views.adapters.CommitListViewAdapter
import kotlinx.android.synthetic.main.fragment_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class CommitsFragment: BaseListFragment() {

    private val vm by viewModel<RepositoryViewModel>()

    override fun getFragmentName() = "Commits"

    private var repositoryName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repositoryName = repo
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (repo != null) {
            vm.getAllCommitsInRepo(repo!!).observe(this, Observer<List<CommitWrapper>> {
                vList.adapter = CommitListViewAdapter(it, null)
            })
        }

    }
}