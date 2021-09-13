package com.jongmin.upbit.client.retrofit.quotation.api.ticker

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitQuotationTickerApiProtocolTest {
    @Test
    fun `upbitTickerResponse to Domain`() {
        // given
        val upbitTickerResponse = upbitTickerResponseFixture()

        // when
        val result = upbitTickerResponse.toDomain()

        assertAll(
            "tickerResponse",
            { Assertions.assertThat(result.market).isEqualTo(upbitTickerResponse.market) },
            { Assertions.assertThat(result.tradeDate).isEqualTo(upbitTickerResponse.tradeDate) },
            { Assertions.assertThat(result.tradeTime).isEqualTo(upbitTickerResponse.tradeTime) },
            { Assertions.assertThat(result.tradeDateKst).isEqualTo(upbitTickerResponse.tradeDateKst) },
            { Assertions.assertThat(result.tradeTimeKst).isEqualTo(upbitTickerResponse.tradeTimeKst) },
            { Assertions.assertThat(result.openingPrice).isEqualTo(upbitTickerResponse.openingPrice) },
            { Assertions.assertThat(result.highPrice).isEqualTo(upbitTickerResponse.highPrice) },
            { Assertions.assertThat(result.lowPrice).isEqualTo(upbitTickerResponse.lowPrice) },
            { Assertions.assertThat(result.tradePrice).isEqualTo(upbitTickerResponse.tradePrice) },
            { Assertions.assertThat(result.prevClosingPrice).isEqualTo(upbitTickerResponse.prevClosingPrice) },
            { Assertions.assertThat(result.changePrice).isEqualTo(upbitTickerResponse.changePrice) },
            { Assertions.assertThat(result.changeRate).isEqualTo(upbitTickerResponse.changeRate) },
            { Assertions.assertThat(result.signedChangePrice).isEqualTo(upbitTickerResponse.signedChangePrice) },
            { Assertions.assertThat(result.signedChangeRate).isEqualTo(upbitTickerResponse.signedChangeRate) },
            { Assertions.assertThat(result.tradeVolume).isEqualTo(upbitTickerResponse.tradeVolume) },
            { Assertions.assertThat(result.accTradePrice).isEqualTo(upbitTickerResponse.accTradePrice) },
            { Assertions.assertThat(result.accTradePrice24h).isEqualTo(upbitTickerResponse.accTradePrice24h) },
            { Assertions.assertThat(result.accTradeVolume).isEqualTo(upbitTickerResponse.accTradeVolume) },
            { Assertions.assertThat(result.accTradeVolume24h).isEqualTo(upbitTickerResponse.accTradeVolume24h) },
            { Assertions.assertThat(result.highest52WeekPrice).isEqualTo(upbitTickerResponse.highest52WeekPrice) },
            { Assertions.assertThat(result.highest52WeekDate).isEqualTo(upbitTickerResponse.highest52WeekDate) },
            { Assertions.assertThat(result.lowest52WeekPrice).isEqualTo(upbitTickerResponse.lowest52WeekPrice) },
            { Assertions.assertThat(result.lowest52WeekDate).isEqualTo(upbitTickerResponse.lowest52WeekDate) },
            { Assertions.assertThat(result.timestamp).isEqualTo(upbitTickerResponse.timestamp) },
            )
    }
}

internal fun upbitTickerResponseFixture() = UpbitTickerResponse(
    market = "btc",
    tradeDate = "2021-07-21",
    tradeTime = "00:00",
    tradeDateKst = "2021-07-21",
    tradeTimeKst = "09:00",
    openingPrice = 0.00,
    highPrice = 0.00,
    lowPrice = 0.00,
    tradePrice = 0.00,
    prevClosingPrice = 0.00,
    change = UpbitChangeProtocol.EVEN,
    changePrice = 0.00,
    changeRate = 0.00,
    signedChangePrice = 0.00,
    signedChangeRate = 0.00,
    tradeVolume = 0.00,
    accTradePrice = 0.00,
    accTradePrice24h = 0.00,
    accTradeVolume = 0.00,
    accTradeVolume24h = 0.00,
    highest52WeekPrice = 0.00,
    highest52WeekDate = "2020-08-21",
    lowest52WeekPrice = 0.00,
    lowest52WeekDate = "2020-05-21",
    timestamp = 1600000
)
