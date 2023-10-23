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

    @Test
    fun shouldAdd2ProductsToCart() {
        val cart = Cart()
        val product = Product("Some test product")
        val sony = Product("Sony Wireless Headphone")
        cart.add(product)
        cart.add(sony)
        val actual = cart.getProducts()

        assertThat(actual).hasSize(2)
        assertThat(actual).extracting("name").contains("Some test product", "Sony Wireless Headphone")
    }
}