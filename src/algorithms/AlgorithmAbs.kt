package algorithms

import REPEAT
import copy
import kotlin.system.measureTimeMillis

abstract class AlgorithmAbs {
    val tag: String = javaClass.simpleName

    fun testAlgorithm(array: ArrayList<Int>) {
        Thread {
            var total = 0L
            for (i in 0 until REPEAT) {
                val arrayCopy = array.copy()
                val duration = measureTimeMillis {
                    sort(arrayCopy)
                }
                println("$tag: duration=$duration, array=$arrayCopy")
                total += duration
            }
            println("$tag: total=$total, medium=${total / REPEAT}")
        }.start()
    }

    abstract fun sort(array: ArrayList<Int>)
}