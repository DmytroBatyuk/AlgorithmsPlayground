package algorithms

object AlgorithmFactory {
    fun create(type: Type): AlgorithmAbs {
        return when (type) {
            AlgorithmFactory.Type.BUBBLE_SORT -> BubbleSort()
            Type.BUBBLE_SORT_TWO_DIRECTION -> BubbleSortTwoDirection()
            AlgorithmFactory.Type.SELECTION_SORT -> SelectionSort()
            AlgorithmFactory.Type.INSERTION_SORT -> InsertionSort()
            else -> throw UnsupportedOperationException("type=$type")
        }
    }

    enum class Type {
        BUBBLE_SORT,
        BUBBLE_SORT_TWO_DIRECTION,
        SELECTION_SORT,
        INSERTION_SORT
    }
}