package cz.kopemar.listdetail.views

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.kopemar.listdetail.model.Repository

class ListViewAdapter(private val repositories: List<Repository>, var listener: ListViewHolder.OnListItemClickedListener?) :
    RecyclerView.Adapter<ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var vh = ListViewHolder(RepositoryItemView(parent.context))

        vh.view.setOnClickListener {
            listener?.onItemClick(vh.adapterPosition)
        }

        return vh
    }

    override fun getItemCount() = repositories.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.view.apply {
            setName(repositories[position].name)
            setUpdated(repositories[position].updated)
        }
    }

    companion object {
        const val intent_text = "REPOSITORY_NAME"
    }
}
