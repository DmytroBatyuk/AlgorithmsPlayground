import algorithms.AlgorithmFactory
import kotlin.random.Random

val DEBUG = false
val ARRAY_SIZE = 5000
val REPEAT = 5
var UPPER_RANGE = 100000

fun main() {

    val array = generateRandomArray(ARRAY_SIZE)
    println("generated array size=${array.size}, array=$array")

    listOf(
        AlgorithmFactory.Type.BUBBLE_SORT,
        AlgorithmFactory.Type.BUBBLE_SORT_TWO_DIRECTION,
        AlgorithmFactory.Type.INSERTION_SORT
    ).map {
        AlgorithmFactory.create(it)
    }.forEach {
        it.testAlgorithm(array)
    }
}

fun <T> ArrayList<T>.copy() = arrayListOf<T>().let {
    it.addAll(this)
    it
}

private fun generateRandomArray(size: Int) = arrayListOf<Int>().apply {
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

private var tmp: Int = 0
private fun swap(array: ArrayList<Int>, index1: Int, index2: Int) {
    tmp = array[index1]
    array[index1] = array[index2]
    array[index2] = tmp
}