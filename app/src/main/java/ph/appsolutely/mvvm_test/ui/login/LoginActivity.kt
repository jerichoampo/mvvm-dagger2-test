package ph.appsolutely.mvvm_test.ui.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_login.*
import ph.appsolutely.mvvm_test.R
import ph.appsolutely.mvvm_test.data.Api
import javax.inject.Inject

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */
class LoginActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            api.loginUser(input_email.text.toString(), input_password.text.toString())
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
}