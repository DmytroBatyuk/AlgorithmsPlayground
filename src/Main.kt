import algorithms.MergeSort
import algorithms.SelectionSort
import common.ARRAY_SIZE
import common.Recursion
import common.generateRandomArrayWithUniqueValues
import tasks.Task_6_1_Mult_recur
import tasks.Task_6_2_Draw_binary_tree
import tasks.Task_6_4_ArbitraryKnapsack
import tasks.Task_6_5_ShowTeams


fun main() {

    val array =
////        generateOrderedArray(ARRAY_SIZE)
        generateRandomArrayWithUniqueValues(ARRAY_SIZE)
//        generateRandomArrayWithPossibleRepeatedValues(ARRAY_SIZE)
//    println("generated array size=${array.size}, array=$array")
//
//    Task_3_6_InsertionLoopWithinLoopRemoveDups().testAlgorithm(array)

////    QueuePriority.test()
//    Task_4_1_DisplayContent().run()

    Task_6_4_ArbitraryKnapsack(1000, generateRandomArrayWithUniqueValues(100).let {list ->
        list.toArray(Array<Int>(list.size) { it -> list[it] })
    }).run()
}
