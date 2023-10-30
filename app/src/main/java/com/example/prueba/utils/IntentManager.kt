package com.example.prueba.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.example.prueba.ui.activity.IntentActivity

object IntentManager {

    fun Openweb(activity: Activity, url:String){
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.javiercarrasco.es")
        )
        if (intent.resolveActivity(activity.packageManager) != null) {
            activity.startActivity(intent)
        } else {
            Log.d("DEBUG", "Hay un problema para encontrar un navegador.")
        }
    }
}