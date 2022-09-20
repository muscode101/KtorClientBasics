package com.rff.ktorclientbasics.model


data class Profile(
    val id: Int,
    val screenTimeout: Int,
    val country: String,
    val appTitle: String,
    val account: String,
    val appMessage: String,
    val shotMessage: String,
    val fullMessage: String,
    val navColor: String,
    val backgroundColor: String,
    val backgroundUrl: String,
    val isExitAllowed: Boolean,
    val allowedApps: List<ELKApp>,
)