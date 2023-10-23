package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CartTest {
    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        val product = Product("Some test product")
        cart.add(product)
        val actual = cart.getItems()

        assertThat(actual).hasSize(1)
        assertThat(actual[0].product.name).isEqualTo("Some test product")
    }

    @Test
    fun shouldAdd2ProductsToCart() {
        val cart = Cart()
        val product = Product("Some test product")
        val sony = Product("Sony Wireless Headphone")
        cart.add(product)
        cart.add(sony)
        val actual = cart.getItems()

        assertThat(actual).hasSize(2)
        assertThat(actual).extracting("product.name").contains("Some test product", "Sony Wireless Headphone")
    }

    @Test
    fun shouldAddProductWithQuantity() {
        val cart = Cart()
        val product = Product("Some test product")
        val item = CartItem(product, 2)
        cart.add(item)
        val actual = cart.getItems()

        assertThat(actual).hasSize(1)
        assertThat(actual[0].quantity).isEqualTo(2)
        assertThat(actual[0].product.name).isEqualTo("Some test product")
    }
}