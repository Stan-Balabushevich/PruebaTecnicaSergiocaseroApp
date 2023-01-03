package id.slava.nt.pruebatecnicasergiocaseroapp.di

import id.slava.nt.pruebatecnicasergiocaseroapp.presentation.detail_poi.DetailPoiViewModel
import id.slava.nt.pruebatecnicasergiocaseroapp.presentation.list_poi.PoiListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        PoiListViewModel(poiUseCases = get())
    }

    viewModel {
        DetailPoiViewModel(poiUseCases = get(), savedStateHandle = get())
    }

}