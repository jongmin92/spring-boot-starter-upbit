package com.jongmin.upbit.client.retrofit.quatation.api.trade

import com.jongmin.upbit.client.retrofit.quotation.api.trade.UpbitTickResponse
import com.jongmin.upbit.client.retrofit.quotation.api.trade.toDomain
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitQuotationTradeApiProtocolTest {
    @Test
    fun `upbitTickResponse to Domain`() {
        // given
        val tickResponse = upbitTickResponseFixture()

        // when
        val result = tickResponse.toDomain()

        assertAll(
            "tickResponse",
            { Assertions.assertThat(result.market).isEqualTo(tickResponse.market) },
            { Assertions.assertThat(result.tradeDateUtc).isEqualTo(tickResponse.tradeDateUtc) },
            { Assertions.assertThat(result.tradeTimeUtc).isEqualTo(tickResponse.tradeTimeUtc) },
            { Assertions.assertThat(result.timestamp).isEqualTo(tickResponse.timestamp) },
            { Assertions.assertThat(result.tradePrice).isEqualTo(tickResponse.tradePrice) },
            { Assertions.assertThat(result.tradeVolume).isEqualTo(tickResponse.tradeVolume) },
            { Assertions.assertThat(result.prevClosingPrice).isEqualTo(tickResponse.prevClosingPrice) },
            { Assertions.assertThat(result.changePrice).isEqualTo(tickResponse.changePrice) },
            { Assertions.assertThat(result.askBid).isEqualTo(tickResponse.askBid) },
            { Assertions.assertThat(result.sequentialId).isEqualTo(tickResponse.sequentialId) },
        )
    }
}

internal fun upbitTickResponseFixture() = UpbitTickResponse(
    market = "market",
    tradeDateUtc = "2021-07-21",
    tradeTimeUtc = "00:00",
    timestamp = 1600000,
    tradePrice = 0.00,
    tradeVolume = 0.00,
    prevClosingPrice = 0.00,
    changePrice = 0.00,
    askBid = "buy",
    sequentialId = 0,
)

