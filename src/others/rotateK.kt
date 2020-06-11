import java.util.*


fun rotate(matrix: Array<IntArray>) {
    val maxY = matrix.size
    val maxX: Int = matrix[0].size
    for (i in 0 until maxY / 2) {
        swap(matrix, i, maxY - 1 - i)
    }
    for (y in 0 until maxY - 1) {
        for (x in maxX - 1 downTo y + 1) {
            deepSwap(matrix, x, y)
        }
    }
    println(Arrays.deepToString(matrix))
}

fun swap(matrix: Array<IntArray>, y1: Int, y2: Int) {
    val tmp = matrix[y1]
    matrix[y1] = matrix[y2]
    matrix[y2] = tmp
}

fun deepSwap(matrix: Array<IntArray>, x: Int, y: Int) {
    val tmp = matrix[x][y]
    matrix[x][y] = matrix[y][x]
    matrix[y][x] = tmp
}


fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    val matrix = arrayOf(
        intArrayOf(5, 1, 9, 11),
        intArrayOf(2, 4, 8, 10),
        intArrayOf(13, 3, 6, 7),
        intArrayOf(15, 14, 12, 16)
    )
    rotate(matrix)
    val end = System.currentTimeMillis()
    println(end-start)
}