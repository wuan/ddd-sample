package com.ddd_bootcamp.domain

data class Product(
    val name: String,
    val price: Price? = null,
)