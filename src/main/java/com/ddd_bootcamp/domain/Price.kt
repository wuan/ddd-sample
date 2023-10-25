package com.ddd_bootcamp.domain

import java.math.BigInteger

data class Price(
    val amount: Amount,
    val currency: String
) {
    operator fun compareTo(price: Price?): Int {
        return amount.value.compareTo(price?.amount?.value)
    }

    constructor(value: Int) : this(Amount(BigInteger.valueOf(value.toLong())), "USD")
    constructor(value: Int, currency: String) : this(Amount(BigInteger.valueOf(value.toLong())), currency)
}
