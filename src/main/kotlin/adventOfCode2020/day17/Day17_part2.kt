package adventOfCode2020.day17

fun printHorrorThingBackToFront(map: Map<Coord, Char>) {
    val (minX, maxX) = getMinAndMax(map, 'x')
    val (minY, maxY) = getMinAndMax(map, 'y')
    val (minZ, maxZ) = getMinAndMax(map, 'z')
    val (minW, maxW) = getMinAndMax(map, 'w')
    for (w in minW..maxW) {
        for (z in minZ..maxZ) {
            println("z=$z, w=$w")
            for (y in minY..maxY) {
                for (x in minX..maxX) {
                    print(map[Coord(x, y, z)])
                }
                println()
            }
            println("\n")
        }
    }
}

fun run4dCycles(map: Map<Coord, Char>, cycleNumber: Int = 6): Int {
    var finalMap = computeCycle(map)
    var i = 1
    while (i++ < cycleNumber) {
        finalMap = computeCycle(finalMap)
    }
    return mapToString(finalMap).count { it == '#' }
}