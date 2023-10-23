package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductShould {
    @Test
    fun publishItsPrice() {
        val product = Product("Bagle", Price(1))

        assertThat(product.price).isEqualTo(Price(1))
    }
}