package ph.appsolutely.mvvm_test.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import ph.appsolutely.mvvm_test.App
import javax.inject.Singleton

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesApplicationContext(app: App): Context = app.applicationContext

}