package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.Product

fun main(args: Array<String>) {
    val cart = Cart()
    val product = Product("Apple Pencil")
    cart.add(product)
    println("Cart = $cart")
    val products = cart.products
    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
}
