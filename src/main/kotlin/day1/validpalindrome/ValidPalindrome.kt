package day1.validpalindrome

//import jdk.internal.org.jline.utils.Colors.s

// 4. Valid Palindrome  (two pointers)
// Sentence: "Two fingers, outside in. Skip the junk, compare lowercase."

fun isPalindrome(rawInput: String): Boolean {
    val cleanInput = rawInput.filter { it.isLetterOrDigit() }
    println("Clean Input >> $cleanInput")

    var leftPointer = 0
    var rightPointer = cleanInput.length - 1

    while (leftPointer < rightPointer) {
        if (cleanInput[leftPointer] != cleanInput[rightPointer]) return false
        leftPointer++
        rightPointer--
    }

    return true
}

fun main() {
    println(isPalindrome("A man, a plan, a canal: Panama")) // expect true
    println(isPalindrome("race a car"))                     // expect false
    println(isPalindrome(" "))                              // expect true
}
