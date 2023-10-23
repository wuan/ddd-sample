package com.ddd_bootcamp.domain

class Cart {
    private val products: MutableList<Product> = mutableListOf()
    fun add(product: Product) {
        products.add(product)
    }

    fun getProducts(): List<Product> {
        return products
    }

    override fun toString(): String {
        return "Cart{" +
                "products=" + products +
                '}'
    }
}