package algorithms

import DEBUG

internal class BubbleSort : AlgorithmAbs() {
    override fun sort(array: ArrayList<Int>) {
        var tmp: Int

        for (i in (array.size - 1) downTo 1) {
            for (j in 0 until i) {
                if (array[j] > array[j + 1]) {
                    if (DEBUG) {
                        println("$tag: ${array.mapIndexed { i, value ->
                            if (i == j) "$value ->"
                            else if (i == j + 1) "<- $value"
                            else "$value"
                        }}")
                    }
                    tmp = array[j + 1]
                    array[j + 1] = array[j]
                    array[j] = tmp
                }
            }
        }
    }
}