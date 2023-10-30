package com.example.prueba.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.prueba.R
import com.example.prueba.databinding.ActivityIntentBinding
import com.example.prueba.databinding.ActivityMainBinding
import com.example.prueba.utils.IntentManager

class IntentActivity : AppCompatActivity() {
     private lateinit var binding: ActivityIntentBinding
     private val MY_PERMISIONS_REQUEST_CALL_PHONE=12345645
    private val MY_PERMISIONS_REQUEST_CAMERA=123456454
    private val MY_PERMISIONS_REQUEST_CAPTURE_CAMERA=32454326
    private val MY_PERMISSIONS_REQUEST_CODE= 123451
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setListener()
    }
    private fun setListener(){
        binding.btnwebview.setOnClickListener {
            IntentManager.Openweb(this, "https://www.javiercarrasco.es")
        }
        binding.btncall.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                 != PackageManager.PERMISSION_GRANTED
                ) {
                // Si el usuario ya ha rechazado al menos una vez (TRUE),
                 // se da una explicación.
                  ActivityCompat.requestPermissions(
                      this, arrayOf( Manifest.permission.CALL_PHONE),
                      MY_PERMISIONS_REQUEST_CALL_PHONE
                  )
                }else{
                val intent = Intent(
                     Intent.ACTION_CALL,
                     Uri.parse("tel:965555555")
                     )
                startActivity(intent)

            }
        }
        binding.btncamera.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this, arrayOf( Manifest.permission.CAMERA),
                    MY_PERMISIONS_REQUEST_CAMERA
                )
            }else{
                val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))

                startActivity(intent)

            }
        }
        binding.btnCaptureCamera.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED
            ) {

                ActivityCompat.requestPermissions(
                    this, arrayOf( Manifest.permission.CAMERA),
                    MY_PERMISIONS_REQUEST_CAPTURE_CAMERA
                )
            }else{
                val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                startActivityForResult(intent, MY_PERMISSIONS_REQUEST_CODE)

            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
         super.onRequestPermissionsResult(requestCode, permissions, grantResults)
         when (requestCode) {
             MY_PERMISIONS_REQUEST_CALL_PHONE -> {
                 if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                     Log.d("DEBUG", "Permiso concedido!!")
                     val intent = Intent(
                          Intent.ACTION_CALL,
                          Uri.parse("tel:965555555")
                     )
                     startActivity(intent)
                 } else {
                     Log.d("DEBUG", "Permiso rechazado!!")
                 }
                 return
             }
             MY_PERMISIONS_REQUEST_CAMERA-> {
                 if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                     Log.d("DEBUG", "Permiso concedido!!")
                     val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                     startActivity(intent)
                 } else {
                     Log.d("DEBUG", "Permiso rechazado!!")
                 }
                 return
             }

             MY_PERMISIONS_REQUEST_CAPTURE_CAMERA-> {
                 if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                     Log.d("DEBUG", "Permiso concedido!!")
                     val intent = Intent(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                     startActivity(intent)
                 } else {
                     Log.d("DEBUG", "Permiso rechazado!!")
                 }
                 return
             }
             else -> {
                 Log.d("DEBUG", "Se pasa de los permisos.")}
             }



    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int, data: Intent?
    ) {

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === MY_PERMISSIONS_REQUEST_CODE && resultCode === RESULT_OK) {
            val thumbnail: Bitmap = data?.getParcelableExtra("data")!!
            binding.imgcameraresult.setImageBitmap(thumbnail)
        }
    }



}