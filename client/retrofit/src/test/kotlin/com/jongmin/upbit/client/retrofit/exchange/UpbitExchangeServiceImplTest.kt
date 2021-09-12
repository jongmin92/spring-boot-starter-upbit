package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsApi
import com.jongmin.upbit.client.retrofit.exchange.api.account.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.account.upbitAccountResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitCreateDepositCoinAddressRequest
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitDepositKrwRequest
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitCreateDepositCoinAddressResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositCoinAddressResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositKrwResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.info.upbitApiKeyResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.info.upbitWalletStatusResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitOrderPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.order.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderDeleteResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderIncludingTradesResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrdersChanceResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostRequest
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawCoinPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawKrwPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawsChanceResponseFixture
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
        val accountResponse = upbitAccountResponseFixture()
        doReturn(success(listOf(accountResponse))).whenever(accountsApi).getAccounts()

        // when
        val result = cut.getAccounts()

        // then
        assertAll("account",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(accountResponse.toDomain()) }
        )
    }

    @Test
    fun getOrdersChance() {
        // given
        val market = "market"
        val ordersChanceResponse = upbitOrdersChanceResponseFixture()
        doReturn(success(ordersChanceResponse)).whenever(ordersApi).getOrdersChance(market)

        // when
        val result = cut.getOrdersChance(market)

        // then
        assertThat(result).isEqualTo(ordersChanceResponse.toDomain())
    }

    @Test
    fun getOrder() {
        // given
        val uuid = "uuid"
        val identifier = "identifier"
        val orderResponse = upbitOrderIncludingTradesResponseFixture()
        doReturn(success(orderResponse)).whenever(ordersApi).getOrder(uuid, identifier)

        // when
        val result = cut.getOrder(uuid, identifier)

        // then
        assertThat(result).isEqualTo(orderResponse.toDomain())
    }

    @Test
    fun getOrders() {
        // given
        val market = "market"
        val state = "state"
        val states = listOf("state")
        val uuids = listOf("uuid")
        val identifiers = listOf("identifier")
        val page = 0
        val limit = 0
        val orderBy = "orderBy"
        val orderResponse = upbitOrderResponseFixture()
        doReturn(success(listOf(orderResponse))).whenever(ordersApi).getOrders(
            market = market,
            state = state,
            states = states,
            uuids = uuids,
            identifiers = identifiers,
            page = page,
            limit = limit,
            orderBy = orderBy
        )

        // when
        val result = cut.getOrders(
            market = market,
            state = state,
            states = states,
            uuids = uuids,
            identifiers = identifiers,
            page = page,
            limit = limit,
            orderBy = orderBy
        )

        // then
        assertAll("orders",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(orderResponse.toDomain()) }
        )
    }

    @Test
    fun deleteOrder() {
        // given
        val uuid = "uuid"
        val identifier = "identifier"
        val orderDeleteResponse = upbitOrderDeleteResponseFixture()
        doReturn(success(orderDeleteResponse)).whenever(ordersApi).deleteOrder(uuid, identifier)

        // when
        val result = cut.deleteOrder(uuid, identifier)

        // then
        assertThat(result).isEqualTo(orderDeleteResponse.toDomain())
    }

    @Test
    fun postOrder() {
        // given
        val market = "market"
        val side = " side"
        val volume = "volume"
        val price = "price"
        val ordType = "ordType"
        val identifier = "identifier"
        val orderPostResponse = upbitOrderPostResponseFixture()
        doReturn(success(orderPostResponse)).whenever(ordersApi).postOrders(
            UpbitOrderPostRequest(
                market = market,
                side = side,
                volume = volume,
                price = price,
                ordType = ordType,
                identifier = identifier
            )
        )

        // when
        val result = cut.postOrder(
            market = market,
            side = side,
            volume = volume,
            price = price,
            ordType = ordType,
            identifier = identifier
        )

        // then
        assertThat(result).isEqualTo(orderPostResponse.toDomain())
    }

    @Test
    fun getWithdraws() {
        // given
        val currency = "currency"
        val state = "state"
        val uuids = listOf("uuid")
        val txids = listOf("txid")
        val limit = 0
        val page = 0
        val orderBy = "orderBy"
        val withdrawResponse = upbitWithdrawResponseFixture()
        doReturn(success(listOf(withdrawResponse))).whenever(withdrawsApi).getWithdraws(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        )

        // when
        val result = cut.getWithdraws(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        )

        // then
        assertAll("withdraw",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(withdrawResponse.toDomain()) }
        )
    }

    @Test
    fun getWithdraw() {
        // given
        val uuid = "uuid"
        val txid = "txid"
        val currency = "currency"
        val withdrawResponse = upbitWithdrawResponseFixture()
        doReturn(success(withdrawResponse)).whenever(withdrawsApi).getWithdraw(uuid, txid, currency)

        // when
        val result = cut.getWithdraw(uuid, txid, currency)

        // then
        assertThat(result).isEqualTo(withdrawResponse.toDomain())
    }

    @Test
    fun getWithdrawsChance() {
        // given
        val currency = "currency"
        val withdrawsChanceResponse = upbitWithdrawsChanceResponseFixture()
        doReturn(success(withdrawsChanceResponse)).whenever(withdrawsApi).getWithdrawsChance(currency)

        // when
        val result = cut.getWithdrawsChance(currency)

        // then
        assertThat(result).isEqualTo(withdrawsChanceResponse.toDomain())
    }

    @Test
    fun postWithdrawCoin() {
        // given
        val currency = "currency"
        val amount = "amount"
        val address = "address"
        val secondaryAddress = "secondaryAddress"
        val transactionType = "transactionType"
        val withdrawCoinPostResponse = upbitWithdrawCoinPostResponseFixture()
        doReturn(success(withdrawCoinPostResponse)).whenever(withdrawsApi).postWithdrawsCoin(
            UpbitWithdrawCoinPostRequest(
                currency = currency,
                amount = amount,
                address = address,
                secondaryAddress = secondaryAddress,
                transactionType = transactionType
            )
        )

        // when
        val result = cut.postWithdrawCoin(
            currency = currency,
            amount = amount,
            address = address,
            secondaryAddress = secondaryAddress,
            transactionType = transactionType
        )

        // then
        assertThat(result).isEqualTo(withdrawCoinPostResponse.toDomain())
    }

    @Test
    fun postWithdrawKrw() {
        // given
        val amount = "amount"
        val withdrawKrwPostResponse = upbitWithdrawKrwPostResponseFixture()
        doReturn(success(withdrawKrwPostResponse)).whenever(withdrawsApi).postWithdrawsKrw(
            UpbitWithdrawKrwPostRequest(amount)
        )

        // when
        val result = cut.postWithdrawKrw(amount)

        // then
        assertThat(result).isEqualTo(withdrawKrwPostResponse.toDomain())
    }

    @Test
    fun getDeposits() {
        // given
        val currency = "currency"
        val state = "state"
        val uuids = listOf("uuid")
        val txids = listOf("txid")
        val limit = 0
        val page = 0
        val orderBy = "orderBy"
        val depositResponse = upbitDepositResponseFixture()
        doReturn(success(listOf(depositResponse))).whenever(depositsApi).getDeposits(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        )

        // when
        val result = cut.getDeposits(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        )

        // then
        assertAll("deposit",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(depositResponse.toDomain()) }
        )
    }

    @Test
    fun getDeposit() {
        // given
        val uuid = "uuid"
        val txid = "txid"
        val currency = "currency"
        val depositResponse = upbitDepositResponseFixture()
        doReturn(success(depositResponse)).whenever(depositsApi).getDeposit(uuid, txid, currency)

        // when
        val result = cut.getDeposit(uuid, txid, currency)

        // then
        assertThat(result).isEqualTo(depositResponse.toDomain())
    }

    @Test
    fun createDepositCoinAddress() {
        // given
        val currency = "currency"
        val depositCoinAddressResponse = upbitCreateDepositCoinAddressResponseFixture()
        doReturn(success(depositCoinAddressResponse)).whenever(depositsApi).createDepositCoinAddress(
            UpbitCreateDepositCoinAddressRequest(currency)
        )

        // when
        val result = cut.createDepositCoinAddress(currency)

        // then
        assertThat(result).isEqualTo(depositCoinAddressResponse.toDomain())
    }

    @Test
    fun getDepositsCoinAddresses() {
        // given
        val depositCoinAddressResponse = upbitDepositCoinAddressResponseFixture()
        doReturn(success(listOf(depositCoinAddressResponse))).whenever(depositsApi).getDepositCoinAddresses()

        // when
        val result = cut.getDepositsCoinAddresses()

        // then
        assertAll("depositCoinAddress",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(depositCoinAddressResponse.toDomain()) }
        )
    }

    @Test
    fun getDepositsCoinAddress() {
        // given
        val currency = "currency"
        val depositCoinAddressResponse = upbitDepositCoinAddressResponseFixture()
        doReturn(success(depositCoinAddressResponse)).whenever(depositsApi).getDepositsCoinAddress(currency)

        // when
        val result = cut.getDepositsCoinAddress(currency)

        // then
        assertThat(result).isEqualTo(depositCoinAddressResponse.toDomain())
    }

    @Test
    fun postDepositKrw() {
        // given
        val amount = "amount"
        val depositKrwResponse = upbitDepositKrwResponseFixture()
        doReturn(success(depositKrwResponse)).whenever(depositsApi)
            .postDepositsKrw(UpbitDepositKrwRequest(amount))

        // when
        val result = cut.postDepositKrw(amount)

        // then
        assertThat(result).isEqualTo(depositKrwResponse.toDomain())
    }

    @Test
    fun getWalletStatus() {
        // given
        val walletStatusResponse = upbitWalletStatusResponseFixture()
        doReturn(success(listOf(walletStatusResponse))).whenever(infoApi).getWalletStatus()

        // when
        val result = cut.getWalletStatus()

        // then
        assertAll("walletStatus",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(walletStatusResponse.toDomain()) }
        )
    }
    
    @Test
    fun getApiKeys() {
        // given
        val apiKeyResponse = upbitApiKeyResponseFixture()
        doReturn(success(listOf(apiKeyResponse))).whenever(infoApi).getApiKeys()
        
        // when
        val result = cut.getApiKeys()
        
        // then
        assertAll("apiKey",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(apiKeyResponse.toDomain()) }
        )
    }
}
