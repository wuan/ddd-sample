package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.`as`
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CartTest {
    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        val product = Product("Some test product")
        cart.add(product)
        val actual = cart.getProducts()

        assertThat(actual).hasSize(1)
        assertThat(actual[0].name).isEqualTo("Some test product", actual[0].name)
    }
}