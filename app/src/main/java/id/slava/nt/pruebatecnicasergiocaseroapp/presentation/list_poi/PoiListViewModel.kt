package id.slava.nt.pruebatecnicasergiocaseroapp.presentation.list_poi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase.PoiUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PoiListViewModel(private val poiUseCases: PoiUseCases): ViewModel() {

    private val _poiListState = MutableStateFlow<List<PoiDbEntity>>(emptyList())
    val poiListState: StateFlow<List<PoiDbEntity>> = _poiListState

    init {

            getPoiList()


    }

    private fun getPoiList(){

        viewModelScope.launch {
            poiUseCases.getPoiList().collect{
                _poiListState.value = it
            }

        }
    }

    fun setSearchText(text: String) {

    }
}