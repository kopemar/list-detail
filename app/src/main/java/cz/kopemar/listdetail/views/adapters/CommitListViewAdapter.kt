package cz.kopemar.listdetail.views.adapters

import android.view.ViewGroup
import cz.kopemar.listdetail.model.CommitWrapper
import cz.kopemar.listdetail.views.CommitItemView
import cz.kopemar.listdetail.views.listener.OnListItemClickedListener
import cz.kopemar.listdetail.views.viewholder.CommitListViewHolder

class CommitListViewAdapter(private val commits: List<CommitWrapper>, var listener: OnListItemClickedListener?) :
    AbstractViewAdapter<CommitListViewHolder>(commits) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommitListViewHolder {
        val vh = CommitListViewHolder(
            CommitItemView(parent.context)
        )

        vh.view.setOnClickListener {
            listener?.onItemClick(vh.adapterPosition)
        }

        return vh
    }

    override fun onBindViewHolder(holder: CommitListViewHolder, position: Int) {
        holder.commitItemView.apply {
            setCommitMessage(commits[position].commit.message)
        }
    }

}