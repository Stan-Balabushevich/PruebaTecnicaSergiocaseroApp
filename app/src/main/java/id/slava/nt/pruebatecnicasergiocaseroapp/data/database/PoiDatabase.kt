package id.slava.nt.pruebatecnicasergiocaseroapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
    entities = [PoiDbEntity::class],
    version = 1)
abstract class PoiDatabase: RoomDatabase() {

    abstract val noteDao: PoiDao

    companion object{

        private const val DATABASE_NAME = "poi_list_db"

        @Volatile
        private var INSTANCE: PoiDatabase? = null

        fun getInstance(context: Context): PoiDatabase{

            synchronized(this){

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PoiDatabase::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }

        }
    }
}


