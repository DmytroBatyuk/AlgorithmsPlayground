package tasks

import datastructures.Queue
import java.util.*

private fun Queue.displayContent() {
    print("content: [")
    for (i in 0 until realSize()) {
        print("${array[(rIndex+i)%array.size]} ")
    }
    println("]")
}

class Task_4_1_DisplayContent {
    fun run() {
        val size = 9
        val queue = Queue(size)
        for (i in 0 until size-1) {
            queue.insert(i)
        }

        queue.remove()
        queue.remove()

        queue.insert(10)
        queue.insert(11)

        queue.remove()
        queue.remove()
        queue.remove()
        queue.remove()

        queue.insert(20)
        queue.insert(21)
        queue.insert(22)

        queue.displayContent()
        println("original: array=${Arrays.toString(queue.array)}")
    }
}