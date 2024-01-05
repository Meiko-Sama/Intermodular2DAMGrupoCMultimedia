package com.angelmascarell.intermodular2damc.home.data.network

import com.angelmascarell.intermodular2damc.home.data.model.RentRoomModel
import retrofit2.Response
import retrofit2.http.GET

interface RentRoomClient {
    @GET("room/getAll")
    suspend fun getRentRooms(): Response<List<RentRoomModel>>
}