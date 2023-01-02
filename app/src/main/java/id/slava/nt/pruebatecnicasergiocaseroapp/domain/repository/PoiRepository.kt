package id.slava.nt.pruebatecnicasergiocaseroapp.domain.repository

import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity
import kotlinx.coroutines.flow.Flow

interface PoiRepository {

    fun getPoiList(): Flow<List<PoiDbEntity>>

    suspend fun getPoiById(id: Int): PoiDbEntity?

    suspend fun refreshPoiList()


}