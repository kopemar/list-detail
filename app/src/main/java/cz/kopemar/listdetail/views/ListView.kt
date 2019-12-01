package cz.kopemar.listdetail.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.Repository
import kotlinx.android.synthetic.main.view_list.view.*

class ListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_list, this)
    }

    var dataset : List<Repository> = ArrayList()
    set(value){
        field = value
        vListView.apply {
            adapter = ListViewAdapter(dataset)
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        vListView.apply {
            adapter = ListViewAdapter(dataset)
            layoutManager = LinearLayoutManager(context)
        }

    }
}