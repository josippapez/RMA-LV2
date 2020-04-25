package hr.ferit.josip.rma_lv2_1

import android.app.Application
import android.content.Context

class ImportantPeopleApplication : Application() {
    companion object {
        lateinit var ApplicationContext: Context
            private set
    }
    override fun onCreate() {
        super.onCreate()
        ApplicationContext = this
    }
}