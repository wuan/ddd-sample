package com.ddd_bootcamp.domain

class PriceCalculator(val competitor: Competitor = Competitor(listOf())) {
    fun discountedPrice(product: Product): Price? {
        val prizeOf = competitor.prizeOf(productName = product.name) ?: return null

        val discounted = prizeOf.reducedByPercentage(10.0)

        return if (discounted < product.price) {
            discounted
        } else {
            null
        }
    }
}
