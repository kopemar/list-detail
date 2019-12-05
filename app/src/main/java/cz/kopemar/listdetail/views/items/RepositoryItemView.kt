package cz.kopemar.listdetail.views.items

import android.content.Context
import android.util.AttributeSet
import android.view.View
import cz.kopemar.listdetail.R
import cz.kopemar.listdetail.utils.parseDate
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

    fun setPushed(date: String) {
        vRepositoryUpdated.text = date.parseDate()
    }


}