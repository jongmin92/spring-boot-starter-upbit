package com.jongmin.upbit.client.retrofit.quatation.api.market

import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitOrderbookResponse
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.UpbitOrderbookResponseUnit
import com.jongmin.upbit.client.retrofit.quotation.api.orderbook.toDomain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitQuotationOrderbookApiProtocolTest {

    @Test
    fun `upbitOrderbookResponse to Domain`() {
        // given
        val orderbookResponse = upbitOrderbookResponseFixture()

        // when
        val result = orderbookResponse.toDomain()

        assertAll(
            "orderBookResponse",
            { assertThat(result.market).isEqualTo(orderbookResponse.market) },
            { assertThat(result.timestamp).isEqualTo(orderbookResponse.timestamp) },
            { assertThat(result.totalAskSize).isEqualTo(orderbookResponse.totalAskSize) },
            { assertThat(result.totalBidSize).isEqualTo(orderbookResponse.totalBidSize) },
            { assertThat(result.orderbookUnits.first().askPrice).isEqualTo(orderbookResponse.orderbookUnits.first().askPrice) },
            { assertThat(result.orderbookUnits.first().bidPrice).isEqualTo(orderbookResponse.orderbookUnits.first().bidPrice) },
            { assertThat(result.orderbookUnits.first().askSize).isEqualTo(orderbookResponse.orderbookUnits.first().askSize) },
            { assertThat(result.orderbookUnits.first().bidSize).isEqualTo(orderbookResponse.orderbookUnits.first().bidSize) },
        )
    }
}

internal fun upbitOrderbookResponseFixture() = UpbitOrderbookResponse(
    market = "market",
    timestamp = 1600000,
    totalAskSize = 0.00,
    totalBidSize = 0.00,
    orderbookUnits = listOf(
        UpbitOrderbookResponseUnit(
            askPrice = 0.00,
            bidPrice = 0.00,
            askSize = 0.00,
            bidSize = 0.00
        ),
        UpbitOrderbookResponseUnit(
            askPrice = 0.00,
            bidPrice = 0.00,
            askSize = 0.00,
            bidSize = 0.00
        )
    )
)
