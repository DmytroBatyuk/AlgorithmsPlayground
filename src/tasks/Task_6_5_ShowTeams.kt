package tasks

import java.lang.StringBuilder

class Task_6_5_ShowTeams(
    private val n: Int,
    private val k: Int
) {
    private val all = StringBuilder().let {
        for (i in 0 until n) {
            it.append('A' + i)
        }
        it.toString()
    }

    fun run() {
        println(showTeams(all, k))
    }

    private fun showTeams(available: String, team: Int): List<String> {
        val list = arrayListOf<String>()
        if (team == 1) {
            available.forEach {
                list.add(it.toString())
            }
        } else if (available.length == team) {
            list.add(available)
        } else if (available.length > team) {
            showTeams(available.substring(1), team - 1).forEach {
                list.add("${available[0]}$it")
            }
            list.addAll(showTeams(available.substring(1), team))
        }

        return list
    }
}