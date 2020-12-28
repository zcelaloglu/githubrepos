package com.celaloglu.zafer.models.response

import com.google.gson.annotations.SerializedName

data class ReposResponse(
    @SerializedName("stargazers_count")
    var stargazersCount: Int? = null,
    var id: Long,
    var name: String? = null,
    @SerializedName("open_issues_count")
    var openIssuesCount: Int? = null,
    var owner: Owner? = null
)