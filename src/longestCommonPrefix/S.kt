package longestCommonPrefix


/**
 *@describe
 *@author ffzs
 *@date 2020/6/15
 */

fun longestCommonPrefix(strs: Array<String>): String? {
    if (strs.isEmpty()) return ""
    var first = strs[0]
    for (str in strs) {
        while (str.indexOf(first) != 0) {
            first = first.substring(0, first.length - 1)
            if (first.isEmpty()) return ""
        }
    }
    return first
}