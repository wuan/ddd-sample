package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Price
import com.ddd_bootcamp.domain.Product
import com.ddd_bootcamp.domain.ProductName

class Competitor(private val listOf: List<Product>) {

    fun prizeOf(productName: ProductName): Price? {
        return listOf.find { it.name == productName }?.price
    }
}