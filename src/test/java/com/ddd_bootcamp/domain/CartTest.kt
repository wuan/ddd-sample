package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigInteger

internal class CartTest {
    @Test
    fun shouldAddProductToCart() {
        val cart = Cart()
        val product = Product("Some test product", Price(10))
        cart.add(product)
        val actual = cart.getItems()

        assertThat(actual).hasSize(1)
        assertThat(actual[0].product.name.value).isEqualTo("Some test product")
    }

    @Test
    fun shouldAdd2ProductsToCart() {
        val cart = Cart()
        val product = Product("Some test product", Price(10))
        val sony = Product("Sony Wireless Headphone", Price(350))
        cart.add(product)
        cart.add(sony)
        val actual = cart.getItems()

        assertThat(actual).hasSize(2)
        assertThat(actual).extracting("product.name.value").contains("Some test product", "Sony Wireless Headphone")
    }

    @Test
    fun shouldAddProductWithQuantity() {
        val cart = Cart()
        val product = Product("Some test product", Price(10))
        cart.add(product, 2)
        val actual = cart.getItems()

        assertThat(actual).hasSize(1)
        assertThat(actual[0].quantity).isEqualTo(2)
        assertThat(actual[0].product.name).isEqualTo(ProductName("Some test product"))
    }

    @Test
    fun shouldRemoveNamedItemFromCart() {
        val cart = Cart()
        val product = Product("Some test product", Price(10))
        val sony = Product("Sony Wireless Headphone", Price(350))
        cart.add(product)
        cart.add(sony)

        cart.remove(sony)

        assertThat(cart.getItems()).hasSize(1)
        assertThat(cart.getItems()[0].product).isEqualTo(Product("Some test product", Price(10)))
    }

    @Test
    fun shouldStoreHistoryOfCart() {
        val removedItems = RemovedItems()

        val cart = Cart(removedItems)
        val product = Product("Some test product", Price(10))
        cart.add(product)

        cart.remove(product)

        val actuallyRemovedItems = removedItems.get()
        assertThat(actuallyRemovedItems).extracting("product").containsExactly(product)
    }

    @Test
    fun shouldHandleMultipleCarts() {
        val cart1 = Cart()
        val cart2 = Cart()
        val item1 = Item( Product("Sony Wireless headphone", Price(350)), 1)
        val item2 = Item( Product("Sony Wireless headphone", Price(350)), 1)
        cart1.add(item1)
        cart2.add(item2)

        assertThat(cart1).isNotSameAs(cart2)
        assertThat(cart1).isNotEqualTo(cart2)
        assertThat(cart1).isEqualTo(cart1)
    }

    @Test
    fun productIncludesPrice() {
        val price = Price(100)
        val product = Product("Some test product", price)

        assertThat(product.price).isEqualTo(price)
        assertThat(product.price.amount).isEqualTo(Amount(BigInteger.valueOf(100)))
    }

    @Test
    fun `should not give discount when other prize is null`() {
        val product = Product("Bagle", Price(100))
        val cart = Cart()
        cart.add(Item(product, 1))

        assertThat(cart.discountedPrice(product, null)).isNull()
    }


    @Test
    fun `should not give discount when other prize is 10 percent higher`() {
        val product = Product("Bagle", Price(100))
        val cart = Cart()
        cart.add(Item(product, 1))

        assertThat(cart.discountedPrice(product, Price(110))).isNull()
    }

    @Test
    fun `should not give discount when other prize is more than 10 percent higher`() {
        val product = Product("Bagle", Price(100))
        val cart = Cart()
        cart.add(Item(product, 1))

        assertThat(cart.discountedPrice(product, Price(110))).isNull()
    }
}