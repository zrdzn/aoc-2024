package dev.zrdzn

import java.io.InputStream
import kotlin.math.abs

class HistorianHysteria : Issue {

    override fun day() = 1

    override fun solveFirst(input: InputStream): String {
        val lines = input.bufferedReader().use { it.readLines() }

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

    override fun solveSecond(input: InputStream): String {
        val lines = input.bufferedReader().use { it.readLines() }

        val leftNumbers = lines
            .map { it.split(' ').first().toInt() }

        val rightNumbers = lines
            .map { it.split(' ').last().toInt() }

        var similarity = 0

        for (i in leftNumbers) {
            for (j in rightNumbers) {
                if (j == i) {
                    similarity += i
                }
            }
        }

        return similarity.toString()
    }
}