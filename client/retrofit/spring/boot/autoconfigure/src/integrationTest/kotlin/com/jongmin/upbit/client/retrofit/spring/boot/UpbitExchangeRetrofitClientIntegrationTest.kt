package com.jongmin.upbit.client.retrofit.spring.boot

import com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure.UpbitRetrofitClientAutoConfigure
import com.jongmin.upbit.exchange.UpbitExchangeService
import com.jongmin.upbit.server.mock.exchange.account.GetAccountsResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrderResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrdersChanceResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [UpbitRetrofitClientAutoConfigure::class])
class UpbitExchangeRetrofitClientIntegrationTest : UpbitLocalMockServer() {

    @Autowired
    lateinit var upbitExchangeService: UpbitExchangeService

    @Test
    fun getAccounts() {
        // given
        /**
         * @see GetAccountsResponse.fixture
         */

        // when
        val result = upbitExchangeService.getAccounts()

        // then
        assertAll("UpbitAccount[0]",
            { assertThat(result[0].currency).isEqualTo(GetAccountsResponse.currency1) },
            { assertThat(result[0].balance).isEqualTo(GetAccountsResponse.balance1) },
            { assertThat(result[0].locked).isEqualTo(GetAccountsResponse.locked1) },
            { assertThat(result[0].avgBuyPrice).isEqualTo(GetAccountsResponse.avgBuyPrice1) },
            { assertThat(result[0].avgBuyPriceModified).isEqualTo(GetAccountsResponse.avgBuyPriceModified1) },
            { assertThat(result[0].unitCurrency).isEqualTo(GetAccountsResponse.unitCurrency1) }
        )
        assertAll("UpbitAccount[1]",
            { assertThat(result[1].currency).isEqualTo(GetAccountsResponse.currency2) },
            { assertThat(result[1].balance).isEqualTo(GetAccountsResponse.balance2) },
            { assertThat(result[1].locked).isEqualTo(GetAccountsResponse.locked2) },
            { assertThat(result[1].avgBuyPrice).isEqualTo(GetAccountsResponse.avgBuyPrice2) },
            { assertThat(result[1].avgBuyPriceModified).isEqualTo(GetAccountsResponse.avgBuyPriceModified2) },
            { assertThat(result[1].unitCurrency).isEqualTo(GetAccountsResponse.unitCurrency2) }
        )
    }

    @Test
    fun getOrdersChance() {
        // given
        /**
         * @see GetOrdersChanceResponse.fixture
         */

        // when
        val result = upbitExchangeService.getOrdersChance("market")

        // then
        assertAll(
            "UpbitOrdersChance",
            { assertThat(result.bidFee).isEqualTo(GetOrdersChanceResponse.bidFee) },
            { assertThat(result.askFee).isEqualTo(GetOrdersChanceResponse.askFee) },
            { assertThat(result.market.id).isEqualTo(GetOrdersChanceResponse.marketId) },
            { assertThat(result.market.name).isEqualTo(GetOrdersChanceResponse.marketName) },
            { assertThat(result.market.orderTypes[0]).isEqualTo(GetOrdersChanceResponse.marketOrderType1) },
            { assertThat(result.market.orderSides[0]).isEqualTo(GetOrdersChanceResponse.marketOrderSide1) },
            { assertThat(result.market.orderSides[1]).isEqualTo(GetOrdersChanceResponse.marketOrderSide2) },
            { assertThat(result.market.bid.currency).isEqualTo(GetOrdersChanceResponse.marketBidCurrency) },
            { assertThat(result.market.bid.priceUnit).isEqualTo(GetOrdersChanceResponse.marketBidPriceUnit) },
            { assertThat(result.market.bid.minTotal).isEqualTo(GetOrdersChanceResponse.marketBidMinTotal) },
            { assertThat(result.market.ask.currency).isEqualTo(GetOrdersChanceResponse.marketAskCurrency) },
            { assertThat(result.market.ask.priceUnit).isEqualTo(GetOrdersChanceResponse.marketAskPriceUnit) },
            { assertThat(result.market.ask.minTotal).isEqualTo(GetOrdersChanceResponse.marketAskMinTotal) },
            { assertThat(result.market.maxTotal).isEqualTo(GetOrdersChanceResponse.maxTotal) },
            { assertThat(result.market.state).isEqualTo(GetOrdersChanceResponse.state) },
            { assertThat(result.bidAccount.currency).isEqualTo(GetOrdersChanceResponse.bidAccountCurrency) },
            { assertThat(result.bidAccount.balance).isEqualTo(GetOrdersChanceResponse.bidAccountBalance) },
            { assertThat(result.bidAccount.locked).isEqualTo(GetOrdersChanceResponse.bidAccountLocked) },
            { assertThat(result.bidAccount.avgBuyPrice).isEqualTo(GetOrdersChanceResponse.bidAccountAvgBuyPrice) },
            { assertThat(result.bidAccount.avgBuyPriceModified).isEqualTo(GetOrdersChanceResponse.bidAccountAvgBuyPriceModified) },
            { assertThat(result.bidAccount.unitCurrency).isEqualTo(GetOrdersChanceResponse.bidAccountUnitCurrency) },
            { assertThat(result.askAccount.currency).isEqualTo(GetOrdersChanceResponse.askAccountCurrency) },
            { assertThat(result.askAccount.balance).isEqualTo(GetOrdersChanceResponse.askAccountBalance) },
            { assertThat(result.askAccount.locked).isEqualTo(GetOrdersChanceResponse.askAccountLocked) },
            { assertThat(result.askAccount.avgBuyPrice).isEqualTo(GetOrdersChanceResponse.askAccountAvgBuyPrice) },
            { assertThat(result.askAccount.avgBuyPriceModified).isEqualTo(GetOrdersChanceResponse.askAccountAvgBuyPriceModified) },
            { assertThat(result.askAccount.unitCurrency).isEqualTo(GetOrdersChanceResponse.askAccountUnitCurrency) },
        )
    }

    @Test
    fun getOrder() {
        // given
        /**
         * @see GetOrderResponse.fixture
         */

        // when
        val result = upbitExchangeService.getOrder("uuid")

        // then
        assertAll("UpbitOrderIncludingTrades",
            { assertThat(result.uuid).isEqualTo(GetOrderResponse.uuid) },
            { assertThat(result.side).isEqualTo(GetOrderResponse.side) },
            { assertThat(result.ordType).isEqualTo(GetOrderResponse.ordType) },
            { assertThat(result.price).isEqualTo(GetOrderResponse.price) },
            { assertThat(result.state).isEqualTo(GetOrderResponse.state) },
            { assertThat(result.market).isEqualTo(GetOrderResponse.market) },
            { assertThat(result.createdAt).isEqualTo(GetOrderResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(GetOrderResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(GetOrderResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(GetOrderResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(GetOrderResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(GetOrderResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(GetOrderResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(GetOrderResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(GetOrderResponse.tradesCount) },
            { assertThat(result.trades[0].market).isEqualTo(GetOrderResponse.tradeMarket) },
            { assertThat(result.trades[0].uuid).isEqualTo(GetOrderResponse.tradeUuid) },
            { assertThat(result.trades[0].price).isEqualTo(GetOrderResponse.tradePrice) },
            { assertThat(result.trades[0].volume).isEqualTo(GetOrderResponse.tradeVolume) },
            { assertThat(result.trades[0].funds).isEqualTo(GetOrderResponse.tradeFunds) },
            { assertThat(result.trades[0].side).isEqualTo(GetOrderResponse.tradeSide) }
        )
    }

    @AfterEach
    fun checkAuthorizationTokenExistInRequest() {
        assertThat(upbitMockServer.getAuthorizationToken()).isNotNull
    }
}
