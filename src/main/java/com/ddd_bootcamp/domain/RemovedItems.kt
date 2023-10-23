package com.ddd_bootcamp.domain

class RemovedItems {
    private val items: MutableList<Item> = mutableListOf()

    fun add(item: Item) {
        items.add(item)
    }

    fun get(): List<Item> {
        return items
    }
}
