package com.coxtunes.datastorejetpack.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserManager (private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "USER_DATASTORE_PREFERENCE")

    //Create KEY for Store Data
    companion object {
        val USER_NAME_KEY = stringPreferencesKey("USER_NAME")
        val USER_EMAIL_KEY = stringPreferencesKey("USER_EMAIL")
    }

    //Store user data into DataStore
    suspend fun storeUser(name: String, email: String) {
        context.dataStore.edit {
            it[USER_NAME_KEY] = name
            it[USER_EMAIL_KEY] = email
        }
    }

    suspend fun clearName(){
        context.dataStore.edit {
            if (it.contains(USER_NAME_KEY)) {
                it.remove(USER_NAME_KEY)
            }
        }
    }

    suspend fun clearEmail(){
        context.dataStore.edit {
            if (it.contains(USER_EMAIL_KEY)) {
                it.remove(USER_EMAIL_KEY)
            }
        }
    }

    //Get user Name with flow
    val userNameFlow: Flow<String?> = context.dataStore.data.map {
        it[USER_NAME_KEY]
    }

    //Get user email  with flow
    val userEmailFlow: Flow<String?> = context.dataStore.data.map {
        it[USER_EMAIL_KEY]
    }
}
