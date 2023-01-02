package id.slava.nt.pruebatecnicasergiocaseroapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "database_table_poi")
data class PoiDbEntity (

    @PrimaryKey val id: Int? = null,
    val title: String?,
    val coordinates: String?,
    val imageUrl: String?
    )