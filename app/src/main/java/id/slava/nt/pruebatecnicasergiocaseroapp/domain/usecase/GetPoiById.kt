package id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase

import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.repository.PoiRepository

class GetPoiById(private val repository: PoiRepository) {

    suspend operator fun invoke(id: Int): PoiDbEntity? =
    repository.getPoiById(id = id)

}