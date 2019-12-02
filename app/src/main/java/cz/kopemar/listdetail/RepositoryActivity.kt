package cz.kopemar.listdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cz.kopemar.listdetail.databinding.ActivityRepositoryBinding
import cz.kopemar.listdetail.fragments.BranchesFragment
import cz.kopemar.listdetail.fragments.CommitsFragment
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.viewmodel.RepositoryViewModel
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.branches
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.commits
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.repo
import cz.kopemar.listdetail.views.adapters.BaseFragmentAdapter
import kotlinx.android.synthetic.main.activity_repository.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoryActivity : AppCompatActivity() {

    private val vm by viewModel<RepositoryViewModel>()
    private var binding: ActivityRepositoryBinding? = null

    private val fragments = listOf(
        CommitsFragment(),
        BranchesFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUi()
    }

    override fun onBackPressed() {
        finishActivity()
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

    private fun setUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repository)
        binding?.vm = vm

        vm.name = intent.getStringExtra(RepositoriesFragment.intent_text)
        setSupportActionBar(findViewById(R.id.vToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        vViewPager.adapter = BaseFragmentAdapter(fragments, supportFragmentManager)
        vTabs.setupWithViewPager(vViewPager)
    }

}