package kg.bakai.test

import android.app.Application
import kg.bakai.test.di.appModule
import kg.bakai.test.di.repositoryModule
import kg.bakai.test.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(repositoryModule, viewModelModule, appModule))
        }
    }
}