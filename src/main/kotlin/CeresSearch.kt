package dev.zrdzn

import java.io.InputStream

class CeresSearch : Issue {

    private val target = "XMAS"

    override fun day(): Int = 4

    override fun solveFirst(input: InputStream): String {
        val grid = input.bufferedReader().use { it.readLines() }

        var phrases = 0

        val rows = grid.size
        val cols = grid[0].length

        for (row in grid.indices) {
            phrases += traverseAndCount(grid, row, 0, 0, 1)
            phrases += traverseAndCount(grid, row, cols - 1, 0, -1)
        }

        for (column in 0 until cols) {
            phrases += traverseAndCount(grid, 0, column, 1, 0)
            phrases += traverseAndCount(grid, rows - 1, column, -1, 0)
        }

        for (diagonalForward in 0 until rows) {
            phrases += traverseAndCount(grid, diagonalForward, 0, 1, 1)
            phrases += traverseAndCount(grid, diagonalForward, cols - 1, 1, -1)
            phrases += traverseAndCount(grid, diagonalForward, 0, -1, 1)
            phrases += traverseAndCount(grid, diagonalForward, cols - 1, -1, -1)
        }

        for (diagonalBackward in 0 until cols) {
            phrases += traverseAndCount(grid, 0, diagonalBackward, 1, 1)
            phrases += traverseAndCount(grid, rows - 1, diagonalBackward, -1, 1)
            phrases += traverseAndCount(grid, 0, diagonalBackward, 1, -1)
            phrases += traverseAndCount(grid, rows - 1, diagonalBackward, -1, -1)
        }

        return phrases.toString()
    }

    override fun solveSecond(input: InputStream): String {
        TODO("Not yet implemented")
    }

    private fun traverseAndCount(grid: List<String>, row: Int, column: Int, rowOffset: Int, columnOffset: Int): Int {
        var currentRow = row
        var currentColumn = column
        val phrase = StringBuilder()

        var phrases = 0

        while (currentRow in grid.indices && currentColumn in 0 until grid[0].length) {
            phrase.append(grid[currentRow][currentColumn])

            if (phrase.length == target.length) {
                if (phrase.toString() == target) {
                    phrases++
                }

                phrase.deleteCharAt(0)
            }

            currentRow += rowOffset
            currentColumn += columnOffset
        }

        return phrases
    }
}