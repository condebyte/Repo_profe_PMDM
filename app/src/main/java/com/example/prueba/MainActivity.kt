package com.example.prueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import com.example.prueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setData()
        setListener()
    }

    private fun setData() {
        var adapter = CarAdapter(this, CarDataSource.getCars())
        binding.carList.adapter = adapter
    }

    private fun setListener() {
        binding.carList.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val vehicle: Car = binding.carList.getItemAtPosition(position) as Car
                Toast.makeText(
                    applicationContext,
                    "${vehicle.license}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}