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
        var totalDiscount = 0L

        val orderProducts = items.flatMap { item ->
            MutableList(item.quantity) {
                val product = item.product
                if (item.discountedPrice != null) {
                    totalDiscount += (product.price.amount.value - item.discountedPrice.amount.value).toLong()
                    product.copy(price = item.discountedPrice)
                } else product
            }
        }

        var totalPrice = 0L
        var totalWeight = 0
        orderProducts.forEach {
            totalPrice += it.price.amount.value.toLong()
            totalWeight += it.weight.weight
        }
        totalPrice += Math.round(totalWeight * 0.1)

        return Order(orderProducts, Amount(totalPrice))
    }
}