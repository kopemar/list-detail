package cz.kopemar.listdetail.fragments

import androidx.fragment.app.Fragment
import cz.kopemar.listdetail.activities.BaseActivity
import cz.kopemar.listdetail.R

/**
 * Fragment with a name (tab label in TabLayout)
 */
abstract class NamedFragment : Fragment() {

    open var fragmentName: Int = R.string.base_fragment

    protected fun checkConnection(): Boolean {
        activity?.let {
            return BaseActivity.checkConnection(it)
        }
        return false
    }
}