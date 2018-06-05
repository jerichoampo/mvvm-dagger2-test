package ph.appsolutely.mvvm_test.ui.splash

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ph.appsolutely.mvvm_test.R
import ph.appsolutely.mvvm_test.data.Api
import javax.inject.Inject

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */
class SplashActivity: AppCompatActivity() {

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        AndroidInjection.inject(this)

        api.loginUser("jerickoh@yahoo.com", "1234")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    print("responded")
                    print(response.toString())
                }, {
                    print("failed")
                })

    }
}