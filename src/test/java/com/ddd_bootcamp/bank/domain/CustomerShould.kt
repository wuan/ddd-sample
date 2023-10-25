package com.ddd_bootcamp.bank.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CustomerShould {
    @Test
    fun haveAddressReadable() {
        val address = Address(City("London"))
        val customer = Customer(accounts = listOf(), address = address)

        assertThat(customer.address).isEqualTo(address)
    }

    @Test
    fun haveUpdateableAdress() {
        val address = Address(City("London"))
        val customer = Customer(accounts = listOf(), address = address)
        val newAddress = Address(City("Paris"))

        customer.updateAddress(newAddress)

        assertThat(customer.address).isEqualTo(newAddress)
    }
}