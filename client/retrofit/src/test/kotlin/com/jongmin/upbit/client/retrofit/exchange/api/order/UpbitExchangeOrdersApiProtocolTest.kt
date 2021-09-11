package com.jongmin.upbit.client.retrofit.exchange.api.order

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitExchangeOrdersApiProtocolTest {

    @Test
    fun `upbitOrdersChanceResponse toDomain`() {
        // given
        val ordersChanceResponse = upbitOrdersChanceResponseFixture()

        // when
        val result = ordersChanceResponse.toDomain()

        // then
        assertAll("ordersChance",
            { assertThat(result.bidFee).isEqualTo(ordersChanceResponse.bidFee) },
            { assertThat(result.askFee).isEqualTo(ordersChanceResponse.askFee) },
            { assertThat(result.market).isNotNull },
            { assertThat(result.market.id).isEqualTo(ordersChanceResponse.market.id) },
            { assertThat(result.market.name).isEqualTo(ordersChanceResponse.market.name) },
            { assertThat(result.market.orderTypes).hasSize(1) },
            { assertThat(result.market.orderTypes.first()).isEqualTo(ordersChanceResponse.market.orderTypes.first()) },
            { assertThat(result.market.orderSides).hasSize(1) },
            { assertThat(result.market.orderSides.first()).isEqualTo(ordersChanceResponse.market.orderSides.first()) },
            { assertThat(result.market.bid).isNotNull },
            { assertThat(result.market.bid.currency).isEqualTo(ordersChanceResponse.market.bid.currency) },
            { assertThat(result.market.bid.priceUnit).isEqualTo(ordersChanceResponse.market.bid.priceUnit) },
            { assertThat(result.market.bid.minTotal).isEqualTo(ordersChanceResponse.market.bid.minTotal) },
            { assertThat(result.market.ask).isNotNull },
            { assertThat(result.market.ask.currency).isEqualTo(ordersChanceResponse.market.ask.currency) },
            { assertThat(result.market.ask.priceUnit).isEqualTo(ordersChanceResponse.market.ask.priceUnit) },
            { assertThat(result.market.ask.minTotal).isEqualTo(ordersChanceResponse.market.ask.minTotal) },
            { assertThat(result.market.maxTotal).isEqualTo(ordersChanceResponse.market.maxTotal) },
            { assertThat(result.market.state).isEqualTo(ordersChanceResponse.market.state) },
            { assertThat(result.bidAccount).isNotNull },
            { assertThat(result.bidAccount.currency).isEqualTo(ordersChanceResponse.bidAccount.currency) },
            { assertThat(result.bidAccount.balance).isEqualTo(ordersChanceResponse.bidAccount.balance) },
            { assertThat(result.bidAccount.locked).isEqualTo(ordersChanceResponse.bidAccount.locked) },
            { assertThat(result.bidAccount.avgBuyPrice).isEqualTo(ordersChanceResponse.bidAccount.avgBuyPrice) },
            { assertThat(result.bidAccount.avgBuyPriceModified).isEqualTo(ordersChanceResponse.bidAccount.avgBuyPriceModified) },
            { assertThat(result.bidAccount.unitCurrency).isEqualTo(ordersChanceResponse.bidAccount.unitCurrency) },
            { assertThat(result.askAccount).isNotNull },
            { assertThat(result.askAccount.currency).isEqualTo(ordersChanceResponse.askAccount.currency) },
            { assertThat(result.askAccount.balance).isEqualTo(ordersChanceResponse.askAccount.balance) },
            { assertThat(result.askAccount.locked).isEqualTo(ordersChanceResponse.askAccount.locked) },
            { assertThat(result.askAccount.avgBuyPrice).isEqualTo(ordersChanceResponse.askAccount.avgBuyPrice) },
            { assertThat(result.askAccount.avgBuyPriceModified).isEqualTo(ordersChanceResponse.askAccount.avgBuyPriceModified) },
            { assertThat(result.askAccount.unitCurrency).isEqualTo(ordersChanceResponse.askAccount.unitCurrency) }
        )
    }

    @Test
    fun `upbitOrderIncludingTradesResponse toDomain`() {
        // given
        val orderResponse = upbitOrderIncludingTradesResponseFixture()

        // when
        val result = orderResponse.toDomain()

        // then
        assertAll("order",
            { assertThat(result.uuid).isEqualTo(orderResponse.uuid) },
            { assertThat(result.side).isEqualTo(orderResponse.side) },
            { assertThat(result.ordType).isEqualTo(orderResponse.ordType) },
            { assertThat(result.price).isEqualTo(orderResponse.price) },
            { assertThat(result.state).isEqualTo(orderResponse.state) },
            { assertThat(result.createdAt).isEqualTo(orderResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(orderResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(orderResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(orderResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(orderResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(orderResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(orderResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(orderResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(orderResponse.tradesCount) },
            { assertThat(result.trades).hasSize(1) },
            { assertThat(result.trades.first().market).isEqualTo(orderResponse.trades.first().market) },
            { assertThat(result.trades.first().uuid).isEqualTo(orderResponse.trades.first().uuid) },
            { assertThat(result.trades.first().price).isEqualTo(orderResponse.trades.first().price) },
            { assertThat(result.trades.first().volume).isEqualTo(orderResponse.trades.first().volume) },
            { assertThat(result.trades.first().funds).isEqualTo(orderResponse.trades.first().funds) },
            { assertThat(result.trades.first().side).isEqualTo(orderResponse.trades.first().side) }
        )
    }

    @Test
    fun `upbitOrderResponse toDomain`() {
        // given
        val orderResponse = upbitOrderResponseFixture()

        // when
        val result = orderResponse.toDomain()

        // then
        assertAll("order",
            { assertThat(result.uuid).isEqualTo(orderResponse.uuid) },
            { assertThat(result.side).isEqualTo(orderResponse.side) },
            { assertThat(result.ordType).isEqualTo(orderResponse.ordType) },
            { assertThat(result.price).isEqualTo(orderResponse.price) },
            { assertThat(result.state).isEqualTo(orderResponse.state) },
            { assertThat(result.createdAt).isEqualTo(orderResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(orderResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(orderResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(orderResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(orderResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(orderResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(orderResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(orderResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(orderResponse.tradesCount) }
        )
    }

    @Test
    fun `upbitOrderDeleteResponse toDomain`() {
        // given
        val orderDeleteResponse = upbitOrderDeleteResponseFixture()

        // when
        val result = orderDeleteResponse.toDomain()

        // then
        assertAll("orderDelete",
            { assertThat(result.uuid).isEqualTo(orderDeleteResponse.uuid) },
            { assertThat(result.side).isEqualTo(orderDeleteResponse.side) },
            { assertThat(result.ordType).isEqualTo(orderDeleteResponse.ordType) },
            { assertThat(result.price).isEqualTo(orderDeleteResponse.price) },
            { assertThat(result.state).isEqualTo(orderDeleteResponse.state) },
            { assertThat(result.createdAt).isEqualTo(orderDeleteResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(orderDeleteResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(orderDeleteResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(orderDeleteResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(orderDeleteResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(orderDeleteResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(orderDeleteResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(orderDeleteResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(orderDeleteResponse.tradesCount) }
        )
    }

    @Test
    fun `upbitOrderPostResponse toDomain`() {
        // given
        val orderPostResponse = upbitOrderPostResponseFixture()

        // when
        val result = orderPostResponse.toDomain()

        // then
        assertAll("orderPost",
            { assertThat(result.uuid).isEqualTo(orderPostResponse.uuid) },
            { assertThat(result.side).isEqualTo(orderPostResponse.side) },
            { assertThat(result.ordType).isEqualTo(orderPostResponse.ordType) },
            { assertThat(result.price).isEqualTo(orderPostResponse.price) },
            { assertThat(result.state).isEqualTo(orderPostResponse.state) },
            { assertThat(result.createdAt).isEqualTo(orderPostResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(orderPostResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(orderPostResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(orderPostResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(orderPostResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(orderPostResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(orderPostResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(orderPostResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(orderPostResponse.tradesCount) },
            { assertThat(result.avgPrice).isEqualTo(orderPostResponse.avgPrice) }
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
    tradesCount = 0,
    trades = listOf(
        UpbitOrderIncludingTradesResponse.TradeResponse(
            market = "market",
            uuid = "uuid",
            price = "price",
            volume = "volume",
            funds = "funds",
            side = "side"
        )
    )
)

internal fun upbitOrderResponseFixture() = UpbitOrderResponse(
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
    tradesCount = 0
)

internal fun upbitOrderDeleteResponseFixture() = UpbitOrderDeleteResponse(
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
    tradesCount = 0
)

internal fun upbitOrderPostResponseFixture() = UpbitOrderPostResponse(
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
    tradesCount = 0,
    avgPrice = "avgPrice"
)
