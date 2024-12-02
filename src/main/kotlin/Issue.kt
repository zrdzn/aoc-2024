package dev.zrdzn

import java.io.InputStream

interface Issue {

    fun day(): Int

    fun solve(input: InputStream): String
}