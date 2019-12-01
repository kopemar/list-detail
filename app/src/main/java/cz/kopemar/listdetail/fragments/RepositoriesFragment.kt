package cz.kopemar.listdetail.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.RepositoryActivity
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.viewmodel.MainViewModel
import cz.kopemar.listdetail.viewmodel.holder.RepositoriesHolder.Companion.repositories
import cz.kopemar.listdetail.views.ListViewAdapter
import cz.kopemar.listdetail.views.ListViewHolder
import kotlinx.android.synthetic.main.fragment_repo.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoriesFragment: Fragment(), ListViewHolder.OnListItemClickedListener {

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

        vRepositoriesList.listener = this

        vm.getAllRepos().observe(this, Observer<List<Repository>> {
            vRepositoriesList.dataset = it
        })
    }

    override fun onItemClick(position: Int) {
        if (context != null) {
            startIntent(context!!, position)
        }
    }

    private fun startIntent(context: Context, position: Int) {
        Log.e("Adapter", "start intent")
        val intent = Intent(context, RepositoryActivity::class.java)
        intent.putExtra(ListViewAdapter.intent_text, repositories?.value?.get(position)?.name)
        ContextCompat.startActivity(context, intent, null)
    }
}