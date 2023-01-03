package id.slava.nt.pruebatecnicasergiocaseroapp.presentation.detail_poi

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase.PoiUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailPoiViewModel(
    private val savedStateHandle: SavedStateHandle,
    private val poiUseCases: PoiUseCases): ViewModel() {

   private val _poiState = MutableStateFlow(PoiDbEntity(title = "", coordinates = "", imageUrl = ""))
   val poiState = _poiState.asStateFlow()

   init {

       savedStateHandle.get<Int>("poiId")?.let { id ->

               viewModelScope.launch {
                   if (id != -1){
                       poiUseCases.getPoiById(id = id)?.also { poi ->
                           _poiState.value = poi
                       }
                   }
               }
       }
   }

}