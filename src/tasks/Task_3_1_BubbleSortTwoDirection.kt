package tasks

import algorithms.AlgorithmAbs

private const val DEBUG = false
internal class Task_3_1_BubbleSortTwoDirection : AlgorithmAbs() {
    override fun sort(array: ArrayList<Int>) {
        var tmp: Int

        var shift = 0
        for (i in (array.size - 1) downTo 1) {
            for (j in shift until i) {
                if (array[j] > array[j + 1]) {
                    if (DEBUG) {
                        println("$tag: ${array.mapIndexed{i, value ->
                            if (i == j) "$value ->"
                            else if (i == j+1) "<- $value"
                            else "$value"
                        }}")
                    }
                    tmp = array[j + 1]
                    array[j + 1] = array[j]
                    array[j] = tmp
                }
            }

            for (j in (i - 1) downTo shift + 1) {
                if (array[j - 1] > array[j]) {
                    if (DEBUG) {
                        println("$tag: ${array.mapIndexed{i, value ->
                            if (i == j - 1) "$value ->"
                            else if (i == j) "<- $value"
                            else "$value"
                        }}")
                    }
                    tmp = array[j]
                    array[j] = array[j - 1]
                    array[j - 1] = tmp
                }
            }
            shift++
        }
    }
}