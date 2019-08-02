package algorithms

import datastructures.IStack
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Task_4_3_StackBasedOnDeque(private val size: Int, private val debug: Boolean = false) : IStack {
    val deque = Task_4_2_Deque(size, debug)

    override fun push(t: Int) {
        deque.insertRight(t)
    }

    override fun pop(): Int? {
        return deque.removeRight()
    }

    override fun isEmpty(): Boolean {
        return deque.isEmpty()
    }

    override fun isFull(): Boolean {
        return deque.isFull()
    }

    companion object {
        fun test() {
            val size = 5
            val stack = Task_4_3_StackBasedOnDeque(size, true)
            for(i in 0 until size) {
                stack.push(i)
            }
            assertTrue(stack.isFull())

            for (i in size-1 downTo 0) {
                assertEquals(i, stack.pop())
            }

            assertTrue(stack.isEmpty())
        }
    }
}