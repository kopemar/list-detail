package cz.kopemar.listdetail.views.adapters

import android.view.ViewGroup
import cz.kopemar.listdetail.model.Branch
import cz.kopemar.listdetail.views.BranchItemView
import cz.kopemar.listdetail.views.viewholder.BranchViewHolder

class BranchViewAdapter(val branch: List<Branch>): AbstractViewAdapter<BranchViewHolder>(branch) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranchViewHolder {
        val vh = BranchViewHolder(
            BranchItemView(parent.context)
        )
        return vh
    }

    override fun onBindViewHolder(holder: BranchViewHolder, position: Int) {
        holder.branchItemView.setBranchName(branch[position].name)
    }
}