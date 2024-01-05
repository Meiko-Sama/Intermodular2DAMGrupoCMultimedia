package com.angelmascarell.intermodular2damc.home.data.model

import com.google.gson.annotations.SerializedName
data class RentRoomModel(
    val number: Int,
    val type: String,
    val beds: Int,
    val available: Boolean,
    val price: Double
)