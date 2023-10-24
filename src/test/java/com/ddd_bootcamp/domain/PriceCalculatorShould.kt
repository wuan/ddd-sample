package com.ddd_bootcamp.domain

import com.ddd_bootcamp.application.Competitor
import com.ddd_bootcamp.application.PriceCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PriceCalculatorShould {
    @Test
    fun `should not give discount when competitor has no products`() {
        val calculator = PriceCalculator(Competitor(listOf()))
        val product = Product("Bagle", Price(100))

        assertThat(calculator.discountedPrice(product)).isNull()
    }
}