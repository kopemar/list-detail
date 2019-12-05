package cz.kopemar.listdetail.model

import com.google.gson.annotations.SerializedName

/**
 * Author of [Commit]. Date of [Commit] is included here.
 */
data class Committer(
    @SerializedName("name") val name: String,
    @SerializedName("date") val date: String
) :
    AbstractEntity()