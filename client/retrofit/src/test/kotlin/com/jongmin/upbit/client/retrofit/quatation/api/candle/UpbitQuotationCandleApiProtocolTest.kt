package com.jongmin.upbit.client.retrofit.quatation.api.candle

import com.jongmin.upbit.client.retrofit.quotation.api.candle.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitQuotationCandleApiProtocolTest {

    @Test
    fun `upbitMinuteCandle to Domain`() {
        // given
        val candleResponse = upbitMinuteCandleResponseFixture()

        // when
        val result = candleResponse.toDomain()

        assertAll("minuteCandle",
            { assertThat(result.market).isEqualTo(candleResponse.market)},
            { assertThat(result.candleDateTimeUtc).isEqualTo(candleResponse.candleDateTimeUtc)},
            { assertThat(result.candleDateTimeKst).isEqualTo(candleResponse.candleDateTimeKst)},
            { assertThat(result.openingPrice).isEqualTo(candleResponse.openingPrice)},
            { assertThat(result.highPrice).isEqualTo(candleResponse.highPrice)},
            { assertThat(result.lowPrice).isEqualTo(candleResponse.lowPrice)},
            { assertThat(result.tradePrice).isEqualTo(candleResponse.tradePrice)},
            { assertThat(result.timestamp).isEqualTo(candleResponse.timestamp)},
            { assertThat(result.candleAccTradePrice).isEqualTo(candleResponse.candleAccTradePrice)},
            { assertThat(result.candleAccTradeVolume).isEqualTo(candleResponse.candleAccTradeVolume)},
            { assertThat(result.unit).isEqualTo(candleResponse.unit)},
        )
    }

    @Test
    fun `upbitDayCandle to Domain`() {
        // given
        val candleResponse = upbitDayCandleResponseFixture()

        // when
        val result = candleResponse.toDomain()

        assertAll("dayCandle",
            { assertThat(result.market).isEqualTo(candleResponse.market)},
            { assertThat(result.candleDateTimeUtc).isEqualTo(candleResponse.candleDateTimeUtc)},
            { assertThat(result.candleDateTimeKst).isEqualTo(candleResponse.candleDateTimeKst)},
            { assertThat(result.openingPrice).isEqualTo(candleResponse.openingPrice)},
            { assertThat(result.highPrice).isEqualTo(candleResponse.highPrice)},
            { assertThat(result.lowPrice).isEqualTo(candleResponse.lowPrice)},
            { assertThat(result.tradePrice).isEqualTo(candleResponse.tradePrice)},
            { assertThat(result.timestamp).isEqualTo(candleResponse.timestamp)},
            { assertThat(result.candleAccTradePrice).isEqualTo(candleResponse.candleAccTradePrice)},
            { assertThat(result.candleAccTradeVolume).isEqualTo(candleResponse.candleAccTradeVolume)},
            { assertThat(result.prevClosingPrice).isEqualTo(candleResponse.prevClosingPrice)},
            { assertThat(result.changePrice).isEqualTo(candleResponse.changePrice)},
            { assertThat(result.changeRate).isEqualTo(candleResponse.changeRate)},
            { assertThat(result.convertedTradePrice).isEqualTo(candleResponse.convertedTradePrice)},
        )
    }

    @Test
    fun `upbitWeekCandle to Domain`() {
        // given
        val candleResponse = upbitWeekCandleResponseFixture()

        // when
        val result = candleResponse.toDomain()

        assertAll("weekCandle",
            { assertThat(result.market).isEqualTo(candleResponse.market)},
            { assertThat(result.candleDateTimeUtc).isEqualTo(candleResponse.candleDateTimeUtc)},
            { assertThat(result.candleDateTimeKst).isEqualTo(candleResponse.candleDateTimeKst)},
            { assertThat(result.openingPrice).isEqualTo(candleResponse.openingPrice)},
            { assertThat(result.highPrice).isEqualTo(candleResponse.highPrice)},
            { assertThat(result.lowPrice).isEqualTo(candleResponse.lowPrice)},
            { assertThat(result.tradePrice).isEqualTo(candleResponse.tradePrice)},
            { assertThat(result.timestamp).isEqualTo(candleResponse.timestamp)},
            { assertThat(result.candleAccTradePrice).isEqualTo(candleResponse.candleAccTradePrice)},
            { assertThat(result.candleAccTradeVolume).isEqualTo(candleResponse.candleAccTradeVolume)},
            { assertThat(result.firstDayOfPeriod).isEqualTo(candleResponse.firstDayOfPeriod)},
        )
    }

    @Test
    fun `upbitMonthCandle to Domain`() {
        // given
        val candleResponse = upbitMonthCandleResponseFixture()

        // when
        val result = candleResponse.toDomain()

        assertAll("monthCandle",
            { assertThat(result.market).isEqualTo(candleResponse.market)},
            { assertThat(result.candleDateTimeUtc).isEqualTo(candleResponse.candleDateTimeUtc)},
            { assertThat(result.candleDateTimeKst).isEqualTo(candleResponse.candleDateTimeKst)},
            { assertThat(result.openingPrice).isEqualTo(candleResponse.openingPrice)},
            { assertThat(result.highPrice).isEqualTo(candleResponse.highPrice)},
            { assertThat(result.lowPrice).isEqualTo(candleResponse.lowPrice)},
            { assertThat(result.tradePrice).isEqualTo(candleResponse.tradePrice)},
            { assertThat(result.timestamp).isEqualTo(candleResponse.timestamp)},
            { assertThat(result.candleAccTradePrice).isEqualTo(candleResponse.candleAccTradePrice)},
            { assertThat(result.candleAccTradeVolume).isEqualTo(candleResponse.candleAccTradeVolume)},
            { assertThat(result.firstDayOfPeriod).isEqualTo(candleResponse.firstDayOfPeriod)},
        )
    }
}

internal fun upbitMinuteCandleResponseFixture() = UpbitMinuteCandleResponse(
    market = "market",
    candleDateTimeUtc = "candleDateTimeUtc",
    candleDateTimeKst = "candleDateTimeKst",
    openingPrice = 0.00,
    highPrice = 0.00,
    lowPrice = 0.00,
    tradePrice = 0.00,
    timestamp = 1600000,
    candleAccTradePrice = 0.00,
    candleAccTradeVolume = 0.00,
    unit = 1
)

internal fun upbitDayCandleResponseFixture() = UpbitDayCandleResponse(
    market = "market",
    candleDateTimeUtc = "candleDateTimeUtc",
    candleDateTimeKst = "candleDateTimeKst",
    openingPrice = 0.00,
    highPrice = 0.00,
    lowPrice = 0.00,
    tradePrice = 0.00,
    timestamp = 1600000,
    candleAccTradePrice = 0.00,
    candleAccTradeVolume = 0.00,
    prevClosingPrice = 0.00,
    changePrice = 0.00,
    changeRate = 0.00,
    convertedTradePrice = 0.00
)

internal fun upbitWeekCandleResponseFixture() = UpbitWeekCandleResponse(
    market = "market",
    candleDateTimeUtc = "candleDateTimeUtc",
    candleDateTimeKst = "candleDateTimeKst",
    openingPrice = 0.00,
    highPrice = 0.00,
    lowPrice = 0.00,
    tradePrice = 0.00,
    timestamp = 1600000,
    candleAccTradePrice = 0.00,
    candleAccTradeVolume = 0.00,
    firstDayOfPeriod = "2021-07-21",
)

internal fun upbitMonthCandleResponseFixture() = UpbitMonthCandleResponse(
    market = "market",
    candleDateTimeUtc = "candleDateTimeUtc",
    candleDateTimeKst = "candleDateTimeKst",
    openingPrice = 0.00,
    highPrice = 0.00,
    lowPrice = 0.00,
    tradePrice = 0.00,
    timestamp = 1600000,
    candleAccTradePrice = 0.00,
    candleAccTradeVolume = 0.00,
    firstDayOfPeriod = "2021-07-21",
)
