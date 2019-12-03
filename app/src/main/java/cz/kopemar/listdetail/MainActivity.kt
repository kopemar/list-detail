package cz.kopemar.listdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import cz.kopemar.listdetail.fragments.AboutFragment
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.views.adapters.BaseFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragments = listOf(
        RepositoriesFragment(),
        AboutFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setUi()
    }

    private fun setUi() {
        setContentView(R.layout.activity_main)
        
        vMainViewPager.adapter = BaseFragmentAdapter(fragments, this, supportFragmentManager)
        vMainTabs.setupWithViewPager(vMainViewPager)
    }

}
