package com.android.othermind.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

const val APP_LANGUAGE = "lang"
const val AUTH_TOKEN = "token"
const val _FCM_TOKEN = "fcmToken"

const val APP_PREFERENCES = "other_mind_preferences"
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = APP_PREFERENCES)

val LANGUAGE = stringPreferencesKey(APP_LANGUAGE)
val TOKEN = stringPreferencesKey(AUTH_TOKEN)
val FCM_TOKEN = stringPreferencesKey(_FCM_TOKEN)

const val USER_AVATAR = "avatar"
const val USER_FULL_NAME = "fullName"
const val USER_EMAIL = "email"
const val USER_ID = "userId"
const val SHOULD_UPDATE = "update_email"
const val USER_POINTS = "points"
const val USER_ICONS = "icons"
const val USER_ABOUT = "about"

val AVATAR = stringPreferencesKey(USER_AVATAR)
val FULL_NAME = stringPreferencesKey(USER_FULL_NAME)
val EMAIL = stringPreferencesKey(USER_EMAIL)
val SHOULD_UPDATE_EMAIL = booleanPreferencesKey(SHOULD_UPDATE)
val ID = intPreferencesKey(USER_ID)
val POINTS = intPreferencesKey(USER_POINTS)
val ICONS = stringPreferencesKey(USER_ICONS)
val ABOUT = stringPreferencesKey(USER_ABOUT)