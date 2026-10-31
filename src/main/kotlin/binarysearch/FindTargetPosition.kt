package binarysearch

/**
 * Binary Search, together
 * Step 1: Understand the problem
 *
 * You get a sorted list of numbers and a target. Return the index of the target, or -1 if it isn’t there.
 *
 * [-1, 0, 3, 5, 9, 12], target 9 → 4
 * [-1, 0, 3, 5, 9, 12], target 2 → -1 (not in the list)
 *
 * The list being sorted is what makes this work.
 *
 * Step 2: Why not the obvious way?
 *
 * The obvious way checks every number from the start. With 1,000,000 numbers, that is up to 1,000,000 checks.
 *
 * The smarter idea is the number-guessing game. If I think of a number from 1 to 100 and say “higher” or “lower” after each guess, you guess 50 first. Whatever I say, you throw away half of the options at once.
 *
 * Binary search does the same: look at the middle, and because the list is sorted, you know which half the target can’t be in.
 *
 * With 1,000,000 numbers, about 20 guesses is enough, since you halve the list each time.
 *
 * Step 3: The sentence
 *
 * “Look at the middle. Too small? Throw away the left half. Too big? Throw away the right half.”
 *
 * Three possible outcomes for every middle:
 *
 * It’s the target: done, return the index.
 * Middle is smaller than the target: the target must be to the right, so discard the left half.
 * Middle is bigger than the target: the target must be to the left, so discard the right half.
 */
fun main() {
    println("++++++++++++++++++++")
    println(findTargetPosition(intArrayOf(-1, 0, 3, 5, 7, 9, 23), target = -1))
    println("++++++++++++++++++++")
}

fun findTargetPosition(input: IntArray, target: Int): Int {
    var left = 0
    var right = input.size - 1

    while (left <= right) {
        val middle = left + ((right - left) / 2)

        if (input[middle] == target) return middle
        else if (input[middle] < target) left = middle + 1
        else right = middle - 1

        //another way
//        when {
//            input[middle] == target -> return middle
//            input[middle] < target -> left = middle + 1
//            else -> right = middle-1
//        }

    }
    return -1
}