package com.ddd_bootcamp.domain

class PriceCalculator(val competitor: Competitor = Competitor(listOf())) {
    fun discountedPrice(product: Product): Price? {
        val prizeOf = competitor.prizeOf(productName = product.name) ?: return null

        val discounted = product.price.copy(amount = prizeOf.amount * 0.9)

        return if (discounted < product.price) {
            discounted
        } else { null }
    }
}
