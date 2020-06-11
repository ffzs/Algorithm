package lengthOfLongestSubstring


fun lengthOfLongestSubstring(s: String): Int {
    val tmp = IntArray(128)
    var max = 0
    var j = 0
    for (i in 0 until s.length) {
        val theChar = s[i].toInt()
        if (tmp[theChar] > 0) j = Math.max(tmp[theChar], j)
        max = Math.max(max, i - j + 1)
        tmp[theChar] = i + 1
    }
    return max
}

fun main(args: Array<String>) {
    val s = "tmmzuxt"
    println(lengthOfLongestSubstring(s))
}
