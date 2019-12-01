package cz.kopemar.listdetail.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import cz.kopemar.listdetail.R
import kotlinx.android.synthetic.main.view_item.view.*

class RepositoryItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ItemView(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.view_item, this)
    }

    fun setName(name: String) {
        vRepositoryName.text = name
    }

    fun setUpdated(date: String) {
        vRepositoryUpdated.text = date
    }


}