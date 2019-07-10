package algorithms


private val DEBUG = true
private fun InsertionSort.noDups(a: ArrayList<Int>) {
    sort(a)
    println("$tag: sorted array=$a")

    var iLo = 0
    var iHi = iLo + 1

    if (DEBUG) {
        println("$tag: array=${a.mapIndexed { i, v -> if (i == iLo || i == iHi) "($v)" else "$v" }}")
    }
    while (iHi < a.size) {
        if (a[iLo] < a[iHi]) {
            if (iLo + 1 == iHi) {
                iLo++
            } else {
                iLo++
                if (DEBUG) {
                    println("$tag: array=${a.mapIndexed { i, v -> if (i == iLo) "($v <-)" else if (i == iHi) "(<- $v)" else "$v" }}")
                }
                a[iLo] = a[iHi]
            }
            iHi++
        } else {
            iHi++
        }
        if (DEBUG) {
            println("$tag: array=${a.mapIndexed { i, v -> if (i == iLo || i == iHi) "($v)" else "$v" }}")
        }
    }

    val iRemove = iLo + 1
    while (iRemove < a.size) {
        if (DEBUG) {
            println("$tag: array=${a.mapIndexed { i, v -> if (i == iRemove) "(DELETE $v)" else "$v" }}")
        }
        a.removeAt(iRemove)
    }

    println("$tag: noDups array=$a")
}


internal class Task_3_3_InsertionSortNoDuplicates {
    fun run(array: ArrayList<Int>) {
        InsertionSort().noDups(array)
    }
}