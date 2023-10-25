package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PriceShould {
    @Test
    fun returnAmountAsAmount() {
        val price = Price(42)

        assertThat(price.amount).isExactlyInstanceOf(Amount::class.java)
    }

    @Test
    fun containCurrency() {
        val price = Price(42, "EUR")

        assertThat(price.currency).isExactlyInstanceOf(String::class.java)
    }
}