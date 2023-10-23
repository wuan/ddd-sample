package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Product

fun main(args: Array<String>) {
    val cart = Cart()
    val pencil = Product("Apple Pencil")
    cart.add(pencil)
    val sonies = Product("Sony Wireless Headphone")
    cart.add(sonies, 2)
    println("Cart = $cart")
    val products = cart.getItems()
    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
}
