package com.ddd_bootcamp.application

import com.ddd_bootcamp.domain.Cart
import com.ddd_bootcamp.domain.CartItem
import com.ddd_bootcamp.domain.Product

fun main(args: Array<String>) {
    val cart = Cart()
    val pencil = Product("Apple Pencil")
    cart.add(pencil)
    val sonies = CartItem(Product("Sony Wireless Headphone"), 2)
    cart.add(sonies)
    println("Cart = $cart")
    val products = cart.getItems()
    println("----------------------------------------")
    println("products = $products")
    println("----------------------------------------")
}
