package algorithms

import DEBUG

class InsertionSort : AlgorithmAbs() {
    override fun sort(array: ArrayList<Int>) {
        var tmp = 0
        var j: Int
        for (i in 0 until array.size) {
            tmp = array[i]
            j = i
            if (DEBUG) {
                println("$tag: ${array.mapIndexed { i, value ->
                    if (i != j) "$value"
                    else "($value)" }
                }, save=$tmp")
            }
            while (j > 0 && array[j - 1] > tmp) {
                array[j] = array[j - 1]
                if (DEBUG) {
                    println("$tag: ${array.mapIndexed{i, value ->
                        if (i == j) "-> $value"
                        else if (i== j-1) "$value ->"
                        else "$value"}
                    }, save=$tmp")
                }
                j--
            }
            array[j] = tmp
            if (DEBUG) {
                println("$tag: $array")
            }
        }

        val median = array[array.size/2]
        println("$tag: median index=${array.size/2}, value=$median")
    }
}