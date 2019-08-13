package tasks

class Task_6_1_Mult_recur {
    fun mult(value: Int, multipleTimes: Int): Int {
        if (multipleTimes == 1) {
            return value
        }

        return value + mult(value, multipleTimes-1)
    }
}