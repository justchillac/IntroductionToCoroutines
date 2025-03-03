package org.example
import kotlinx.coroutines.*
import kotlin.system.*

fun main() {
//    val time = measureTimeMillis{
//        runBlocking{
//            println("Weather forecast")
////            launch{
////                printForecast()
////            }
////            launch{
////                printTemperature()
////            }
//
//            val forecast : Deferred<String> = async{
//                getForecast()
//            }
//            val temperature : Deferred<String> = async{
//                getTemperature()
//            }
//            println("${forecast.await()} ${temperature.await()}")
//            println("Have a good day")
//        }
//    }
//    println("Execution Time: ${time/1000.0}")

    runBlocking{
        println("Weather forecast")
        println(getWeatherReport())
        println("Have a good day")
    }
}

//Extract the code that simulates the network request
//for the weather data and move it into its own function called printForecast()
//suspend fun printForecast() {
//        delay(1000)
//        println("Sunny")
//}
//
//suspend fun printTemperature() {
//    delay(1000)
//    println("30\u00B0C")
//}

suspend fun getForecast() : String{
    delay(1000)
    return "Sunny"
}

suspend fun getTemperature() : String{
    delay(1000)
    return "30\u00B0C"
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async{
        getForecast()
    }
    val temperature = async{
        getTemperature()
    }
    "${forecast.await()} ${temperature.await()}"
}