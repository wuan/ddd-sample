package com.ddd_bootcamp.domain

class Cart {
    private val products: MutableList<CartItem> = mutableListOf()
    fun add(product: Product, quantity: Int = 1) {
        products.add(CartItem(product, quantity))
    }

    fun getItems(): List<CartItem> {
        return products
    }

    override fun toString(): String {
        return "Cart{" +
                "products=" + products +
                '}'
    }
}