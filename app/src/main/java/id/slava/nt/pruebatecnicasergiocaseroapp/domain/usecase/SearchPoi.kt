package id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase

import id.slava.nt.pruebatecnicasergiocaseroapp.domain.repository.PoiRepository

class SearchPoi(private val repository: PoiRepository) {

    operator fun invoke(text: String) =
        repository.getSearchTitle(text)


}