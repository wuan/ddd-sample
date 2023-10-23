package com.ddd_bootcamp.domain

import java.math.BigInteger

data class Price(
    val amount: Amount,
    val currency: String
) {
    constructor(value: Int) : this(Amount(BigInteger.valueOf(value.toLong())), "USD")
}
