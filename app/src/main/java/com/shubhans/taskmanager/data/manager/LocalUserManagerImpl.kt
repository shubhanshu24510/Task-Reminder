package com.shubhans.taskmanager.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.shubhans.taskmanager.domain.manager.LocalUserManager
import com.shubhans.taskmanager.domain.model.AppTheme
import com.shubhans.taskmanager.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalUserImpl(
    private val context: Context
) : LocalUserManager {
    override suspend fun saveAppTheme(appTheme: String) {
        context.datastore.edit { settings ->
            settings[PreferencesKeys.APP_THEME] = appTheme
        }
    }

    override fun readAppTheme(): Flow<String> {
        return context.datastore.data.map { preferences ->
            preferences[PreferencesKeys.APP_THEME] ?: AppTheme.LIGHT_FIRST.name
        }
    }

    override suspend fun saveAppEntry() {
        context.datastore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.datastore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] == true
        }
    }
}

// Extension property for DataStore
private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = Constants.USER_SETTINGS)

// Preferences keys
private object PreferencesKeys {
    val APP_THEME = stringPreferencesKey(Constants.APP_THEME)
    val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY)
}