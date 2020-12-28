package com.celaloglu.zafer.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReposItem(
    val githubId: Long,
    val userName: String?,
    val repoName: String?,
    val avatarUrl: String?,
    val stargazersCount: Int?,
    val openIssueCount: Int?,
    var isBookmarked: Boolean?
) : Parcelable