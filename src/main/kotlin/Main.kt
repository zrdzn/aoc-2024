package dev.zrdzn

fun main() {
    // day 1
    // val issue = HistorianHysteriaPart1()
    // val issue = HistorianHysteriaPart2()

    // day 2
    // val issue = RedNosedReportsPart1()
    val issue = RedNosedReportsPart2()

    object {}.javaClass.getResourceAsStream("/days/day${issue.day()}")
        ?.let { issue.solve(it) }
        ?.also { println("Result: $it") }
        ?: println("Input file not found")
}