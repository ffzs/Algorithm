import java.util.*

fun maxDepthAfterSplit(seq: String): IntArray {
    val seqList = seq.toCharArray()
    val marker = IntArray(seq.length)
    for (i in seqList.indices) {
        marker[i] = i and 1 xor if (seqList[i] == '(') 1 else 0
    }
    return marker
}

fun main() {
    maxDepthAfterSplit("(()())")
}
