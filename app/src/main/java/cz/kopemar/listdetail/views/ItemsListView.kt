package cz.kopemar.listdetail.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.views.adapters.AbstractViewAdapter
import cz.kopemar.listdetail.views.listener.OnListItemClickedListener
import kotlinx.android.synthetic.main.view_list.view.*

class ItemsListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var listener: OnListItemClickedListener? = null

    var adapter: AbstractViewAdapter<*>? = null
    set(value) {
        field = value
        vListView.adapter = value
    }

    init {
        View.inflate(context, R.layout.view_list, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        vListView.apply {
            adapter = this@ItemsListView.adapter
            layoutManager = LinearLayoutManager(context)
            layoutManager?.isMeasurementCacheEnabled = false
        }
    }

}