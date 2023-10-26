package com.ddd_bootcamp.domain

import java.math.BigInteger

data class Amount(
    val value: BigInteger
) {
    constructor(value: Long) : this(BigInteger.valueOf(value))

    operator fun times(multiplier: Double): Amount {
        return Amount(
            BigInteger.valueOf(
                Math.round(value.toLong() * multiplier)
            )
        )
    }

    fun reducedByPercentage(percentage: Double): Amount {
        return this * (1 - percentage / 100.0)
    }
}
