package com.jongmin.upbit.client.retrofit.exchange.api.account

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitExchangeAccountsApiProtocolTest {

    @Test
    fun `upbitAccountResponse toDomain`() {
        // given
        val accountResponse = upbitAccountResponseFixture()

        // when
        val result = accountResponse.toDomain()

        // then
        assertAll("account",
            { assertThat(result.currency).isEqualTo(accountResponse.currency) },
            { assertThat(result.balance).isEqualTo(accountResponse.balance) },
            { assertThat(result.locked).isEqualTo(accountResponse.locked) },
            { assertThat(result.avgBuyPrice).isEqualTo(accountResponse.avgBuyPrice) },
            { assertThat(result.avgBuyPriceModified).isEqualTo(accountResponse.avgBuyPriceModified) },
            { assertThat(result.unitCurrency).isEqualTo(accountResponse.unitCurrency) }
        )
    }
}

internal fun upbitAccountResponseFixture() = UpbitAccountResponse(
    currency = "currency",
    balance = "balance",
    locked = "locked",
    avgBuyPrice = "avgBuyPrice",
    avgBuyPriceModified = true,
    unitCurrency = "unitCurrency"
)
