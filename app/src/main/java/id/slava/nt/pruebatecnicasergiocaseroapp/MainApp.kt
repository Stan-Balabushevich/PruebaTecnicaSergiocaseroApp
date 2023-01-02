package id.slava.nt.pruebatecnicasergiocaseroapp

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import id.slava.nt.pruebatecnicasergiocaseroapp.work.RefreshDataWorker
import java.util.concurrent.TimeUnit

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        setupRecurringWork()

    }


    private fun setupRecurringWork() {

        val repeatingRequest =
            PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.DAYS)
                .build()

        WorkManager.getInstance().enqueueUniquePeriodicWork(
            RefreshDataWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest)
    }


}