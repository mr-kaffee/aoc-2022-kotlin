import java.io.File

fun main() {
    fun part1(elves: List<Int>): Int {
        return elves.fold(0) { mx, calories -> maxOf(mx, calories) }
    }

    fun part2(elves: List<Int>): Int {
        return elves.fold(mutableListOf(0, 0, 0)) { mx, calories ->
            if (calories > mx[0]) {
                mx[2] = mx[1]
                mx[1] = mx[0]
                mx[0] = calories
            } else if (calories > mx[1]) {
                mx[2] = mx[1]
                mx[1] = calories
            } else if (calories > mx[2]) {
                mx[2] = calories
            }
            mx
        }.sum()
    }

    val t0 = System.currentTimeMillis()

    // input parsing
    val input = File("src", "Day01.txt").readText()
    val elves = input
        .trim().split("\n\n")
        .map { elf -> elf.lines().sumOf { line -> line.toInt() } }
        .toList()
    val tParse = System.currentTimeMillis()

    // part 1
    val exp1 = 67658
    val sol1 = part1(elves)
    val t1 = System.currentTimeMillis()
    check(sol1 == exp1) { "Expected solution for part 1: $exp1, found $sol1" }

    // part 2
    val exp2 = 200158
    val sol2 = part2(elves)
    val t2 = System.currentTimeMillis()
    check(sol2 == exp2) { "Expected solution for part 1: $exp2, found $sol2" }

    // results
    println("Solved puzzle 2022/01")
    println("  parsed input in ${tParse - t0}ms")
    println("  solved part 1 in ${t1 - tParse}ms => $sol1")
    println("  solved part 2 in ${t2 - t1}ms => $sol2")
    println("  ---")
    println("  total time: ${t2 - t0}ms")
}
