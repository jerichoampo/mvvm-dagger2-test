package ph.appsolutely.mvvm_test.auth

/**
 * Created by Jibo on 6/4/18.
 * jericho@appsolutely.ph
 */
interface Session {

    fun isLoggedIn(): Boolean

    fun saveSessionToken()

    fun getSessionToken(): String
}