package cz.kopemar.listdetail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.viewmodel.RepositoryViewModel
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.repo
import cz.kopemar.listdetail.views.adapters.CommitListViewAdapter
import kotlinx.android.synthetic.main.fragment_commit_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class CommitsFragment: Fragment() {

    private val vm by viewModel<RepositoryViewModel>()
    private var repositoryName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        repositoryName = repo
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_commit_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (repo != null) {
            vm.getAllCommitsInRepo(repo!!).observe(this, Observer<List<CommitWrapper>> {
                vCommitList.adapter = CommitListViewAdapter(it, null)
            })
        }

    }
}