package cz.kopemar.listdetail.model

import com.google.gson.annotations.SerializedName

/**
 * Individual Github repository
 */
data class Repository(
    @SerializedName("name") val name: String,
    @SerializedName("pushed_at") val last_pushed: String
) : AbstractEntity()
