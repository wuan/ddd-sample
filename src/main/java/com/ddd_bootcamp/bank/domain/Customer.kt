package com.ddd_bootcamp.bank.domain

import java.util.*

class Customer(
    private val id: UUID = UUID.randomUUID(),
    accounts: List<Account>,
    address: Address,
) {
    val accounts = accounts.toMutableList()
    var address: Address = address
        private set

    fun updateAddress(address: Address) {
        this.address = address
    }
}

data class Account(
    private val id: UUID = UUID.randomUUID(),
    val address: Address
)

data class Address(
    val city: City
)

data class City(
    val name: String
)
