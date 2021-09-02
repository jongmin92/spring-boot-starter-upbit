package com.jongmin.upbit.client.retrofit.exchange.api.account

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitExchangeAccountsApiProtocolTest {

    @Test
    fun `upbitAccountResponse toDomain`() {
        // given
        val account = upbitAccountResponseFixture()

        // when
        val result = account.toDomain()

        // then
        assertAll("account",
            { assertThat(result.currency).isEqualTo(account.currency) },
            { assertThat(result.balance).isEqualTo(account.balance) },
            { assertThat(result.locked).isEqualTo(account.locked) },
            { assertThat(result.avgBuyPrice).isEqualTo(account.avgBuyPrice) },
            { assertThat(result.avgBuyPriceModified).isEqualTo(account.avgBuyPriceModified) },
            { assertThat(result.unitCurrency).isEqualTo(account.unitCurrency) }
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
