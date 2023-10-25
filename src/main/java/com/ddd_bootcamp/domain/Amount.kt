package com.ddd_bootcamp.domain

import java.math.BigInteger

data class Amount(
    val value: BigInteger
) {
    operator fun times(multiplier: Double): Amount {
        return Amount(
            BigInteger.valueOf(
                Math.round(value.toLong() * multiplier)
            )
        )
    }

}
