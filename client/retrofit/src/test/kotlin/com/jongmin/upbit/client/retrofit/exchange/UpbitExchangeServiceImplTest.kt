package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitAccountResponse
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersApi
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitOrdersChanceResponse
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsApi
import com.jongmin.upbit.client.retrofit.utils.success
import com.jongmin.upbit.token.AuthorizationTokenService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UpbitExchangeServiceImplTest {
    private val accountsApi = mock<UpbitExchangeAccountsApi>()
    private val ordersApi = mock<UpbitExchangeOrdersApi>()
    private val withdrawsApi = mock<UpbitExchangeWithdrawsApi>()
    private val depositsApi = mock<UpbitExchangeDepositsApi>()
    private val infoApi = mock<UpbitExchangeInfoApi>()
    private val authorizationTokenService = mock<AuthorizationTokenService> {
        on { createToken() } doReturn "token"
        on { createToken(any()) } doReturn "token"
    }

    private val cut = UpbitExchangeServiceImpl(
        accountsApi = accountsApi,
        ordersApi = ordersApi,
        withdrawsApi = withdrawsApi,
        depositsApi = depositsApi,
        infoApi = infoApi,
        authorizationTokenService = authorizationTokenService
    )

    @Test
    fun getAccounts() {
        // given
        val account = UpbitAccountResponse(
            currency = "currency",
            balance = "balance",
            locked = "locked",
            avgBuyPrice = "avgBuyPrice",
            avgBuyPriceModified = true,
            unitCurrency = "unitCurrency"
        )
        doReturn(success(listOf(account))).whenever(accountsApi).getAccounts()

        // when
        val result = cut.getAccounts()

        // then
        assertAll("account",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first().currency).isEqualTo(account.currency) },
            { assertThat(result.first().balance).isEqualTo(account.balance) },
            { assertThat(result.first().locked).isEqualTo(account.locked) },
            { assertThat(result.first().avgBuyPrice).isEqualTo(account.avgBuyPrice) },
            { assertThat(result.first().avgBuyPriceModified).isEqualTo(account.avgBuyPriceModified) },
            { assertThat(result.first().unitCurrency).isEqualTo(account.unitCurrency) }
        )
    }

    @Test
    fun getOrdersChance() {
        // given
        val market = "market"
        val ordersChance = UpbitOrdersChanceResponse(
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
        doReturn(success(ordersChance)).whenever(ordersApi).getOrdersChance(market)

        // when
        val result = cut.getOrdersChance(market)

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
}
