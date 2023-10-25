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

    @Test
    fun adhereEqualContract() {
        val price = Price(42, "EUR")

        assertThat(price).isEqualTo(Price(42, "EUR"))
        assertThat(price).isNotEqualTo(Price(43, "EUR"))
    }

    @Test
    fun beComparable() {
        val price = Price(42, "EUR")

        assertThat(price.compareTo(Price(43, "EUR"))).isEqualTo(-1)
        assertThat(price.compareTo(Price(42, "EUR"))).isEqualTo(0)
        assertThat(price.compareTo(Price(41, "EUR"))).isEqualTo(1)
    }
}