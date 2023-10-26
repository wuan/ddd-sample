package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductShould {
    @Test
    fun publishItsPrice() {
        val product = Product("Bagle", Price(1))

        assertThat(product.price).isEqualTo(Price(1))
    }

    @Test
    fun publishItsWeight() {
        val product = Product("Bagle", Price(1), Weight(10))

        assertThat(product.weight).isEqualTo(Weight(10))
    }
}