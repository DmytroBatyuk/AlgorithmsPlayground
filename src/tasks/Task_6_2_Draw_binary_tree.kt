package tasks

import kotlin.math.pow

class Task_6_2_Draw_binary_tree(private val repeats: Int) {


    fun run() {
        val chars = 2.toDouble().pow(repeats).toInt()
        runInternal(chars, chars, true)
    }

    private fun runInternal(chars: Int, size: Int, isLast: Boolean) {
        if (chars == 1) {
            display(0, size, true)
            return
        }
        runInternal(chars / 2, size, false)
        for(i in 0 until chars) {
            display(i, size/chars, i == chars -1)
        }


    }

    private fun display(index: Int, size: Int, isLast: Boolean) {
        val mid = size / 2
        for (i in 0 until size) {
            print(if (i == mid) 'X' else '-')
        }
        if (isLast) {
            print('\n')
        }
    }
}