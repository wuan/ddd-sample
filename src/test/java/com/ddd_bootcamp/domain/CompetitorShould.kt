package com.ddd_bootcamp.domain

import com.ddd_bootcamp.application.Competitor
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CompetitorShould {
    @Test
    fun returnNullIfNoProductFound() {
        val competitor = Competitor(listOf(Product("Kaese", Price(10))))
        val product = ProductName("Bagle")

        assertThat(competitor.prizeOf(product)).isNull()
    }

    @Test
    fun returnPriceOfProductFound() {
        val competitor = Competitor(listOf(Product("Bagle", Price(10))))
        val product = ProductName("Bagle")

        assertThat(competitor.prizeOf(product)).isEqualTo(Price(10))
    }
}