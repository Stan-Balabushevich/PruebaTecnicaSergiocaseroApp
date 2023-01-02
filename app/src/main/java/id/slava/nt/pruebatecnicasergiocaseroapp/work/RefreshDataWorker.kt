package id.slava.nt.pruebatecnicasergiocaseroapp.work

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import id.slava.nt.pruebatecnicasergiocaseroapp.data.database.PoiDatabase
import id.slava.nt.pruebatecnicasergiocaseroapp.data.repository.PoiRepositoryImpl
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters):
    CoroutineWorker(appContext, params) {

    override suspend fun doWork(): Result {

        val database = PoiDatabase.getInstance(applicationContext)
        val repository = PoiRepositoryImpl(database.noteDao)


        try {

            repository.refreshPoiList()

        } catch (e: HttpException) {
            Log.d("RefreshDataWorker",e.toString())
            return Result.retry()

        }

        return Result.success()

    }

    companion object {
        const val WORK_NAME = "id.slava.nt.pruebatecnicasergiocaseroapp.work.RefreshDataWorker"
    }
}