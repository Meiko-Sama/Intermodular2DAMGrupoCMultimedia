package com.angelmascarell.intermodular2damc.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelmascarell.intermodular2damc.home.data.model.RentRoomModel
import com.angelmascarell.intermodular2damc.home.domain.GetRentRoomsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    var getRentRoomsUseCase: GetRentRoomsUseCase
): ViewModel() {
    private val _rentRooms = MutableLiveData<List<RentRoomModel>>()
    val rentRooms: LiveData<List<RentRoomModel>> = _rentRooms

    init {
        loadRentRooms()
    }
    private fun loadRentRooms() {
        viewModelScope.launch {
            val result: List<RentRoomModel> = getRentRoomsUseCase()

            _rentRooms.postValue(result.take(4))
        }
    }
}