package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Price
import com.ddd_bootcamp.domain.Product
import com.ddd_bootcamp.domain.RemovedItems

fun main(args: Array<String>) {
    val removedItems = RemovedItems()
    val priceCalculator = PriceCalculator(
        Competitor(
            listOf(
                Product("Bagle", Price(10)),
                Product("Apple Pencil", Price(200)),
                Product("Sony Wireless Headphone", Price(400))
            )
        )
    )

    val cart = Cart(removedItems, priceCalculator)
    val pencil = Product("Apple Pencil", Price(200))
    cart.add(pencil)
    val sonies = Product("Sony Wireless Headphone", Price(350))
    cart.add(sonies, 2)
    val bagles = Product("Bagle", Price(10))
    cart.add(bagles, 2)
    println("Cart = $cart")
    val products = cart.getItems()

    cart.remove(bagles)

    println("----------------------------------------")
    println("Your cart:")
    products.forEach {
        println("${it.product.name} ${it.product.price} ${it.discountedPrice}")
    }
    println("----------------------------------------")
    removedItems.get().forEach {
        println("Removed item = $it")
    }
}
