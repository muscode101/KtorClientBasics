package com.rff.ktorclientbasics.model

import com.google.gson.annotations.SerializedName
data class Profile(
    @SerializedName("id"               ) var id              : Int?              = null,
    @SerializedName("screen_timeout"   ) var screenTimeout   : Int?              = null,
    @SerializedName("country"          ) var country         : String?           = null,
    @SerializedName("app_title"        ) var appTitle        : String?           = null,
    @SerializedName("account"          ) var account         : String?           = null,
    @SerializedName("app_message"      ) var appMessage      : String?           = null,
    @SerializedName("short_message"    ) var shortMessage    : String?           = null,
    @SerializedName("full_message"     ) var fullMessage     : String?           = null,
    @SerializedName("nav_color"        ) var navColor        : String?           = null,
    @SerializedName("background_color" ) var backgroundColor : String?           = null,
    @SerializedName("background_url"   ) var backgroundUrl   : String?           = null,
    @SerializedName("is_exit_allowed"  ) var isExitAllowed   : Int?              = null,
    @SerializedName("allowed_apps"     ) var allowedApps     : List<ELKApp> = arrayListOf(),
    @SerializedName("created"          ) var created         : String?           = null,
    @SerializedName("modified"         ) var modified        : String?           = null
)