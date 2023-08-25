import android.content.Context
import android.content.SharedPreferences
import com.example.mathforkids.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UserRepository(private val context: Context) {
    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
    }

    fun saveUsers(users: List<User>) {
        val gson = Gson()
        val usersJson = gson.toJson(users)

        sharedPreferences.edit().putString("users", usersJson).apply()
    }

    fun loadUsers(): List<User>? {
        val usersJson = sharedPreferences.getString("users", null)

        return if (usersJson != null) {
            val typeToken = object : TypeToken<List<User>>() {}.type
            Gson().fromJson<List<User>>(usersJson, typeToken)
        } else {
            null
        }
    }

    fun getCurrentUser(): User? {
        return loadUsers()?.firstOrNull { it.selected }
    }
}
