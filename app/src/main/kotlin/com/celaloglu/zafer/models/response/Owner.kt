package com.celaloglu.zafer.models.response

import com.google.gson.annotations.SerializedName

data class Owner(
    val login: String? = null,
    @SerializedName("avatar_url")
    val avatarUrl: String? = null
)