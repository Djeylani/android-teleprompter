package com.example.androidteleprompter

import android.content.Context
import android.content.SharedPreferences

class ScriptManager(context: Context) {
    
    private val prefs: SharedPreferences = context.getSharedPreferences("teleprompter_scripts", Context.MODE_PRIVATE)
    
    companion object {
        private const val CURRENT_SCRIPT_KEY = "current_script"
        private const val LAST_SPEED_KEY = "last_speed"
        private const val SAVED_SCRIPTS_KEY = "saved_scripts"
        private const val SCRIPT_NAMES_KEY = "script_names"
        private const val TEXT_SIZE_KEY = "text_size"
    }
    
    fun saveCurrentScript(script: String) {
        prefs.edit().putString(CURRENT_SCRIPT_KEY, script).apply()
    }
    
    fun getCurrentScript(): String {
        return prefs.getString(CURRENT_SCRIPT_KEY, "") ?: ""
    }
    
    fun saveLastSpeed(speed: Int) {
        prefs.edit().putInt(LAST_SPEED_KEY, speed).apply()
    }
    
    fun getLastSpeed(): Int {
        return prefs.getInt(LAST_SPEED_KEY, 50)
    }
    
    fun saveTextSize(size: Int) {
        prefs.edit().putInt(TEXT_SIZE_KEY, size).apply()
    }
    
    fun getTextSize(): Int {
        return prefs.getInt(TEXT_SIZE_KEY, 22)
    }
    
    fun saveScript(name: String, content: String) {
        val savedScripts = getSavedScriptNames().toMutableSet()
        savedScripts.add(name)
        
        prefs.edit()
            .putStringSet(SCRIPT_NAMES_KEY, savedScripts)
            .putString("script_$name", content)
            .apply()
    }
    
    fun loadScript(name: String): String {
        return prefs.getString("script_$name", "") ?: ""
    }
    
    fun getSavedScriptNames(): Set<String> {
        return prefs.getStringSet(SCRIPT_NAMES_KEY, emptySet()) ?: emptySet()
    }
    
    fun deleteScript(name: String) {
        val savedScripts = getSavedScriptNames().toMutableSet()
        savedScripts.remove(name)
        
        prefs.edit()
            .putStringSet(SCRIPT_NAMES_KEY, savedScripts)
            .remove("script_$name")
            .apply()
    }
}