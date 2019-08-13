package common

import java.util.*

class Recursion(
    private val a: Array<Char>
) {
    fun doAnagram() {
        doAnagram(a.size)
    }

    private fun doAnagram(size: Int) {
        printIn(size)

        try {
            if (size == 1) {
                return
            }

            for (i in 0 until size) {
                doAnagram(size - 1)

                if (size == 2) {
                    display()
                }
                shiftLeft(size)
            }
        } finally {
            printOut(size)
        }
    }

    private fun printIn(size: Int) {
        for (sp in 0 until a.size - size) {
            print('-')
        }
        println(">$size")
    }

    private fun printOut(size: Int) {
        print('<')
        for (sp in 0 until a.size - size) {
            print('-')
        }
        println("$size")
    }

    private fun display() {
        a.forEach {
            print(it)
        }
        println()
    }

    private fun shiftLeft(size: Int) {
        val ind = a.size - size
        val tmp = a[ind]
        for (i in ind until a.size - 1) {
            a[i] = a[i + 1]
        }
        a[a.size - 1] = tmp
        println("shiftLeft: size=$size, arr=${Arrays.toString(a)}")
    }
}