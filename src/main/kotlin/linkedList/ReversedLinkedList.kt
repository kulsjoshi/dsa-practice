package linkedList

/**
 *
 * Reverse Linked List, together
 * Step 1: Understand the problem
 *
 * A linked list is a chain of nodes. Each node holds a value and an arrow (next) pointing to the next node. You get the first node (the head). Reverse the chain and return the new first node.
 *
 * Before:  1 → 2 → 3 → null
 * After:   3 → 2 → 1 → null
 *
 * You are not creating new values. You are flipping the arrows.
 *
 * Step 2: The node class
 *
 * Kotlin doesn’t have a built-in linked list node for this, so the problem gives you one:
 *
 * kotlin
 * class ListNode(var value: Int, var next: ListNode? = null)
 * value is the number stored in the node.
 * next is the node after it, or null at the end of the chain. The ? means “can be null”.
 * Step 3: Why this approach?
 *
 * Reversing means every node should point backwards instead of forwards.
 *
 * The catch: if you change a node’s arrow, you lose the way to the rest of the chain. So before flipping, save where the arrow used to point.
 *
 * Step 4: The sentence
 *
 * “Save the next one. Flip my arrow back. Step forward.”
 *
 * Three actions for every node:
 *
 * Save the next node, so you don’t lose the rest.
 * Flip this node’s arrow to point at the previous node.
 * Step forward with both fingers.
 * Step 5: The two fingers
 * prev is the node behind you. At the start it’s null, because the new last node must point to nothing.
 * current is the node you’re working on. It starts at head.
 *
 */
class ListNode(var value: Int, var next: ListNode? = null)

fun reverseList(head: ListNode?): ListNode? {
    var previous: ListNode? = null
    var current = head

    while (current != null) {
        val next = current.next
        current.next = previous
        previous = current
        current = next
    }
    return previous
}

fun toLinkedList(vararg values: Int): ListNode? {
    var head: ListNode? = null
    for (v in values.reversed()) {
        head = ListNode(v, head)
    }
    return head
}

fun printList(head: ListNode?) {
    val out = mutableListOf<Int>()
    var current = head
    while (current != null) {
        out.add(current.value)
        current = current.next
    }
    println(out)
}

fun main() {
    printList(reverseList(toLinkedList(1, 2, 3, 4, 5)))
}