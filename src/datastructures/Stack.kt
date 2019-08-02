package datastructures

import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Stack(size: Int) {
    private val array = arrayOfNulls<Int>(size)
    private var index = -1
    fun push(t: Int) {
        array[++index] = t
    }

    fun pop() = array[index--]

    fun isEmpty() = index == -1
    fun isFull() = index == array.size -1

    companion object {
        val size = 5
        fun test() {
            var stack = Stack(size)

            assertTrue(stack.isEmpty())
            assertTrue(!stack.isFull())
            for (i in 0 until size) {
                System.out.println("push: $i")
                stack.push(i)

                if (i < size-2) {
                    assertTrue(!stack.isEmpty())
                    assertTrue(!stack.isFull())
                }
            }

            assertTrue(!stack.isEmpty())
            assertTrue(stack.isFull())

            for (i in size-1 downTo 0) {
                System.out.println("pop: $i")
                assertEquals(i, stack.pop())

                if (i > 0) {
                    assertTrue(!stack.isEmpty())
                    assertTrue(!stack.isFull())
                }
            }

            assertTrue(stack.isEmpty())
            assertTrue(!stack.isFull())
        }
    }
}