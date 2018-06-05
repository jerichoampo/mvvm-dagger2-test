package ph.appsolutely.mvvm_test.data

import io.reactivex.Observable
import ph.appsolutely.mvvm_test.data.response.AuthResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by Jibo on 6/1/18.
 * jericho@appsolutely.ph
 */
interface Api {

//    @FormUrlEncoded
//    @POST("login")
//    fun loginUser(@Field("email") email: String,
//                  @Field("password") password: String): Observable<User>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(@Field("email") email: String,
                  @Field("password") password: String): Observable<AuthResponse>


}