package com.shubhans.taskmanager.data.manager

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.shubhans.taskmanager.domain.manager.LocalUserManager
import com.shubhans.taskmanager.presentation.util.Constants
import com.shubhans.taskmanager.presentation.util.Constants.USER_SETTINGS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class LocalUserImpl(
    private val context: Context
) : LocalUserManager {

    override suspend fun saveAppTheme(appTheme: Color) {
        // Save the ARGB value of the color as a string
        context.datastore.edit { settings ->
            settings[PreferencesKeys.APP_THEME] = appTheme.toArgb().toString()
        }
    }

    override suspend fun saveAppEntry() {
        context.datastore.edit { settings ->
            settings[PreferencesKeys.APP_ENTRY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return context.datastore.data.map { preferences ->
            preferences[PreferencesKeys.APP_ENTRY] ?: false
        }
    }

    override suspend fun readAppTheme(): Color? {
        return context.datastore.data.map { preferences ->
            preferences[PreferencesKeys.APP_THEME]?.toIntOrNull()?.let { Color(it) }
        }.firstOrNull() // Get the first emitted value or null if no value exists
    }
}

// Get instance of data store
private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = USER_SETTINGS)

// Preference keys for DataStore
private object PreferencesKeys {
    val APP_THEME = stringPreferencesKey(Constants.APP_THEME) // Key for app theme
    val APP_ENTRY = booleanPreferencesKey(Constants.APP_ENTRY) // Key for app entry
}