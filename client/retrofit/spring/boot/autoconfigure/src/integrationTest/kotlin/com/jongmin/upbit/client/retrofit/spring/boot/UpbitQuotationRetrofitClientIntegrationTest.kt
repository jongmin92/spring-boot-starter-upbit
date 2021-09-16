package com.jongmin.upbit.client.retrofit.spring.boot

import com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure.UpbitRetrofitClientAutoConfigure
import com.jongmin.upbit.quotation.UpbitQuotationService
import com.jongmin.upbit.server.mock.quotation.market.GetMarketResponse
import com.jongmin.upbit.server.mock.quotation.orderbook.GetOrderbookResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [UpbitRetrofitClientAutoConfigure::class])
class UpbitQuotationRetrofitClientIntegrationTest : UpbitLocalMockServer() {

    @Autowired
    lateinit var upbitQuotationService: UpbitQuotationService

    @Test
    fun getMarkets() {
        // given
        /**
         * @see GetMarketResponse.fixture
         */

        // when
        val result = upbitQuotationService.getUpbitMarkets()

        // then
        assertAll("UpbitMarket[0]",
            { assertThat(result[0].market).isEqualTo(GetMarketResponse.market) },
            { assertThat(result[0].koreanName).isEqualTo(GetMarketResponse.koreanName) },
            { assertThat(result[0].englishName).isEqualTo(GetMarketResponse.englishName) },
            { assertThat(result[0].marketWarning!!.name).isEqualTo(GetMarketResponse.marketWarning) }
        )
        assertAll("UpbitMarket[1]",
            { assertThat(result[1].market).isEqualTo(GetMarketResponse.market2) },
            { assertThat(result[1].koreanName).isEqualTo(GetMarketResponse.koreanName2) },
            { assertThat(result[1].englishName).isEqualTo(GetMarketResponse.englishName2) },
            { assertThat(result[1].marketWarning!!.name).isEqualTo(GetMarketResponse.marketWarning2) }
        )
    }

    @Test
    fun getOrderbooks() {
        // given
        val markets = "BTC-KRW"
        /**
         * @see GetOrderbookResponse.fixture
         */

        // when
        val result = upbitQuotationService.getUpbitOrderbooks(markets)

        // then
        assertAll("UpbitOrderbook[0]",
            { assertThat(result[0].market).isEqualTo(GetOrderbookResponse.market) },
            { assertThat(result[0].totalAskSize).isEqualTo(GetOrderbookResponse.totalAskSize) },
            { assertThat(result[0].totalBidSize).isEqualTo(GetOrderbookResponse.totalBidSize) },
            { assertThat(result[0].timestamp).isEqualTo(GetOrderbookResponse.timestamp) }
        )
    }
}
