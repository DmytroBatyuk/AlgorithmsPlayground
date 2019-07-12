package algorithms

import DEBUG

open class InsertionSort : AlgorithmAbs() {
    override fun sort(array: ArrayList<Int>) {
        var tmp = 0
        var comparisionCount = 0
        var copyCount = 0
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
            while (j > 0 && ++comparisionCount > 0 && array[j - 1] > tmp) {
                array[j] = array[j - 1]
                copyCount++
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
            copyCount++
            if (DEBUG) {
                println("$tag: $array")
            }

        }
        println("$tag: arraySize=${array.size}, comparisions=$comparisionCount, copies=$copyCount")
    }
}