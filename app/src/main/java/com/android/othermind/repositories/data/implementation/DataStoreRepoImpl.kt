package com.android.othermind.repositories.data.implementation

/**
 * created by ansar abbas
 */
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import com.android.othermind.models.auth.UserModel
import com.android.othermind.repositories.data.abstraction.DataStoreRepository
import com.android.othermind.utils.*
import com.mobizion.base.utils.TOKEN_PREFIX
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class DataStoreRepoImpl(private val context: Context) : DataStoreRepository {

    override suspend fun putString(key: String, value: String) {
        val preferencesKey = stringPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun putInt(key: String, value: Int) {
        val preferencesKey = intPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun putBoolean(key: String, value: Boolean) {
        val preferencesKey = booleanPreferencesKey(key)
        context.dataStore.edit { preferences ->
            preferences[preferencesKey] = value
        }
    }

    override suspend fun getBoolean(key: String): Boolean {
        val preferencesKey = booleanPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[preferencesKey] ?: false
    }

    override suspend fun getString(key: String): String {
        val preferencesKey = stringPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[preferencesKey] ?: ""
    }

    override suspend fun getToken(): String {
        val preferences = context.dataStore.data.first()
        return preferences[TOKEN] ?: ""
    }

    override suspend fun getFcmToken(): String {
        var fcmToken = getString(_FCM_TOKEN)
        if (fcmToken.isEmpty()) {
            try {
                // fcmToken = FirebaseMessaging.getInstance().token.await()
                putString(_FCM_TOKEN, fcmToken)
            } catch (exception: Exception) {
                Log.v("Exception", "Unknown Error occurred")
            }
        }
        return fcmToken
    }

    override val language: Flow<String>
        get() = context.dataStore.data.map { preferences ->
            preferences[LANGUAGE] ?: ENGLISH
        }

    override suspend fun getInt(key: String): Int? {
        val preferencesKey = intPreferencesKey(key)
        val preferences = context.dataStore.data.first()
        return preferences[preferencesKey]
    }

    private suspend fun getLanguage(): String {
        val preferences = context.dataStore.data.first()
        return preferences[LANGUAGE] ?: ENGLISH
    }

    private suspend fun putLanguage(value: String) {
        context.dataStore.edit { preferences ->
            preferences[LANGUAGE] = value
        }
    }

    override suspend fun changeLanguage() {
        val language = getLanguage()
        if (language == ENGLISH) {
            putLanguage(ARABIC)
        } else {
            putLanguage(ENGLISH)
        }
    }


    override suspend fun saveUserInfo(user: UserModel, token: String) {
        context.dataStore.edit { preferences ->
            preferences[ID] = user.id
//            preferences[FULL_NAME] = user.full_name
//            preferences[AVATAR] = user.avatar?:""
//            preferences[EMAIL] = user.email
//            preferences[SHOULD_UPDATE_EMAIL] = user.need_email
//            preferences[ICONS] = user.icons
//            preferences[POINTS] = user.points
//            preferences[ABOUT] = user.about
            if (token.isNotEmpty()) {
                preferences[TOKEN] = TOKEN_PREFIX + token
            }
        }
    }

    override val user: Flow<UserModel>
        get() = context.dataStore.data.map { preferences ->
            UserModel(
                preferences[ID] ?: -1,
//                preferences[AVATAR]?:"",
//                preferences[EMAIL]?:"",
//                preferences[FULL_NAME]?:"",
//                preferences[ID] ?: -1,
//                preferences[SHOULD_UPDATE_EMAIL]?:false,
//                (preferences[ICONS]?:""),
//                preferences[POINTS]?:0,
//                preferences[ABOUT]?:""
            )
        }

    override val token: Flow<String>
        get() = context.dataStore.data.map { preferences ->
            preferences[TOKEN] ?: ""
        }

    override suspend fun clearData() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}