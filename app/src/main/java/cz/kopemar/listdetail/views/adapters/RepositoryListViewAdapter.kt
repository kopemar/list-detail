package cz.kopemar.listdetail.views.adapters

import android.view.ViewGroup
import cz.kopemar.listdetail.model.Repository
import cz.kopemar.listdetail.views.RepositoryItemView
import cz.kopemar.listdetail.views.listener.OnListItemClickedListener
import cz.kopemar.listdetail.views.viewholder.RepoListViewHolder

class RepositoryListViewAdapter(private val repositories: List<Repository>, var listener: OnListItemClickedListener?) :
    AbstractViewAdapter<RepoListViewHolder>(repositories) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListViewHolder {
        val vh = RepoListViewHolder(
            RepositoryItemView(parent.context)
        )

        vh.repoItemView.setOnClickListener {
            listener?.onItemClick(vh.adapterPosition)
        }

        return vh
    }

    override fun onBindViewHolder(holder: RepoListViewHolder, position: Int) {
        holder.repoItemView.apply {
            setName(repositories[position].name)
            setUpdated(repositories[position].updated)
        }
    }

}
