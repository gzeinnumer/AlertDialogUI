package com.gzeinnumer.alertdialogui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(){
    private lateinit var alertDialog: android.app.AlertDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //implementation 'com.github.d-max:spots-dialog:1.1@aar'
        alertDialog = SpotsDialog.Builder()
            .setContext(this)
            .setMessage("Mohon Menunggu")
            .setCancelable(false)
            .build()

        //implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1"
        //implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.2.1"
        btn.setOnClickListener {
            onDialogShow()
            CoroutineScope(Default).launch {
                onProgress()
            }
        }
    }

    private suspend fun onProgress() {
        delay(3000)
        onDialogHide()
    }

    private fun onDialogHide() {
        alertDialog.dismiss() // if you want to stay on the same activity, you should use dismis
        //alertDialog.hide() //if you want to stop activity, and move to new activity, use hide,
    }

    private fun onDialogShow() {
        alertDialog.show()
    }


}
