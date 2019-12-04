package cz.kopemar.listdetail.activities

import android.os.Bundle
import android.widget.Toast
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.fragments.AboutFragment
import cz.kopemar.listdetail.fragments.RepositoriesFragment
import cz.kopemar.listdetail.views.adapters.BaseFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

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

        if (checkConnection(this)) {
            vMainViewPager.adapter = BaseFragmentAdapter(fragments, this, supportFragmentManager)
            vMainTabs.setupWithViewPager(vMainViewPager)
        } else {
            Toast.makeText(this, resources.getText(R.string.no_connection), Toast.LENGTH_SHORT).show()
        }

    }

}
