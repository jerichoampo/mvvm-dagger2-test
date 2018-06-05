package ph.appsolutely.mvvm_test.di.modules

import android.content.Context
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import ph.appsolutely.mvvm_test.BuildConfig
import ph.appsolutely.mvvm_test.data.Api
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(ChuckInterceptor(context))
                .build()
    }

    @Provides
    @Singleton
    fun providesApi(client: OkHttpClient): Api {
         val retrofit = Retrofit.Builder()
                                 .client(client)
                                 .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                 .addConverterFactory(GsonConverterFactory.create())
                                 .baseUrl(BuildConfig.API_URL)
                                 .build()

         return retrofit.create(Api::class.java)

    }


}