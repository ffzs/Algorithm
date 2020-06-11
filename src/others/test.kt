fun numTeams(rating: IntArray): Int {
    var count = 0
    for (i in 1 until rating.size-1) {
        for (j in 0 until i) {
            if (rating[j] < rating[i]) {
                for (k in i + 1 until rating.size) {
                    if (rating[i] < rating[k]) count++
                }
            }
        }
        for (j in 0 until i) {
            if (rating[j] > rating[i]) {
                for (k in i + 1 until rating.size) {
                    if (rating[i] > rating[k]) count++
                }
            }
        }
    }
    return count
}

fun main(){
    val a = listOf(2,5,3,4,1)
}
