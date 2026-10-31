//package day1.containerwithmostwater

// 5. Container With Most Water  (two pointers)
// Sentence: "Water is limited by the shorter wall, so move the shorter wall."

fun maxArea(height: IntArray): Int {
    var largestArea = 0
    var leftPointer = 0
    var rightPointer = height.size - 1

    while (leftPointer < rightPointer) {
        val minHeight = minOf(height[leftPointer], height[rightPointer])
        val width = rightPointer - leftPointer
        val currentArea = minHeight * width

        largestArea = maxOf(largestArea, currentArea)

        if (height[leftPointer] < height[rightPointer])
            leftPointer++
        else
            rightPointer--
    }
    return largestArea
}

fun main() {
    println("Winner is >> ${maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))}") // expect 49
//    println(maxArea(intArrayOf(1, 1)))                      // expect 1
}
