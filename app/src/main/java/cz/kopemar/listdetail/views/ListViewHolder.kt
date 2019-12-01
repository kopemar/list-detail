package cz.kopemar.listdetail.views

import androidx.recyclerview.widget.RecyclerView

class ListViewHolder(val view: RepositoryItemView): RecyclerView.ViewHolder(view) {

    interface OnListItemClickedListener {
        fun onItemClick(position: Int)
    }

}