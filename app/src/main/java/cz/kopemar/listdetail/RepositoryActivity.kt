package cz.kopemar.listdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cz.kopemar.listdetail.databinding.ActivityRepositoryBinding
import cz.kopemar.listdetail.fragments.BranchesFragment
import cz.kopemar.listdetail.fragments.CommitsFragment
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.BaseFragmentAdapter
import kotlinx.android.synthetic.main.activity_repository.*
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoryActivity : AppCompatActivity() {

    private val vm by viewModel<RepositoryDetailViewModel>()
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
        vm.repositoryName = null
        vm.commits = null
        vm. branches = null
        finish()

        return true
    }

    private fun setUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repository)
        binding?.vm = vm

        vm.name = intent.getStringExtra(RepositoriesFragment.INTENT_TEXT)
        setSupportActionBar(findViewById(R.id.vToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        vViewPager.adapter = BaseFragmentAdapter(fragments, this, supportFragmentManager)
        vTabs.setupWithViewPager(vViewPager)
    }

}