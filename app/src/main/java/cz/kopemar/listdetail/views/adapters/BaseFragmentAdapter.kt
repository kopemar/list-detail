package cz.kopemar.listdetail.views.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import cz.kopemar.listdetail.fragments.BaseListFragment

class BaseFragmentAdapter(private val fragments: List<BaseListFragment>, var manager: FragmentManager) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = fragments[position]

    override fun getPageTitle(position: Int) = fragments[position].getFragmentName()

    override fun getCount() = fragments.size
}