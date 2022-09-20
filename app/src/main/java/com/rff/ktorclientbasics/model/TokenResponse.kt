package com.rff.ktorclientbasics.model


data class TokenResponse(
    var success: Boolean? = null,
    var token: Token? = Token(),
    var errors: ArrayList<String> = arrayListOf(),
    var messages: ArrayList<String> = arrayListOf()
)