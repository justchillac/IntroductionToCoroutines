package org.example
import kotlinx.coroutines.*
import kotlin.system.*

fun main() {
    val time = measureTimeMillis{
        runBlocking{
            println("Weather forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Execution Time: ${time/1000.0}")
}

//Extract the code that simulates the network request
//for the weather data and move it into its own function called printForecast()
suspend fun printForecast() {
        delay(1000)
        println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00B0C")
}