package cz.kopemar.listdetail

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import cz.kopemar.listdetail.databinding.ActivityRepositoryBinding
import cz.kopemar.listdetail.fragments.BranchesFragment
import cz.kopemar.listdetail.fragments.CommitsFragment
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.viewmodel.RepositoryDetailViewModel
import cz.kopemar.listdetail.views.adapters.BaseFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_repository.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class RepositoryActivity : BaseActivity() {

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
        finish()
        return true
    }

    private fun setUi() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repository)
        binding?.vm = vm

        intent.getStringExtra(RepositoriesFragment.INTENT_TEXT)?.let {
            vm.repositoryName = it
        }
        setSupportActionBar(findViewById(R.id.vToolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (checkConnection()) {
            vViewPager.adapter = BaseFragmentAdapter(fragments, this, supportFragmentManager)
            vTabs.setupWithViewPager(vViewPager)
        } else {
            Toast.makeText(this, resources.getText(R.string.no_connection), Toast.LENGTH_SHORT).show()
        }

    }

}