package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PriceCalculatorShould {
    @Test
    fun `should not give discount when competitor has no products`() {
        val calculator = PriceCalculator(Competitor(listOf()))
        val product = Product("Bagle", Price(100))

        assertThat(calculator.discountedPrice(product)).isNull()
    }

    @Test
    fun `return null if competitor has product and it is more expensive than 10 percent`() {
        val products = listOf<Product>(Product("Bagle", Price(111)))
        val calculator = PriceCalculator(Competitor(products))
        val product = Product("Bagle", Price(100))

        assertThat(calculator.discountedPrice(product)).isNull()

    }

    @Test
    fun `return null if competitor has product and it is 10 percent `() {
        val products = listOf<Product>(Product("Bagle", Price(110)))
        val calculator = PriceCalculator(Competitor(products))
        val product = Product("Bagle", Price(100))

        assertThat(calculator.discountedPrice(product)).isEqualTo(Price(99))

    }
}