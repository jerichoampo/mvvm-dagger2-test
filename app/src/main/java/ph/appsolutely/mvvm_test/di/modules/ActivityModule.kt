package ph.appsolutely.mvvm_test.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ph.appsolutely.mvvm_test.ui.login.LoginActivity
import ph.appsolutely.mvvm_test.ui.splash.SplashActivity

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */
@Module
abstract class ActivityModule {

//    @ContributesAndroidInjector
//    abstract fun contributesSplashActivity(): SplashActivity

    @ContributesAndroidInjector
    abstract fun contributesLoginActivity(): LoginActivity
}