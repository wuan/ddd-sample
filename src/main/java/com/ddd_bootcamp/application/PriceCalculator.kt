package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Price
import com.ddd_bootcamp.domain.Product

class PriceCalculator(val competitor: Competitor) {
    fun discountedPrice(product: Product): Price? {
        val prizeOf = competitor.prizeOf(productName = product.name)

        if (prizeOf == null) {
            return null
        }

        val discounted = Price((prizeOf.amount.value.toLong() * 0.9).toInt())
        if (discounted < product.price) { return product.price }

        return null
    }
}
