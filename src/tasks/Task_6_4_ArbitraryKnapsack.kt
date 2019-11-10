package tasks

import java.util.*
import kotlin.collections.ArrayList

private val DEBUG = false
class Task_6_4_ArbitraryKnapsack(
    private val capacity: Int = 20,
    private val items: Array<Int> = arrayListOf(11, 8, 7, 6, 5).let {
        it.toArray(Array<Int>(it.size) { 0 })
    }
) {
    var bestSelection = Selection(capacity, Stack())

    fun run() {
        println("start with: capacity=$capacity, items=${Arrays.toString(items)}")
        matchRecur(0, bestSelection)
        println("best=$bestSelection")
    }

    private fun matchRecur(startInd: Int, sel: Selection) {
        val tmpList = items.mapIndexed { index, i -> if (index >= startInd) "$i" else "-" }
        if (DEBUG) println("start list=$tmpList, sel=$sel")
        if (sel.remain < bestSelection.remain) {
            if (DEBUG) println("udpate best: $bestSelection -> $sel")
            updateBestSelection(sel)
        }

        //If best items match already found - stop
        if (bestSelection.remain == 0) {
            return
        }

        //If reached end of the items array - stop
        if (startInd == items.size) {
            return
        }

        val w = items[startInd]
        val newRemain = sel.remain - w
        if (newRemain >= 0) {
            if (DEBUG) println("       list=$tmpList, add=$w, has space=$newRemain")
            matchRecur(startInd + 1, Selection(newRemain, Stack<Int>().apply {
                addAll(sel.items)
                add(w)
            }))
        } else {
            if (sel.items.isNotEmpty()) {
                if (DEBUG) println("       list=$tmpList, add=$w, overloaded=$newRemain, try next item")
                matchRecur(startInd + 1, sel)
            }
            return
        }

        if (bestSelection.remain > 0) {
            if (sel.items.isNotEmpty()) {

                if (DEBUG) println("       list=$tmpList, best is not 0, try with another item" + if (sel.items.isNotEmpty()) " and pop" else "")
                val w = if (sel.items.isNotEmpty()) sel.items.pop() else 0
                matchRecur(startInd/* + 1*/, Selection(sel.remain + w, Stack<Int>().apply {
                    addAll(sel.items)
                }))
            }
        }

    }

    private fun updateBestSelection(selection: Selection) {
        bestSelection = Selection(selection.remain, Stack<Int>().apply { addAll(selection.items) })
    }

    data class Selection(
        var remain: Int,
        var items: Stack<Int>
    )
}