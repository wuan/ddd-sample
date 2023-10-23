package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Product
import com.ddd_bootcamp.domain.RemovedItems

fun main(args: Array<String>) {
    val removedItems = RemovedItems()
    val cart = Cart(removedItems)
    val pencil = Product("Apple Pencil")
    cart.add(pencil)
    val sonies = Product("Sony Wireless Headphone")
    cart.add(sonies, 2)
    println("Cart = $cart")
    val products = cart.getItems()

    cart.remove(sonies)

    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
    removedItems.get().forEach {
        println("Removed item = ${it}")
    }
}
