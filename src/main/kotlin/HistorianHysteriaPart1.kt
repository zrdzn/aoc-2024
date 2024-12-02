package dev.zrdzn

import java.io.InputStream
import kotlin.math.abs

class HistorianHysteriaPart1 : Issue {

    override fun day() = 1

    override fun solve(input: InputStream): String {
        val lines = input.bufferedReader().readLines()

        val leftNumbers = lines
            .map { it.split(' ').first().toInt() }
            .sorted()

        val rightNumbers = lines
            .map { it.split(' ').last().toInt() }
            .sorted()

        return leftNumbers.zip(rightNumbers)
            .sumOf { (left, right) -> abs(left - right) }
            .toString()
    }
}