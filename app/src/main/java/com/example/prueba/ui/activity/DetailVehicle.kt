package com.example.prueba.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.prueba.R
import com.example.prueba.data.CarDataSource
import com.example.prueba.databinding.ActivityDetailVehicleBinding

class DetailVehicle : AppCompatActivity() {
    private lateinit var binding:ActivityDetailVehicleBinding
    companion object{
        val EXTRA_DATA:String="data"
        val EXTRA_POSITION:String="position"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailVehicleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setData()
    }
    private fun setData (){
        val message = intent.getStringExtra(EXTRA_DATA)

        /*
        binding.txtlicense.text=message
        Toast.makeText(
            this,
            message,
            Toast.LENGTH_LONG
        ).show()*/

        val position:Int = intent.getIntExtra(EXTRA_POSITION,0)
        val cars = CarDataSource.getCars()
        val car = cars.get(position)
        binding.txtlicense.text = car.license

    }
}