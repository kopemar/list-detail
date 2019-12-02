package cz.kopemar.listdetail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import cz.kopemar.listdetail.R
import kotlinx.android.synthetic.main.fragment_list.*

abstract class BaseListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        waitForResponse()
        vSwipeRefresh.setOnRefreshListener {
            refresh()
        }
    }

    open fun getFragmentName() = context?.resources?.getString(R.string.base_fragment)

    abstract fun waitForResponse()

    abstract fun refresh()
}