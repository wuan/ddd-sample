package com.ddd_bootcamp.domain

import java.util.*

class Cart(
    private val removedItems: RemovedItems = RemovedItems(),
) {
    private val id: UUID = UUID.randomUUID()
    private val products: MutableList<Item> = mutableListOf()
    fun add(product: Product, quantity: Int = 1) {
        products.add(Item(product, quantity))
    }

    fun add(item: Item) {
        products.add(item)
    }

    fun getItems(): List<Item> {
        return products
    }

    override fun toString(): String {
        return "Cart{" +
                "products=" + products +
                '}'
    }

    fun remove(item: Product) {
        val old = products.find { it.product.name == item.name }
        if (old != null) {
            removedItems.add(old)
            products.remove(old)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Cart

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}