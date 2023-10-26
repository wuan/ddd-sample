package com.ddd_bootcamp.domain

import java.util.*

class Cart(
    private val removedItems: RemovedItems = RemovedItems(),
    private val priceCalculator: PriceCalculator = PriceCalculator(),
) {
    private val id: UUID = UUID.randomUUID()
    private val items: MutableList<Item> = mutableListOf()

    fun add(product: Product, quantity: Int = 1) {
        add(Item(product, quantity))
    }

    fun add(item: Item) {
        items.add(item.copy(discountedPrice = priceCalculator.discountedPrice(item.product)))
    }

    fun getItems(): List<Item> {
        return items
    }

    override fun toString(): String {
        return "Cart{" +
                "products=" + items +
                '}'
    }

    fun remove(item: Product) {
        val old = items.find { it.product.name == item.name }
        if (old != null) {
            removedItems.add(old)
            items.remove(old)
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

    fun checkout(): Order {
        val list = mutableListOf<String>().apply {
            repeat(2){ this.add(element = "YourObject($it)") }.apply { Product() }

        }
        return Order()
//        TODO("Not implemented")
//        return Order(items.stream().flatMap { p -> p.quantity })
    }
}