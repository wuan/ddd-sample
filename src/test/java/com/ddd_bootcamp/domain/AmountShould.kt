package com.ddd_bootcamp.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.math.BigInteger

class AmountShould {

    @Test
    fun returnValueAsBigInteger() {
        val amount = Amount(BigInteger.valueOf(42))

        assertThat(amount.value).isExactlyInstanceOf(BigInteger::class.java)
    }
}