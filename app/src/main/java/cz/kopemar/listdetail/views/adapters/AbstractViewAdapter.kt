package cz.kopemar.listdetail.views.adapters

import androidx.recyclerview.widget.RecyclerView
import cz.kopemar.listdetail.model.AbstractEntity
import cz.kopemar.listdetail.views.viewholder.AbstractViewHolder
import cz.kopemar.listdetail.views.viewholder.RepoListViewHolder

abstract class AbstractViewAdapter<T : AbstractViewHolder>(val items: List<AbstractEntity>) :
    RecyclerView.Adapter<T>() {
    override fun getItemCount() = items.size
}