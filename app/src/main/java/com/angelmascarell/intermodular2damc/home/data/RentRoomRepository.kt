package com.angelmascarell.intermodular2damc.home.data

import com.angelmascarell.intermodular2damc.home.data.model.RentRoomModel
import com.angelmascarell.intermodular2damc.home.data.model.RentRoomProvider
import com.angelmascarell.intermodular2damc.home.data.network.RentRoomService
import javax.inject.Inject

class RentRoomRepository @Inject constructor(
    private val api: RentRoomService,
    private val rentRoomProvider: RentRoomProvider) {
    suspend fun getRentRooms(): List<RentRoomModel>{
        val response: List<RentRoomModel> = api.getRentRooms()
        rentRoomProvider.rentRooms = response
        return response
    }
}