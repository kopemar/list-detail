package cz.kopemar.listdetail.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.AbsListView
import android.widget.FrameLayout
import androidx.recyclerview.widget.LinearLayoutManager
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.model.AbstractEntity
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.views.adapters.AbstractViewAdapter
import cz.kopemar.listdetail.views.adapters.RepositoryListViewAdapter
import cz.kopemar.listdetail.views.listener.OnListItemClickedListener
import cz.kopemar.listdetail.views.viewholder.AbstractViewHolder
import cz.kopemar.listdetail.views.viewholder.RepoListViewHolder
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

//    var dataset: List<AbstractEntity>? = null

    override fun onFinishInflate() {
        super.onFinishInflate()

        vListView.apply {
            adapter = this@ItemsListView.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

}