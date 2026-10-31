package day1.validanagram

// 2. Valid Anagram  (hash map / counting)
// Sentence: "Same letters, same counts."

fun isAnagram(firstString: String, secondString: String): Boolean {
    if (firstString.length != secondString.length) return false

    //first approach
    //if(firstString.toList().sorted() == secondString.toList().sorted()) return true



    //second approach

    //    println(firstString.groupingBy { it }.eachCount())
    //    println(secondString.groupingBy { it }.eachCount())

    if (firstString.groupingBy { it }.eachCount() == secondString.groupingBy { it }.eachCount())
        return true

    return false
}

fun main() {
    println(isAnagram("anagram", "nagaram")) // expect true
    println(isAnagram("rat", "car"))         // expect false
}
