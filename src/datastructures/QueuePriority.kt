package datastructures

import algorithms.InsertionSort
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

private const val DEBUG = false
class QueuePriority(size: Int) : Queue(size) {

    @Synchronized
    override fun insert(value: Int) {
        super.insert(value)
        prioritize()
    }

    private fun prioritize() {
        var realSize = (iIndex+1 + array.size - rIndex)%array.size
        if (DEBUG) {
            println("prioritize: real size=$realSize")
        }
        val a = arrayListOf<Int>()
        for (i in 0 until realSize) {
            a.add(array[(i+array.size+rIndex)%array.size]!!)
        }
        if (DEBUG) {
            println("prioritize: before sort=$a")
        }
        InsertionSort().sort(a)
        if (DEBUG) {
            println("prioritize: after sort=$a")
        }
        for (i in 0 until array.size) {
            if (i < a.size) {
                array[i] = a[i]
            } else {
                array[i] = null
            }
        }
        iIndex = a.size-1
        rIndex = 0
    }

    @Synchronized
    override fun remove(): Int? {
        return super.remove()
    }

    companion object {
        private val SIZE = 5
        fun test() {
            var queue = QueuePriority(SIZE)

            for (i in 0 until SIZE) {
                queue.insert(SIZE-i)
            }

            assertTrue(queue.isFull())

            queue.remove()
            queue.remove()

            assertFalse(queue.isFull())
            queue.insert(Random().nextInt())
            queue.insert(Random().nextInt())

            assertTrue(queue.isFull())

            for (i in 0 until SIZE) {
                queue.remove()
            }

            assertTrue (queue.isEmpty())
        }
    }
}