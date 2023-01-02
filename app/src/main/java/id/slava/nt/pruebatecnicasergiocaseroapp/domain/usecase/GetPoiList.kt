package id.slava.nt.pruebatecnicasergiocaseroapp.domain.usecase

import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity
import id.slava.nt.pruebatecnicasergiocaseroapp.domain.repository.PoiRepository
import kotlinx.coroutines.flow.Flow

class GetPoiList(private val repository: PoiRepository) {

    operator fun invoke(): Flow<List<PoiDbEntity>> =
        repository.getPoiList()


}