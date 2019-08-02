package algorithms

import datastructures.QueuePriority
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Task_4_4_PriorityQueueTimeTesting(private val prioritizeOnInsert: Boolean) {
    fun test() {
        val size = 10000

        val queue = QueuePriority(size, prioritizeOnInsert)
        var insertTime: Long = 0L
        var removeTime: Long = 0L
        val totalTime = measureTimeMillis {
            insertTime = measureTimeMillis {
                for (i in size - 1 downTo 0) {
                    queue.insert(i)
                }
            }
            assertTrue(queue.isFull())

            removeTime = measureTimeMillis {
                for (i in 0 until size) {
                    assertEquals(i, queue.remove())
                }
            }

            assertTrue(queue.isEmpty())
        }
        println("Task 4.4: insertTime=$insertTime, removeTime=$removeTime, total=$totalTime")
    }
}