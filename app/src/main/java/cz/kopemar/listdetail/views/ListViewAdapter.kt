package cz.kopemar.listdetail.views

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cz.kopemar.listdetail.model.Repository

class ListViewAdapter(private val repositories: List<Repository>) : RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(ItemView(parent.context))

    override fun getItemCount() = repositories.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.view.apply {
            setName(repositories[position].name)
            setUpdated(repositories[position].updated)
        }
    }
}
