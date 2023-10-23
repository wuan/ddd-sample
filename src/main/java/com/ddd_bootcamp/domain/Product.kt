package com.ddd_bootcamp.domain

data class Product(
        val name: ProductName,
        val price: Price,
) {
    constructor(name: String, price: Price) : this(ProductName(name), price)
}