package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Price
import com.ddd_bootcamp.domain.Product
import com.ddd_bootcamp.domain.RemovedItems

fun main(args: Array<String>) {
    val removedItems = RemovedItems()
    val competitor = Competitor(listOf(Product("Bagle", Price(10)), Product("Apple Pencil", Price(200))))
    val cart = Cart(removedItems, competitor)
    val pencil = Product("Apple Pencil", Price(200))
    cart.add(pencil)
    val sonies = Product("Sony Wireless Headphone", Price(350))
    cart.add(sonies, 2)
    println("Cart = $cart")
    val products = cart.getItems()

    cart.remove(sonies)

    println("----------------------------------------")
    println("products = $products")
    products.forEach {
        println("${it.product.name} ${it.product.price} ${cart.discountedPrice(it.product, competitor.prizeOf(it.product.name))}")
    }
    println("----------------------------------------")
    removedItems.get().forEach {
        println("Removed item = ${it}")
    }
}
