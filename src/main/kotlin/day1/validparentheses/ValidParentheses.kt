//package day1.validparentheses

// 6. Valid Parentheses  (stack)
// Sentence: "Open goes on the stack. Close must match the top. Stack must end empty."

fun isValid(inputString: String): Boolean {
    val stack = ArrayDeque<Char>()
    val pairs = mapOf(')' to '(', '}' to '{', ']' to '[')

    println("Input String >> $inputString")

    for (char in inputString) {
        println("Current Char >> $char")

        if (char in pairs) {

            val needed = pairs[char]
            println("$char is CLOSER, needs $needed on the top. Stack now: $stack")

            if (stack.isEmpty()) {
                println("-> stack is empty, nothing to close. FALSE")
                return false
            }

            val top = stack.removeLast()
            if (top != needed) {
                println("-> top was $top, not $needed FALSE ")
                return false
            }

            println("-> matched, removed $top. Stack now: $stack")
        } else {
            stack.addLast(char)
            println("$char is an OPENER, pushed. Stack now: $stack")
        }
    }

    println("End of string. Stack: $stack")
    return stack.isEmpty()
}

fun main() {
//    println(isValid("()[]{}")) // expect true
//    println(isValid("(]"))     // expect false
    println(isValid("([)]"))   // expect false
//    println(isValid("{[]}"))   // expect true
}
