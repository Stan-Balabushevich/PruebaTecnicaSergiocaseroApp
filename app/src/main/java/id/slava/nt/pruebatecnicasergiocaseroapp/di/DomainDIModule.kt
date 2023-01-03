package id.slava.nt.pruebatecnicasergiocaseroapp.di

import id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase.GetPoiById
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase.GetPoiList
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase.PoiUseCases
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase.SearchPoi
import org.koin.dsl.module

val domainModule = module{

    factory {
        PoiUseCases(
            getPoiList = GetPoiList(repository = get()),
            getPoiById = GetPoiById(repository = get()),
            searchPoi = SearchPoi(repository = get())
        )
    }


}