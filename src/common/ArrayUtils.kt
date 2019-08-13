package common

import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random


val ARRAY_SIZE = 20000
val REPEAT = 4
var UPPER_RANGE = ARRAY_SIZE

fun <T> ArrayList<T>.copy() = arrayListOf<T>().let {
    it.addAll(this)
    it
}

fun generateRandomArrayWithUniqueValues(size: Int) = arrayListOf<Int>().apply {
    addAll(generateOrderedArray(size))

    for (i in 0 until size) {
        Collections.swap(this, i, Random.nextInt(size))
    }

    forEach { value ->
        if (filter { it == value }.size > 1) {
            throw IllegalStateException("$value is found multiply times")
        }
    }
}

fun generateRandomArrayWithPossibleRepeatedValues(size: Int) = arrayListOf<Int>().apply {
    for (i in 0 until size) {
        add(Random.nextInt(UPPER_RANGE))
    }
}

fun generateOrderedArray(size: Int) = arrayListOf<Int>().apply {
    for (i in 1..size) {
        this.add(i)
    }
}

fun generateReverseOrderedArray(size: Int) = arrayListOf<Int>().apply {
    for (i in 1..size) {
        this.add(size - i)
    }
}