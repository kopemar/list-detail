package cz.kopemar.listdetail.fragments

import androidx.fragment.app.Fragment
import cz.kopemar.listdetail.R

abstract class NamedFragment: Fragment() {

    open var fragmentName: Int = R.string.base_fragment

}