package algorithms

import datastructures.QueueException
import java.util.*
import kotlin.test.assertTrue

class Task_4_2_Deque(size: Int, private val DEBUG: Boolean = false) {
    val array = arrayOfNulls<Int>(size + 1)

    var indexR = -1
    var indexL = 0


    fun insertLeft(value: Int) {
        if (isFull()) {
            throw QueueException("is full")
        }

        if (--indexL == -1) {
            indexL = array.size -1
        }
        array[indexL] = value
        if (DEBUG) {
            println("insertL: [$indexL]=$value, array=${Arrays.toString(array)}")
        }
    }

    fun insertRight(value: Int) {
        if (isFull()) {
            throw QueueException("is full")
        }
        if (indexR == array.size -1) {
            indexR = -1
        }
        array[++indexR] = value
        if (DEBUG) {
            println("insertR: [$indexR]=$value, array=${Arrays.toString(array)}")
        }
    }

    fun removeLeft(): Int? {
        if (isEmpty()) {
            throw QueueException("is empty")
        }
        val savedIndex = indexL
        var retVal = array[indexL++]

        array[savedIndex] = null

        if (indexL == array.size) {
            indexL = 0
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

        val savedIndex = indexR
        val retVal = array[indexR]

        array[indexR] = null

        if (--indexR == -1) {
            indexR = array.size - 1
        }

        if (DEBUG) {
            println("removeR: [$savedIndex]=$retVal, array=${Arrays.toString(array)}")
        }

        return retVal
    }

    fun isEmpty(): Boolean {
        val result = (indexR + 1 == indexL || indexL + array.size - 1 == indexR)
        if (DEBUG) {
            println("isEmpty: $result, insertInd=$indexR, removeInd=$indexL")
        }
        return result
    }

    fun isFull() : Boolean {
        val result = (indexR + 2 == indexL || indexL + array.size - 2 == indexR)
        if (DEBUG) {
            println("isFull: $result, insertInd=$indexR, removeInd=$indexL")
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