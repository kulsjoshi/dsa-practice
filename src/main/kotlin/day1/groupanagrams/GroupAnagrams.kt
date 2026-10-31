package day1.groupanagrams

//import jdk.internal.lang.stable.StableUtil.array

//import jdk.internal.org.jline.keymap.KeyMap.key

// 3. Group Anagrams  (hash map)
// Sentence: "Anagrams share a fingerprint, and the fingerprint is the map key."

fun groupAnagrams(input: Array<String>): List<List<String>> {
    val map = HashMap<String, MutableList<String>>()

    for (name in input) {
        val key = name.toCharArray().sorted().toString()
        map.getOrPut(key) {
            mutableListOf()
        }.add(name)
    }
    return map.values.toList()
}

fun main() {
    // expect groups: [eat, tea, ate], [tan, nat], [bat]
    val input = arrayOf("eat", "tea", "tan", "ate", "nat", "bat")
    println(groupAnagrams(input))

    //just for reference
    val map = HashMap<String, MutableList<String>>()
    map.getOrPut("fruit") { mutableListOf() }.add("apple")
    map.getOrPut("fruit") { mutableListOf() }.add("banana")
    map.getOrPut("veg") { mutableListOf() }.add("carrot")
    println(map)
}
