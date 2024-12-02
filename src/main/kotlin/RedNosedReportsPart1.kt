package dev.zrdzn

import java.io.InputStream
import kotlin.math.abs

class RedNosedReportsPart1 : Issue {

    override fun day() = 2

    override fun solve(input: InputStream): String {
        val lines = input.bufferedReader().readLines()

        return lines
            .map { line ->
                line.split(' ')
                    .map { it.toInt() }
                    .isSafe()
            }
            .count { it }
            .toString()
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