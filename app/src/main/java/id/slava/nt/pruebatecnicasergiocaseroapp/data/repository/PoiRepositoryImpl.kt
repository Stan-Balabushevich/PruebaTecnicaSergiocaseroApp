package id.slava.nt.pruebatecnicasergiocaseroapp.data.repository

import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDao
import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDbEntity
import id.slava.nt.pruebatecnicasergiocaseroapp.data.network.PoiApi
import id.slava.nt.pruebatecnicasergiocaseroapp.data.network.asDbModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

class PoiRepositoryImpl(private val poiDao: PoiDao): PoiRepository {

    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

    override fun getPoiList(): Flow<List<PoiDbEntity>> =
        poiDao.getListPoi()
            .flowOn(defaultDispatcher)
            .conflate()

    override suspend fun getPoiById(id: Int): PoiDbEntity? =
        poiDao.getPoiById(id)

    override suspend fun refreshPoiList() {

        withContext(defaultDispatcher){

            val poiData = PoiApi.retrofitService.getPoiList()

            if (poiData != null){

                poiDao.insertListPoi(poiData.asDbModel())

            }

        }

    }


}