package com.angelmascarell.intermodular2damc.home.domain

import com.angelmascarell.intermodular2damc.home.data.RentRoomRepository
import com.angelmascarell.intermodular2damc.home.data.model.RentRoomModel
import javax.inject.Inject

class GetRentRoomsUseCase @Inject constructor(private val repository: RentRoomRepository) {
    suspend operator fun invoke():List<RentRoomModel> = repository.getRentRooms()
}