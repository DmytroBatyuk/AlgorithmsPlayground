package tasks

import algorithms.AlgorithmAbs
import java.util.Collections.swap

private val DEBUG = false

internal class Task_3_4_OddEvenSort : AlgorithmAbs() {
    override fun sort(a: ArrayList<Int>) {
        var tmp: Int

        var sorted = false
        while (!sorted) {
            sorted = true
            //odd
            if (DEBUG) {
                println("$tag: odd sorting: array=$a")
            }
            for (i in 0 until a.size - 1 step 2) {
                if (a[i] > a[i+1]) {
                    if (DEBUG) {
                        println("$tag: ${a.mapIndexed { ii, value ->
                            if (ii == i) "($value ->)"
                            else if (ii == i+1) "(<- $value)"
                            else "$value"
                        }}")
                    }
                    swap(a, i, i+1)
                    sorted = false
                }
            }
            if (DEBUG) {
                println("$tag: odd sorting end: was sorted=$sorted, array=$a")
            }

            //Even
            if (DEBUG) {
                println("$tag: even sorting: array=$a")
            }
            for(i in 1 until a.size-1 step 2) {
                if (a[i] > a[i+1]) {
                    if (DEBUG) {
                        println("$tag: ${a.mapIndexed { ii, value ->
                            if (ii == i) "($value ->)"
                            else if (ii == i+1) "(<- $value)"
                            else "$value"
                        }}")
                    }
                    swap(a, i, i+1)
                    sorted = false
                }
            }
            if (DEBUG) {
                println("$tag: even sorting end: was sorted=$sorted, array=$a")
            }
        }
        println("$tag: sorted array=$a")
    }
}