package dev.zrdzn

fun main() {
    // day 1
    // val issue = HistorianHysteria()

    // day 2
    // val issue = RedNosedReports()

    // day 3
    // val issue = MullItOver()

    // day 4
    val issue = CeresSearch()

    object {}.javaClass.getResourceAsStream("/days/day${issue.day()}")
        ?.let { issue.solveFirst(it) }
        ?.also { println("Result: $it") }
        ?: println("Input file not found")
}