package dev.zrdzn

import java.io.InputStream

class HistorianHysteriaPart2 : Issue {

    override fun day() = 1

    override fun solve(input: InputStream): String {
        val lines = input.bufferedReader().readLines()

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