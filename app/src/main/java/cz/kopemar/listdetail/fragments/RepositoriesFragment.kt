package cz.kopemar.listdetail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_repo.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoriesFragment: Fragment() {

    private val vm by viewModel<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        vm.getAllRepos().observe(this, Observer<List<Repository>> {
            vRepositoriesList.dataset = it
        })

    }
}