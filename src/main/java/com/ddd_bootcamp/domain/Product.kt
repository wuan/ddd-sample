package com.ddd_bootcamp.domain

data class Product(
    val name: ProductName,
    val price: Price,
    val weight: Weight,
) {
    constructor(name: String, price: Price, weight: Weight = Weight(10)) : this(ProductName(name), price, weight)
}