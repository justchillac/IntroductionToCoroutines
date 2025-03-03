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
    delay(500)
    throw AssertionError("Temeperature is Invalid")
    return "30\u00B0C"
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async{
        getForecast()
    }
//    val temperature = async{
//        try {
//            getTemperature()
//        } catch (e: AssertionError) {
//            "{Temperature not found}"
//        }
//    }
//    "${forecast.await()} ${temperature.await()}"

    val temperature = async {
        getTemperature()
    }

    delay(200)
    temperature.cancel()

    "${forecast.await()}"
//    What you've learned here is that a coroutine can be cancelled, but it won't affect other coroutines in the same
//    scope and the parent coroutine will not be cancelled.
}