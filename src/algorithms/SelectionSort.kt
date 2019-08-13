package algorithms

private const val DEBUG = false
internal class SelectionSort : AlgorithmAbs() {
    override fun sort(array: ArrayList<Int>) {
        var minIndex = 0
        var tmp = 0
        for (i in 0 until (array.size - 1)) {
            minIndex = i
            for (j in i + 1 until array.size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }
            if (minIndex != i) {
                if (DEBUG) {
                    println("$tag: ${array.mapIndexed{ind, value ->
                        if (ind == i) "$value ->"
                        else if (ind == minIndex) "<- $value"
                        else "$value"
                    }}")
                }
                tmp = array[i]
                array[i] = array[minIndex]
                array[minIndex] = tmp
            }
        }
    }
}