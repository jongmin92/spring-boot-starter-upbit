package com.jongmin.upbit.client.retrofit.quotation.api.market

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitQuotationMarketApiProtocolTest {
    @Test
    fun `upbitMarketResponse to Domain`() {
        // given
        val marketResponse = upbitMarketResponseFixture()

        // when
        val result = marketResponse.toDomain()

        assertAll(
            "marketResponse",
            { Assertions.assertThat(result.market).isEqualTo(marketResponse.market) },
            { Assertions.assertThat(result.koreanName).isEqualTo(marketResponse.koreanName) },
            { Assertions.assertThat(result.englishName).isEqualTo(marketResponse.englishName) },
            { Assertions.assertThat(result.marketWarning!!.name).isEqualTo(marketResponse.marketWarning!!.name) },
        )
    }
}

internal fun upbitMarketResponseFixture() = UpbitMarketResponse(
    market = "market",
    koreanName = "마켓",
    englishName = "market",
    marketWarning = MarketWarningProtocol.CAUTION
)
