package dev.zrdzn

fun main() {
    // day 1
    // val issue = HistorianHysteria()

    // day 2
    // val issue = RedNosedReports()

    // day 3
    val issue = MullItOver()

    object {}.javaClass.getResourceAsStream("/days/day${issue.day()}")
        ?.let { issue.solveSecond(it) }
        ?.also { println("Result: $it") }
        ?: println("Input file not found")
}