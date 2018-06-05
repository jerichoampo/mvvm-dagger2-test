package ph.appsolutely.mvvm_test.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ph.appsolutely.mvvm_test.App
import ph.appsolutely.mvvm_test.di.modules.ActivityModule
import ph.appsolutely.mvvm_test.di.modules.AppModule
import ph.appsolutely.mvvm_test.di.modules.NetworkModule
import javax.inject.Singleton

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, ActivityModule::class,
        NetworkModule::class, AndroidSupportInjectionModule::class))
interface AppComponent: AndroidInjector<App>{

    @Component.Builder
    abstract class Builder {
        @BindsInstance
        abstract fun application(application: Application): Builder

        abstract fun build(): AndroidInjector<App>
    }
}