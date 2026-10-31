package day1.twosum

// 1. Two Sum  (hash map)
// Sentence: "For each number, ask the map if its partner is already there.
//            If not, write myself down."

//input[1,2,3,5,7] target = 9
fun twoSum(numbers: IntArray, target: Int): IntArray {
    val seen = HashMap<Int, Int>()
    //seen empty initially

    for ((id, currentNumber) in numbers.withIndex()) {
        //current 7 = required 2
        val required = target - currentNumber

        if (seen.containsKey(required)) {
            return intArrayOf(seen[required]!!, id)
        }
        seen[currentNumber] = id
        //seen[1] = 0
        //seen[2] = 1
        //seen[3] = 2
        //seen[5] = 3

    }

    return intArrayOf()
}

fun main() {
    println(twoSum(intArrayOf(1,2,3,5,7), 9).toList()) // expect [0, 1]
    println(twoSum(intArrayOf(3, 2, 4), 6).toList())      // expect [1, 2]
    println(twoSum(intArrayOf(3, 3), 6).toList())         // expect [0, 1]
}
