package cz.kopemar.listdetail

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import cz.kopemar.listdetail.fragments.BranchesFragment
import cz.kopemar.listdetail.fragments.CommitsFragment
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.viewmodel.MainViewModel
import cz.kopemar.listdetail.viewmodel.RepositoryViewModel
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.branches
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.commits
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.repo
import cz.kopemar.listdetail.views.adapters.BaseFragmentAdapter
import kotlinx.android.synthetic.main.activity_repository.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoryDetailActivity: AppCompatActivity() {

    private val vm by viewModel<RepositoryViewModel>()

    private val fragments = listOf(
        CommitsFragment(),
        BranchesFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        repo = intent.getStringExtra(RepositoriesFragment.intent_text)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        vViewPager.adapter = BaseFragmentAdapter(fragments, supportFragmentManager)
        vTabs.setupWithViewPager(vViewPager)
    }



    override fun onNavigateUp(): Boolean {
        return finishActivity()
    }

    override fun onSupportNavigateUp(): Boolean {
        return finishActivity()
    }

    private fun finishActivity(): Boolean {
        repo = null
        commits = null
        branches = null
        finish()
        return true
    }
}