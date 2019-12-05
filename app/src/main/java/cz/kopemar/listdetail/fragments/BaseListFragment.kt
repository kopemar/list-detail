package cz.kopemar.listdetail.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.kopemar.listdetail.R
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * Abstract [NamedFragment] that puts data into ItemsListView.
 */
abstract class BaseListFragment : NamedFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (checkConnection()) {
            waitForResponse()
            vSwipeRefresh.setOnRefreshListener {
                refresh()
            }
        }
    }

    abstract fun waitForResponse()

    abstract fun refresh()
}