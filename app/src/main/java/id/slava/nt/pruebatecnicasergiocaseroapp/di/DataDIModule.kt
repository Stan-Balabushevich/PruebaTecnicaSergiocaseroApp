package id.slava.nt.pruebatecnicasergiocaseroapp.di

import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDatabase
import id.slava.nt.pruebatecnicasergiocaseroapp.data.repository.PoiRepositoryImpl
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.repository.PoiRepository
import org.koin.dsl.module

val dataModule = module {

    single { PoiDatabase.getInstance( get() ) }

    single {
        get<PoiDatabase>().poiDao
    }

    single<PoiRepository> {
        PoiRepositoryImpl( poiDao = get())  }

}