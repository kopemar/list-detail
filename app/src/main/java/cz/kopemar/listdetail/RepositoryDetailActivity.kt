package cz.kopemar.listdetail

import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import cz.kopemar.listdetail.fragments.CommitsFragment
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.viewmodel.MainViewModel
import cz.kopemar.listdetail.viewmodel.RepositoryViewModel
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.branches
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.commits
import cz.kopemar.listdetail.viewmodel.holder.CommitsHolder.Companion.repo
import org.koin.android.viewmodel.ext.android.viewModel

class RepositoryDetailActivity: AppCompatActivity() {

    private val vm by viewModel<RepositoryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repository)

        repo = intent.getStringExtra(RepositoriesFragment.intent_text)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager.beginTransaction()
            .replace(R.id.vRepoFrame, CommitsFragment()).commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        repo = null
        commits = null
        branches = null
        finish()
        return true
    }
}