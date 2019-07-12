package algorithms

import DEBUG
private val DEFAULT_MIN = -1

internal class Task_3_6_InsertionLoopWithinLoopRemoveDups : InsertionSort() {
    override fun sort(array: ArrayList<Int>) {
        if (DEBUG) {
            println("task 3.6: array=$array")
        }
        //Replace duplicates with default minimum value
        for (i in 0 until array.size - 1) {
            if (array[i] == DEFAULT_MIN) {
                continue
            }
            for (j in i + 1 until array.size) {
                if (array[j] == DEFAULT_MIN) {
                    continue
                }

                if (array[i] == array[j]) {
                    array[j] = DEFAULT_MIN
                    if (DEBUG) {
                        println("task 3.6: array=${array.mapIndexed { ii, v ->  
                            if (ii == j) "(${array[ii]})" else "${array[ii]}"
                        }}")
                    }
                }
            }
        }

        //Insertion Sort
        super.sort(array)

        //Remove duplicate placeholders
        array.removeIf { it == DEFAULT_MIN }
        if (DEBUG) {
            println("task 3.6: removed dups: array=$array")
        }
    }
}