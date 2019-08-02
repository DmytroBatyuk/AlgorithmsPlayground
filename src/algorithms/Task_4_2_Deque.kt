package algorithms

import datastructures.QueueException
import java.util.*
import kotlin.test.assertTrue

private val DEBUG = true

class Task_4_2_Deque(size: Int) {
    val array = arrayOfNulls<Int>(size + 1)

    var iIndex = -1
    var rIndex = 0


    fun insertLeft(value: Int) {
        if (isFull()) {
            throw QueueException("is full")
        }

        if (--rIndex == -1) {
            rIndex = array.size -1
        }
        array[rIndex] = value
        if (DEBUG) {
            println("insertL: [$rIndex]=$value, array=${Arrays.toString(array)}")
        }
    }

    fun insertRight(value: Int) {
        if (isFull()) {
            throw QueueException("is full")
        }
        if (iIndex == array.size -1) {
            iIndex = -1
        }
        array[++iIndex] = value
        if (DEBUG) {
            println("insertR: [$iIndex]=$value, array=${Arrays.toString(array)}")
        }
    }

    fun removeLeft(): Int? {
        if (isEmpty()) {
            throw QueueException("is empty")
        }
        val savedIndex = rIndex
        var retVal = array[rIndex++]

        array[savedIndex] = null

        if (rIndex == array.size) {
            rIndex = 0
        }

        if (DEBUG) {
            println("removeL: [$savedIndex]=$retVal, array=${Arrays.toString(array)}")
        }

        return retVal
    }

    fun removeRight(): Int? {
        if (isEmpty()) {
            throw QueueException("is empty")
        }

        val savedIndex = iIndex
        val retVal = array[iIndex]

        array[iIndex] = null

        if (--iIndex == -1) {
            iIndex = array.size - 1
        }

        if (DEBUG) {
            println("removeR: [$savedIndex]=$retVal, array=${Arrays.toString(array)}")
        }

        return retVal
    }

    fun isEmpty(): Boolean {
        val result = (iIndex + 1 == rIndex || rIndex + array.size - 1 == iIndex)
        if (DEBUG) {
            println("isEmpty: $result, insertInd=$iIndex, removeInd=$rIndex")
        }
        return result
    }

    fun isFull() : Boolean {
        val result = (iIndex + 2 == rIndex || rIndex + array.size - 2 == iIndex)
        if (DEBUG) {
            println("isFull: $result, insertInd=$iIndex, removeInd=$rIndex")
        }
        return result
    }

    private fun printArray() {
        println("deque=${Arrays.toString(array)}")
    }

    companion object {
        fun test() {
            val deque = Task_4_2_Deque(8)

            var rc = 0
            var lc = 0
            deque.printArray()
            deque.insertRight(++rc)
            deque.insertLeft(--lc)
            deque.insertRight(++rc)
            deque.insertLeft(--lc)
            deque.removeRight()
            deque.insertRight(++rc)
            deque.removeLeft()
            deque.removeLeft()
            deque.removeLeft()
            deque.removeLeft()
            deque.insertRight(++rc)
            deque.insertLeft(--lc)
            deque.insertLeft(--lc)
            deque.insertLeft(--lc)
            deque.insertLeft(--lc)
            deque.insertLeft(--lc)
            deque.insertLeft(--lc)
            deque.insertLeft(--lc)
            assertTrue(deque.isFull())
        }
    }
}