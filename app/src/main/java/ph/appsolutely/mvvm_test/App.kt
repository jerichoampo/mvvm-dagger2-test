package ph.appsolutely.mvvm_test

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */
class App: DaggerApplication() {

    override fun onCreate() {
        super.onCreate()

        print(applicationContext.toString())

    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
                .builder()
                .application(this)
                .build()
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}