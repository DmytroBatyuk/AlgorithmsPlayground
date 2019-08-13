package algorithms

import kotlin.math.sign

class MergeSort : AlgorithmAbs() {
    override fun sort(array: ArrayList<Int>) {
        val cpy = arrayListOf<Int>()
        cpy.addAll(array)
        println("array before=$array")
        mergeRecur(cpy, array, 0, array.size - 1)

        println("array after=$array")
    }

    private fun mergeRecur(from: ArrayList<Int>, to: ArrayList<Int>, iLow: Int, iHigh: Int) {
        if (iLow == iHigh) {
            return
        }

        val iMid = (iHigh + iLow) / 2
        mergeRecur(from, to, iLow, iMid)
        mergeRecur(from, to, iMid + 1, iHigh)
        merge(from, to, iLow, iMid + 1, iHigh)
    }

    private fun merge(from: ArrayList<Int>, to: ArrayList<Int>, iLow: Int, iMid: Int, iHigh: Int) {
        var i = iLow
        val mid = iMid - 1
        var j = iMid
        var iDest = iLow
        while (i <= mid && j <= iHigh) {
            if (from[i] < from[j]) {
                to[iDest++] = from[i++]
            } else {
                to[iDest++] = from[j++]
            }
        }

        while (i <= mid) {
            to[iDest++] = from[i++]
        }

        while (j <= iHigh) {
            to[iDest++] = from[j++]
        }

        for (ii in iLow..iHigh) {
            from[ii] = to[ii]
        }
    }
}