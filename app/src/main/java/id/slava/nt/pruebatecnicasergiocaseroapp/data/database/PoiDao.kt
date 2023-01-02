package id.slava.nt.pruebatecnicasergiocaseroapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PoiDao {

    @Query("SELECT * FROM database_table_poi")
    fun getListPoi(): Flow<List<PoiDbEntity>>

    @Query("SELECT * FROM database_table_poi WHERE id = :id")
    suspend fun getPoiById(id: Int): PoiDbEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertListPoi(poiList: List<PoiDbEntity>)

    @Query("select * from database_table_poi where title like '%' || :text|| '%' ")
    fun getSearchTitle(text: String): Flow<List<PoiDbEntity>>


}