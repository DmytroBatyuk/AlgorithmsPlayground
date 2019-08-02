package datastructures

import common.Assert.assertException
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

open class Queue(size: Int, private val debug: Boolean = false) {
    val array = arrayOfNulls<Int>(size + 1)

    var iIndex = -1
    var rIndex = 0

    open fun insert(value: Int) {
        if (isFull()) {
            throw QueueException("is full")
        }
        if (iIndex == array.size -1) {
            iIndex = -1
        }
        array[++iIndex] = value
         if (debug) {
             println("insert: [$iIndex]=$value, array=${Arrays.toString(array)}")
         }
    }

    open fun remove(): Int? {
        if (isEmpty()) {
            throw QueueException("is empty")
        }
        val savedIndex = rIndex
        var retVal = array[rIndex++]

        array[savedIndex] = null

        if (rIndex == array.size) {
            rIndex = 0
        }

         if (debug) {
             println("remove: [$savedIndex]=$retVal, array=${Arrays.toString(array)}")
         }

        return retVal
    }

    fun peek(): Int? {
        if (isEmpty()) {
            throw QueueException("is empty")
        }

        return array[rIndex]
    }

    fun isEmpty(): Boolean {
        val result = (iIndex + 1 == rIndex || rIndex + array.size - 1 == iIndex)
        if (debug) {
            println("isEmpty: $result, insertInd=$iIndex, removeInd=$rIndex")
        }
        return result
    }

    fun isFull() : Boolean {
        val result = (iIndex + 2 == rIndex || rIndex + array.size - 2 == iIndex)
        if (debug) {
            println("isFull: $result, insertInd=$iIndex, removeInd=$rIndex")
        }
        return result
    }

    fun realSize() = (iIndex+1 + array.size - rIndex)%array.size

    companion object {
        private val SIZE = 5
        fun test() {
            var queue = Queue(SIZE)

            assertTrue(queue.isEmpty())
            assertFalse(queue.isFull())

            for (i in 0 until SIZE) {
                queue.insert(i)
                if (i < SIZE - 1) {
                    assertFalse(queue.isEmpty())
                    assertFalse(queue.isFull())
                }
            }

            assertException(QueueException::class.java) {
                queue.insert(10)
            }
            assertException(QueueException::class.java) {
                queue.insert(20)
            }

            assertTrue(queue.isFull())
            assertFalse(queue.isEmpty())

            for (i in 0 until SIZE) {
                assertEquals(i, queue.remove())

                if (i < SIZE - 1) {
                    assertFalse(queue.isEmpty())
                    assertFalse(queue.isFull())
                }
            }

            assertException(QueueException::class.java) {
                queue.remove()
            }

            assertTrue(queue.isEmpty())
            assertFalse(queue.isFull())
        }
    }
}

class QueueException(msg: String) : Exception(msg)

