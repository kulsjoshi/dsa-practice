package day2.containDuplicate

/**
 * Contains Duplicate, together
 * Step 1: Understand the problem
 *
 * You get a list of numbers. Return true if any number appears at least twice, and false if every number is different.
 *
 * [1, 2, 3, 1] → true (1 appears twice)
 * [1, 2, 3, 4] → false
 * [] → false (nothing to repeat)
 * Step 2: Why not the obvious way?
 *
 * The obvious way compares every number with every other number. With 100,000 numbers that is billions of checks.
 *
 * The smarter question is the same one as Two Sum:
 *
 * “Have I seen this number before?”
 *
 * A set answers that instantly.
 *
 * Step 3: What is a set?
 *
 * A set is a notebook with one column and no repeats.
 *
 * A map stores pairs: number → position.
 * A set stores only the numbers, and nothing twice.
 *
 * Here we don’t need a position. We only need to know whether a number is in the notebook, so a set is simpler than a map.
 *
 * Step 4: The sentence
 *
 * “Seen it before? Done. If not, write it down.”
 *
 * Two actions for every number:
 *
 * Ask: is it already in the set? If yes, return true.
 * Write: if not, add it.
 *
 */
fun main() {
    println("Result: ${containDuplicate(intArrayOf(1, 3, 1, 5, 67, 8, 43, 5))}")
    println("Result: ${containDuplicate(intArrayOf())}")

    println("Result: ${containDuplicateAnotherWay(intArrayOf(1, 3, 1, 5, 67, 8, 43, 5))}")
    println("Result: ${containDuplicateAnotherWay(intArrayOf())}")
}

fun containDuplicate(inputs: IntArray): Boolean {
    println("Input Data: ${inputs.toList()}")

    if (inputs.isEmpty()) {
        println("Input data is empty")
        return false
    }

    val seenNumbers = HashSet<Int>()
    for (number in inputs) {
        println("Current number: $number")
        if (number in seenNumbers) return true
        seenNumbers.add(number)
    }
    return false
}

//Second and simple approach
//Use toSet so that duplicate number will be removed and we will compare it with the original input size
fun containDuplicateAnotherWay(inputs: IntArray): Boolean = inputs.toSet().size != inputs.size