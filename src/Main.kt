import algorithms.BubbleSort
import algorithms.InsertionSort
import algorithms.Task_3_4_OddEvenSort
import java.util.Collections.swap
import kotlin.random.Random

val DEBUG = false
val ARRAY_SIZE = 20000
val REPEAT = 1
var UPPER_RANGE = ARRAY_SIZE

fun main() {

    val array =
        generateOrderedArray(ARRAY_SIZE)
        generateRandomArrayWithUniqueValues(ARRAY_SIZE)
//        generateRandomArrayWithPossibleRepeatedValues(ARRAY_SIZE)
    println("generated array size=${array.size}, array=$array"§)

    InsertionSort().testAlgorithm(array)
}

fun <T> ArrayList<T>.copy() = arrayListOf<T>().let {
    it.addAll(this)
    it
}

private fun generateRandomArrayWithUniqueValues(size: Int) = arrayListOf<Int>().apply {
    addAll(generateOrderedArray(size))

    for (i in 0 until size) {
        swap(this, i, Random.nextInt(size))
    }

    forEach { value ->
        if (filter { it == value }.size > 1) {
            throw IllegalStateException("$value is found multiply times")
        }
    }
}

private fun generateRandomArrayWithPossibleRepeatedValues(size: Int) = arrayListOf<Int>().apply {
    for (i in 0 until size) {
        add(Random.nextInt(UPPER_RANGE))
    }
}

private fun generateOrderedArray(size: Int) = arrayListOf<Int>().apply {
    for (i in 1..size) {
        this.add(i)
    }
}

private fun generateReverseOrderedArray(size: Int) = arrayListOf<Int>().apply {
    for (i in 1..size) {
        this.add(size - i)
    }
}