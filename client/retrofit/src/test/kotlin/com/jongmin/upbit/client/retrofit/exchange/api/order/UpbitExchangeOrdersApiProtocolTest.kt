package com.jongmin.upbit.client.retrofit.exchange.api.order

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrderIncludingTradesResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrdersChanceResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitExchangeOrdersApiProtocolTest {

    @Test
    fun `upbitOrdersChanceResponse toDomain`() {
        // given
        val ordersChance = upbitOrdersChanceResponseFixture()

        // when
        val result = ordersChance.toDomain()

        // then
        assertAll("ordersChance",
            { assertThat(result.bidFee).isEqualTo(ordersChance.bidFee) },
            { assertThat(result.askFee).isEqualTo(ordersChance.askFee) },
            { assertThat(result.market).isNotNull },
            { assertThat(result.market.id).isEqualTo(ordersChance.market.id) },
            { assertThat(result.market.name).isEqualTo(ordersChance.market.name) },
            { assertThat(result.market.orderTypes).hasSize(1) },
            { assertThat(result.market.orderTypes.first()).isEqualTo(ordersChance.market.orderTypes.first()) },
            { assertThat(result.market.orderSides).hasSize(1) },
            { assertThat(result.market.orderSides.first()).isEqualTo(ordersChance.market.orderSides.first()) },
            { assertThat(result.market.bid).isNotNull },
            { assertThat(result.market.bid.currency).isEqualTo(ordersChance.market.bid.currency) },
            { assertThat(result.market.bid.priceUnit).isEqualTo(ordersChance.market.bid.priceUnit) },
            { assertThat(result.market.bid.minTotal).isEqualTo(ordersChance.market.bid.minTotal) },
            { assertThat(result.market.ask).isNotNull },
            { assertThat(result.market.ask.currency).isEqualTo(ordersChance.market.ask.currency) },
            { assertThat(result.market.ask.priceUnit).isEqualTo(ordersChance.market.ask.priceUnit) },
            { assertThat(result.market.ask.minTotal).isEqualTo(ordersChance.market.ask.minTotal) },
            { assertThat(result.market.maxTotal).isEqualTo(ordersChance.market.maxTotal) },
            { assertThat(result.market.state).isEqualTo(ordersChance.market.state) },
            { assertThat(result.bidAccount).isNotNull },
            { assertThat(result.bidAccount.currency).isEqualTo(ordersChance.bidAccount.currency) },
            { assertThat(result.bidAccount.balance).isEqualTo(ordersChance.bidAccount.balance) },
            { assertThat(result.bidAccount.locked).isEqualTo(ordersChance.bidAccount.locked) },
            { assertThat(result.bidAccount.avgBuyPrice).isEqualTo(ordersChance.bidAccount.avgBuyPrice) },
            { assertThat(result.bidAccount.avgBuyPriceModified).isEqualTo(ordersChance.bidAccount.avgBuyPriceModified) },
            { assertThat(result.bidAccount.unitCurrency).isEqualTo(ordersChance.bidAccount.unitCurrency) },
            { assertThat(result.askAccount).isNotNull },
            { assertThat(result.askAccount.currency).isEqualTo(ordersChance.askAccount.currency) },
            { assertThat(result.askAccount.balance).isEqualTo(ordersChance.askAccount.balance) },
            { assertThat(result.askAccount.locked).isEqualTo(ordersChance.askAccount.locked) },
            { assertThat(result.askAccount.avgBuyPrice).isEqualTo(ordersChance.askAccount.avgBuyPrice) },
            { assertThat(result.askAccount.avgBuyPriceModified).isEqualTo(ordersChance.askAccount.avgBuyPriceModified) },
            { assertThat(result.askAccount.unitCurrency).isEqualTo(ordersChance.askAccount.unitCurrency) }
        )
    }

    @Test
    fun `upbitOrderIncludingTradesResponse toDomain`() {
        // given
        val order = upbitOrderIncludingTradesResponseFixture()

        // when
        val result = order.toDomain()

        // then
        assertAll("order",
            { assertThat(result.uuid).isEqualTo(order.uuid) },
            { assertThat(result.side).isEqualTo(order.side) },
            { assertThat(result.ordType).isEqualTo(order.ordType) },
            { assertThat(result.price).isEqualTo(order.price) },
            { assertThat(result.state).isEqualTo(order.state) },
            { assertThat(result.createdAt).isEqualTo(order.createdAt) },
            { assertThat(result.volume).isEqualTo(order.volume) },
            { assertThat(result.remainingVolume).isEqualTo(order.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(order.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(order.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(order.paidFee) },
            { assertThat(result.locked).isEqualTo(order.locked) },
            { assertThat(result.executedVolume).isEqualTo(order.executedVolume) },
            { assertThat(result.tradeCount).isEqualTo(order.tradeCount) },
            { assertThat(result.trades).hasSize(1) },
            { assertThat(result.trades.first().market).isEqualTo(order.trades.first().market) },
            { assertThat(result.trades.first().uuid).isEqualTo(order.trades.first().uuid) },
            { assertThat(result.trades.first().price).isEqualTo(order.trades.first().price) },
            { assertThat(result.trades.first().volume).isEqualTo(order.trades.first().volume) },
            { assertThat(result.trades.first().funds).isEqualTo(order.trades.first().funds) },
            { assertThat(result.trades.first().side).isEqualTo(order.trades.first().side) },
            { assertThat(result.trades.first().createdAt).isEqualTo(order.trades.first().createdAt) }
        )
    }
}

internal fun upbitOrdersChanceResponseFixture() = UpbitOrdersChanceResponse(
    bidFee = "bidFee",
    askFee = "askFee",
    market = UpbitOrdersChanceResponse.MarketResponse(
        id = "id",
        name = "name",
        orderTypes = listOf("orderType"),
        orderSides = listOf("orderSide"),
        bid = UpbitOrdersChanceResponse.MarketResponse.Bid("currency", "priceUnit", 0),
        ask = UpbitOrdersChanceResponse.MarketResponse.Ask("currency", "priceUnit", 0),
        maxTotal = "maxTotal",
        state = "state"
    ),
    bidAccount = UpbitOrdersChanceResponse.BidAccountResponse(
        currency = "currency",
        balance = "balance",
        locked = "locked",
        avgBuyPrice = "avgBuyPrice",
        avgBuyPriceModified = true,
        unitCurrency = "unitCurrency"
    ),
    askAccount = UpbitOrdersChanceResponse.AskAccountResponse(
        currency = "currency",
        balance = "balance",
        locked = "locked",
        avgBuyPrice = "avgBuyPrice",
        avgBuyPriceModified = true,
        unitCurrency = "unitCurrency"
    )
)

internal fun upbitOrderIncludingTradesResponseFixture() = UpbitOrderIncludingTradesResponse(
    uuid = "uuid",
    side = "side",
    ordType = "ordType",
    price = "price",
    state = "state",
    market = "market",
    createdAt = "createdAt",
    volume = "volume",
    remainingVolume = "remainingVolume",
    reservedFee = "reservedFee",
    remainingFee = "remainingFee",
    paidFee = "paidFee",
    locked = "locked",
    executedVolume = "executedVolume",
    tradeCount = 0,
    trades = listOf(
        UpbitOrderIncludingTradesResponse.TradeResponse(
            market = "market",
            uuid = "uuid",
            price = "price",
            volume = "volume",
            funds = "funds",
            side = "side",
            createdAt = "createdAt"
        )
    )
)
