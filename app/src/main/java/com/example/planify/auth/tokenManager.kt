package com.example.planify.auth

import android.content.Context

object tokenManager {
    fun getToken(context: Context): String? {
        val prefs = context.getSharedPreferences("PlanifyPrefs", Context.MODE_PRIVATE)
        return prefs.getString("accessToken", null)
    }
}