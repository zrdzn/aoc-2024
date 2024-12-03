package dev.zrdzn

import java.io.InputStream

class MullItOver : Issue {

    private val firstPattern = Regex("""mul\(\d+,\d+\)""")
    private val secondPattern = Regex("""(mul\(\d+,\d+\)|do(n't)?\(\))""")

    override fun day() = 3

    override fun solveFirst(input: InputStream): String {
        val memory = input.bufferedReader().use { it.readText() }

        return firstPattern.findAll(memory)
            .sumOf { multiply(it.value) }
            .toString()
    }

    override fun solveSecond(input: InputStream): String {
        val memory = input.readAllBytes().toString(Charsets.UTF_8)

        var lookForMuls = true

        var sum = 0
        secondPattern.findAll(memory)
            .map { it.value }
            .forEach { match ->
                when (match.length) {
                    4 -> lookForMuls = true
                    7 -> lookForMuls = false
                    else -> if (lookForMuls) sum += multiply(match)
                }
            }

        return sum.toString()
    }

    private fun multiply(match: String): Int =
        match
            .removePrefix("mul(")
            .removeSuffix(")")
            .split(',')
            .map { it.toInt() }
            .reduce(Int::times)
}