package com.ddd_bootcamp.domain

class Cart {
    private val products: MutableList<Item> = mutableListOf()
    fun add(product: Product, quantity: Int = 1) {
        products.add(Item(product, quantity))
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
        products.remove(old)
    }
}