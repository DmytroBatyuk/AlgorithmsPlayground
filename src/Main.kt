import kotlin.random.Random
import kotlin.system.measureTimeMillis

val DEBUG = true
val ARRAY_SIZE = 10
val REPEAT = 1
var UPPER_RANGE = ARRAY_SIZE

fun main() {

    val array = generateRandomArray(ARRAY_SIZE)
    println("generated array size=${array.size}, array=$array")

    testAlgorithm(array, ::bubbleSort, "bubbleSort")
//    testAlgorithm(array, ::twoWaysBubbleSort, "2WaysBubbleSort")
    testAlgorithm(array, ::selectionSort, "selectionSort")
    testAlgorithm(array, ::insertionSort, "insertionSort")

}

fun testAlgorithm(array: ArrayList<Int>, action: (ArrayList<Int>) -> Unit, tag: String) {
    Thread {
        var total = 0L
        for (i in 0 until REPEAT) {
            val arrayCopy = array.copy()
            val duration = measureTimeMillis {
                action(arrayCopy)
            }
            println("$tag: duration=$duration, array=$arrayCopy")
            total += duration
        }
        println("$tag: total=$total, medium=${total / REPEAT}")
    }.start()
}

fun bubbleSort(array: ArrayList<Int>) {
    var tmp: Int

    for (i in (array.size - 1) downTo 1) {
        for (j in 0 until i) {
            if (array[j] > array[j + 1]) {
                if (DEBUG) {
                    println("bubbleSort: ${array.mapIndexed{i, value ->
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
    }
}

fun twoWaysBubbleSort(array: java.util.ArrayList<Int>) {
    var tmp: Int

    var shift = 0
    for (i in (array.size - 1) downTo 1) {
        for (j in shift until i) {
            if (array[j] > array[j + 1]) {
                if (DEBUG) {
                    println("2WaysBubbleSort: ${array.mapIndexed{i, value ->
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
                    println("2WaysBubbleSort: ${array.mapIndexed{i, value ->
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

fun selectionSort(array: java.util.ArrayList<Int>) {
    var minIndex = 0
    var tmp = 0
    for (i in 0 until (array.size - 1)) {
        minIndex = i
        for (j in i + 1 until array.size) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }
        if (minIndex != i) {
            if (DEBUG) {
                println("selectionSort: ${array.mapIndexed{ind, value ->
                    if (ind == i) "$value ->"
                    else if (ind == minIndex) "<- $value"
                    else "$value"
                }}")
            }
            tmp = array[i]
            array[i] = array[minIndex]
            array[minIndex] = tmp
        }
    }
}

fun insertionSort(array: ArrayList<Int>) {
    var tmp = 0
    var j: Int
    for (i in 0 until array.size) {
        tmp = array[i]
        j = i
        if (DEBUG) {
            println("insertionSort: ${array.mapIndexed { i, value -> 
                if (i != j) "$value" 
                else "($value)" }
            }, save=$tmp")
        }
        while (j > 0 && array[j - 1] > tmp) {
            array[j] = array[j - 1]
            if (DEBUG) {
                println("insertionSort: ${array.mapIndexed{i, value ->
                    if (i == j) "-> $value" 
                    else if (i== j-1) "$value ->" 
                    else "$value"}
                }, save=$tmp")
            }
            j--
        }
        array[j] = tmp
        if (DEBUG) {
            println("insertionSort: $array")
        }
    }
}

fun <T> ArrayList<T>.copy() = arrayListOf<T>().let {
    it.addAll(this)
    it
}

private fun generateRandomArray(size: Int) = arrayListOf<Int>().apply {
    for (i in 1..size) {
        this.add(Random.nextInt(0, UPPER_RANGE))
    }
}

private fun generateOrderedArray(size: Int) = arrayListOf<Int>().apply {
    for(i in 1..size) {
        this.add(i)
    }
}
private fun generateReverseOrderedArray(size: Int) = arrayListOf<Int>().apply {
    for(i in 1..size) {
        this.add(size-i)
    }
}