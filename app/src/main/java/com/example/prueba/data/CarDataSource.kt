package com.example.prueba.data

object CarDataSource {
    private val cars = ArrayList<Car>()
    fun getCars(): ArrayList<Car> {
        cars.add(Car("3456DFC", "BMW", "320CD"))
        cars.add(Car("2314FCT", "BMW", "320CD"))
        cars.add(Car("2967TRW", "BMW", "320CD"))
        return cars
    }
}