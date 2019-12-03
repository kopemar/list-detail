package cz.kopemar.listdetail.views.adapters

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import cz.kopemar.listdetail.fragments.NamedFragment

class BaseFragmentAdapter(private val fragments: List<NamedFragment>, var context: Context, var manager: FragmentManager) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int): String? {
        return context.resources.getString(fragments[position].fragmentName) }

    override fun getCount() = fragments.size
}