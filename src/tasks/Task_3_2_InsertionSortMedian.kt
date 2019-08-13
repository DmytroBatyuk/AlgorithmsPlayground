package tasks

import algorithms.InsertionSort

private fun InsertionSort.median(array: ArrayList<Int>): Int {
    sort(array)
    println("$tag: sorted array=$array")
    if (array.isNotEmpty()) {
        val median = array[array.size / 2]
        println("$tag: median index=${array.size / 2}, value=$median")
        return array[array.size / 2]
    } else {
        println("$tag: array is empty")
        return 0
    }
}

internal class Task_3_2_InsertionSortMedian {
    fun run(array: ArrayList<Int>) {
        InsertionSort().median(array)
    }
}