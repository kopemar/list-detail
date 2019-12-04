package cz.kopemar.listdetail.fragments

import androidx.fragment.app.Fragment
import cz.kopemar.listdetail.BaseActivity
import cz.kopemar.listdetail.R

abstract class NamedFragment : Fragment() {

    open var fragmentName: Int = R.string.base_fragment

    protected fun checkConnection(): Boolean {
        activity?.let {
            return BaseActivity.checkConnection(it)
        }
        return false
    }
}