package com.angelmascarell.intermodular2damc.home.data.model

import javax.inject.Inject

class RentRoomProvider @Inject constructor() {
    var rentRooms: List<RentRoomModel> = emptyList()
}