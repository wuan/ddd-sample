package com.ddd_bootcamp.domain

class Cart {
    private val products: MutableList<CartItem> = mutableListOf()
    fun add(product: Product) {
        products.add(CartItem(product, 1))
    }

    fun add(product: CartItem) {
        products.add(product)
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