package dev.zrdzn

import java.io.InputStream
import kotlin.math.abs

class RedNosedReports : Issue {

    override fun day() = 2

    override fun solveFirst(input: InputStream): String =
        solve(input, dampener = false)

    override fun solveSecond(input: InputStream): String =
        solve(input, dampener = true)

    private fun solve(input: InputStream, dampener: Boolean): String {
        return input.bufferedReader().useLines { lines ->
            lines
                .map { line ->
                    val values = line.split(' ').map { it.toInt() }
                    if (dampener) values.isSafeWithDampener() else values.isSafe()
                }
                .count { it }.toString()
        }
    }

    private fun List<Int>.isSafeWithDampener(): Boolean {
        if (this.isSafe()) return true

        for (i in this.indices) {
            val isSafeWithoutElement = this.filterIndexed { index, _ -> index != i }.isSafe()
            if (isSafeWithoutElement) return true
        }

        return false
    }

    private fun List<Int>.isSafe(): Boolean {
        if (this.size < 2) return true

        val diffs = this.zipWithNext { a, b -> b - a }

        if (diffs.any { abs(it) !in 1..3 }) return false

        val isIncreasing = diffs.all { it > 0 }
        val isDecreasing = diffs.all { it < 0 }

        return isIncreasing || isDecreasing
    }
}