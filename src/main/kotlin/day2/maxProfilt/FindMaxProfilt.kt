package day2.maxProfilt

/**
 * Best Time to Buy and Sell Stock, together
 * Step 1: Understand the problem
 *
 * You get a list of prices, one per day. Buy on one day and sell on a later day. Return the biggest profit you can make, or 0 if no profit is possible.
 *
 * [7, 1, 5, 3, 6, 4] → 5 (buy at 1, sell at 6)
 * [7, 6, 4, 3, 1] → 0 (prices only fall, so don’t trade)
 * Step 2: Why not the obvious way?
 *
 * The obvious way tries every buy day with every later sell day. That is two loops, about n² checks.
 *
 * The smarter question is:
 *
 * “If I sell today, what’s the best day I could have bought?”
 *
 * The best buy day is the cheapest price so far. So walk through the days once and keep track of that.
 *
 * Step 3: The sentence
 *
 * “Track the cheapest price so far. Each day, ask: if I sold today, what’s my profit?”
 *
 * Three actions for every day:
 *
 * Profit if I sell today = today’s price minus the cheapest price so far.
 * Keep the best profit you’ve seen.
 * Update the cheapest price if today is cheaper.
 *
 */
fun main() {
    println("Maximum profit of the day is: ${maxProfit(intArrayOf(7, 1, 2, 6, 9, 4))}")
}

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var cheapestBuy = prices[0]
    var bestProfit = 0

    for (currentPrice in prices) {
        val profit = currentPrice - cheapestBuy
        bestProfit = maxOf(bestProfit, profit)
        cheapestBuy = minOf(cheapestBuy, currentPrice)
    }
    return bestProfit
}