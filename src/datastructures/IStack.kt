package datastructures

interface IStack {
    fun push(t: Int)
    fun pop(): Int?
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}