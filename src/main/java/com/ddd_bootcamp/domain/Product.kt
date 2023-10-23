package com.ddd_bootcamp.domain

data class Product(
        val name: ProductName,
        val price: Price? = null,
) {
    constructor(name: String, price: Price?) : this(ProductName(name), price)
    constructor(name: String) : this(ProductName(name))
}