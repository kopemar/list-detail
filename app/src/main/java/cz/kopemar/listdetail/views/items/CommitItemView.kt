package cz.kopemar.listdetail.views.items

import android.content.Context
import android.util.AttributeSet
import android.view.View
import cz.kopemar.listdetail.R
import kotlinx.android.synthetic.main.view_item_commit.view.*

class CommitItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ItemView(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_item_commit, this)
    }

    fun setCommitMessage(message: String) {
        vCommitMessage.text = message
    }

    fun setCommitDate(date: String) {
        vCommitMessage.text = date
    }

}