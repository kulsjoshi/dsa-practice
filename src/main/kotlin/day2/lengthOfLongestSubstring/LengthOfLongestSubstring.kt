package day2.lengthOfLongestSubstring

import jdk.internal.org.jline.utils.Colors.s

/**
 * Longest Substring Without Repeating Characters, together
 *
 * This is the new idea of Day 2, so I’ll go a bit slower.
 *
 * Step 1: Understand the problem
 *
 * You get a string. Find the length of the longest piece of it (a substring) with no repeated letters. The piece must be continuous, with no skipping.
 *
 * "abcabcbb" → 3 ("abc")
 * "bbbbb" → 1 ("b")
 * "pwwkew" → 3 ("wke")
 * "" → 0
 * Step 2: Why not the obvious way?
 *
 * The obvious way checks every possible substring to see if it has repeats. That is about n² substrings, and checking each one costs more. It gets slow quickly.
 *
 * The smarter idea is a sliding window. Picture a frame laid over the string:
 *
 * a b c a b c b b
 * [a b c]            ← window, no repeats, length 3
 *
 * You slide the frame along the string. You never start over.
 *
 * Step 3: The two fingers
 *
 * The window is the stretch between two fingers:
 *
 * right is the front edge. It moves forward one letter at a time.
 * left is the back edge. It only moves forward when it has to.
 *
 * A set holds the letters currently inside the window.
 *
 * Step 4: The sentence
 *
 * “Stretch the window right. If a repeat shows up, shrink from the left until it’s gone.”
 *
 * Two actions:
 *
 * Stretch: take the next letter on the right.
 * Shrink: if that letter is already in the window, drop letters from the left until it isn’t.
 *
 * After each stretch the window is valid again, so you measure its length and keep the best.
 */

fun main() {
//    println("Longest Substring is ${findLongestSubstring("abcdabed")}")
    println(findLongestSubstring("abcabcbbd")) // expect 3
//    println(findLongestSubstring("bbbbb"))    // expect 1
//    println(findLongestSubstring("pwwkew"))   // expect 3
//    println(findLongestSubstring(""))         // expect 0
}

fun findLongestSubstring(input: String): Int {
    if (input.isEmpty()) return 0

    val window = HashSet<Char>()

    var left = 0
    var best = 0

    for (right in input.indices) {
//        println("Right is >> $right")
//        println("Current Window is >> ${window.toList()}")
        while (input[right] in window) {
            window.remove(input[left])
            left++
        }
        window.add(input[right])
        best = maxOf(best, right - left + 1)
        println("right=$right letter='${input[right]}' left=$left window=$window length=${right - left + 1}")
    }

    return best
}