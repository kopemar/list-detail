package cz.kopemar.listdetail.model

import com.google.gson.annotations.SerializedName

/**
 * Part of [CommitWrapper] - individual commit details.
 */
data class Commit(
    @SerializedName("message") val message: String,
    @SerializedName("committer") val committer: Committer
) : AbstractEntity()
