package id.slava.nt.pruebatecnicasergiocaseroapp

import android.app.Application
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import id.slava.nt.pruebatecnicasergiocaseroapp.di.appModule
import id.slava.nt.pruebatecnicasergiocaseroapp.di.dataModule
import id.slava.nt.pruebatecnicasergiocaseroapp.di.domainModule
import id.slava.nt.pruebatecnicasergiocaseroapp.work.RefreshDataWorker
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.concurrent.TimeUnit

class MainApp: Application() {

    override fun onCreate() {
        super.onCreate()

        setupRecurringWork()

        startKoin {

            androidContext(this@MainApp)
            modules(
                dataModule,
                domainModule,
                appModule
            )

        }

    }

    private fun setupRecurringWork() {

        val repeatingRequest =
            PeriodicWorkRequestBuilder<RefreshDataWorker>(1, TimeUnit.DAYS)
                .build()

        WorkManager.getInstance(applicationContext).enqueueUniquePeriodicWork(
            RefreshDataWorker.WORK_NAME,
            ExistingPeriodicWorkPolicy.KEEP,
            repeatingRequest)
    }


}