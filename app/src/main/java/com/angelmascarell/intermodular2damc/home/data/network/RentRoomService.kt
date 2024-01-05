package com.angelmascarell.intermodular2damc.home.data.network

import com.angelmascarell.intermodular2damc.home.data.model.RentRoomModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RentRoomService @Inject constructor(private val api: RentRoomClient) {
    suspend fun getRentRooms():List<RentRoomModel>{
        return withContext(Dispatchers.IO){
            val response = api.getRentRooms()
            if (response.isSuccessful) {
                val rentRoomsResponse = response.body()
                rentRoomsResponse ?: emptyList()
            } else {
                emptyList()
            }
        }
    }
}