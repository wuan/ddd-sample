package com.ddd_bootcamp.domain

class Competitor(private val listOf: List<Product>) {

    fun prizeOf(productName: ProductName): Price? {
        return listOf.find { it.name == productName }?.price
    }
}