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

    internal fun updateAddress(address: Address) {
        this.address = address
        accounts.forEach { it.updateAddress(address) }
    }
}

class Account(
    private val id: UUID = UUID.randomUUID(),
    address: Address
) {
    var address: Address = address
        private set

    internal fun updateAddress(address: Address) {
        this.address = address
    }
}

data class Address(
    val city: City
)

data class City(
    val name: String
)
