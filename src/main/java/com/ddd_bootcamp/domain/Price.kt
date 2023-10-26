package com.ddd_bootcamp.domain

import java.math.BigInteger

data class Price(
    val amount: Amount,
    val currency: String
) {
    operator fun compareTo(price: Price?): Int {
        return amount.value.compareTo(price?.amount?.value)
    }

    constructor(value: Long, currency: String = "USD") : this(Amount(BigInteger.valueOf(value)), currency)

    fun reducedByPercentage(percentage: Double): Price {
        return copy(amount=amount.reducedByPercentage(percentage))
    }
}
