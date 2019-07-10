import algorithms.Task_3_2_InsertionSortMedian
import algorithms.Task_3_3_InsertionSortNoDuplicates
import kotlin.random.Random

val DEBUG = false
val ARRAY_SIZE = 12
val REPEAT = 5
var UPPER_RANGE = ARRAY_SIZE

fun main() {

    val array = generateRandomArrayWithPossibleRepeatedValues(ARRAY_SIZE)
    println("generated array size=${array.size}, array=$array")

    val task_3_3 = Task_3_3_InsertionSortNoDuplicates()
    task_3_3.run(array)
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

private var tmp: Int = 0
private fun swap(array: ArrayList<Int>, index1: Int, index2: Int) {
    tmp = array[index1]
    array[index1] = array[index2]
    array[index2] = tmp
}