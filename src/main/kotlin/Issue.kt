package dev.zrdzn

import java.io.InputStream

interface Issue {

    fun day(): Int

    fun solveFirst(input: InputStream): String

    fun solveSecond(input: InputStream): String
}