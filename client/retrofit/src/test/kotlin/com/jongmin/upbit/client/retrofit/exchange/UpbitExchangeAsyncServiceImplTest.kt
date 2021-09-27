package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.account.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.account.upbitAccountResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitCreateDepositCoinAddressRequest
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitDepositKrwRequest
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitCreateDepositCoinAddressResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositCoinAddressResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositKrwResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.info.upbitApiKeyResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.info.upbitWalletStatusResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersAsyncApi
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
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawCoinPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawKrwPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawsChanceResponseFixture
import com.jongmin.upbit.client.retrofit.utils.success
import com.jongmin.upbit.token.AuthorizationTokenService
import com.jongmin.upbit.client.retrofit.joining
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UpbitExchangeAsyncServiceImplTest {
    private val accountsAsyncApi = mock<UpbitExchangeAccountsAsyncApi>()
    private val ordersAsyncApi = mock<UpbitExchangeOrdersAsyncApi>()
    private val withdrawsAsyncApi = mock<UpbitExchangeWithdrawsAsyncApi>()
    private val depositsAsyncApi = mock<UpbitExchangeDepositsAsyncApi>()
    private val infoAsyncApi = mock<UpbitExchangeInfoAsyncApi>()
    private val authorizationTokenService = mock<AuthorizationTokenService> {
        on { createToken() } doReturn "token"
        on { createToken(any()) } doReturn "token"
    }

    private val cut = UpbitExchangeAsyncServiceImpl(
        accountsAsyncApi = accountsAsyncApi,
        ordersAsyncApi = ordersAsyncApi,
        withdrawsAsyncApi = withdrawsAsyncApi,
        depositsAsyncApi = depositsAsyncApi,
        infoAsyncApi = infoAsyncApi,
        authorizationTokenService = authorizationTokenService
    )

    @Test
    fun getAccounts() {
        // given
        val accountResponse = upbitAccountResponseFixture()
        whenever(accountsAsyncApi.getAccounts()).thenReturn(success(listOf(accountResponse)))

        // when
        val result = cut.getAccounts().joining()

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
        whenever(ordersAsyncApi.getOrdersChance(market)).thenReturn(success(ordersChanceResponse))

        // when
        val result = cut.getOrdersChance(market).joining()

        // then
        assertThat(result).isEqualTo(ordersChanceResponse.toDomain())
    }

    @Test
    fun getOrder() {
        // given
        val uuid = "uuid"
        val identifier = "identifier"
        val orderResponse = upbitOrderIncludingTradesResponseFixture()
        whenever(ordersAsyncApi.getOrder(uuid, identifier)).thenReturn(success(orderResponse))

        // when
        val result = cut.getOrder(uuid, identifier).joining()

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
        whenever(
            ordersAsyncApi.getOrders(
                market = market,
                state = state,
                states = states,
                uuids = uuids,
                identifiers = identifiers,
                page = page,
                limit = limit,
                orderBy = orderBy
            )
        ).thenReturn(success(listOf(orderResponse)))

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
        ).joining()

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
        whenever(ordersAsyncApi.deleteOrder(uuid, identifier)).thenReturn(success(orderDeleteResponse))

        // when
        val result = cut.deleteOrder(uuid, identifier).joining()

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
        whenever(
            ordersAsyncApi.postOrders(
                UpbitOrderPostRequest(
                    market = market,
                    side = side,
                    volume = volume,
                    price = price,
                    ordType = ordType,
                    identifier = identifier
                )
            )
        ).thenReturn(success(orderPostResponse))

        // when
        val result = cut.postOrder(
            market = market,
            side = side,
            volume = volume,
            price = price,
            ordType = ordType,
            identifier = identifier
        ).joining()

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
        whenever(
            withdrawsAsyncApi.getWithdraws(
                currency = currency,
                state = state,
                uuids = uuids,
                txids = txids,
                limit = limit,
                page = page,
                orderBy = orderBy
            )
        ).thenReturn(success(listOf(withdrawResponse)))

        // when
        val result = cut.getWithdraws(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        ).joining()

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
        doReturn(success(withdrawResponse)).whenever(withdrawsAsyncApi).getWithdraw(uuid, txid, currency)

        // when
        val result = cut.getWithdraw(uuid, txid, currency).joining()

        // then
        assertThat(result).isEqualTo(withdrawResponse.toDomain())
    }

    @Test
    fun getWithdrawsChance() {
        // given
        val currency = "currency"
        val withdrawsChanceResponse = upbitWithdrawsChanceResponseFixture()
        whenever(withdrawsAsyncApi.getWithdrawsChance(currency)).thenReturn(success(withdrawsChanceResponse))

        // when
        val result = cut.getWithdrawsChance(currency).joining()

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
        whenever(
            withdrawsAsyncApi.postWithdrawsCoin(
                UpbitWithdrawCoinPostRequest(
                    currency = currency,
                    amount = amount,
                    address = address,
                    secondaryAddress = secondaryAddress,
                    transactionType = transactionType
                )
            )
        ).thenReturn(success(withdrawCoinPostResponse))

        // when
        val result = cut.postWithdrawCoin(
            currency = currency,
            amount = amount,
            address = address,
            secondaryAddress = secondaryAddress,
            transactionType = transactionType
        ).joining()

        // then
        assertThat(result).isEqualTo(withdrawCoinPostResponse.toDomain())
    }

    @Test
    fun postWithdrawKrw() {
        // given
        val amount = "amount"
        val withdrawKrwPostResponse = upbitWithdrawKrwPostResponseFixture()
        whenever(withdrawsAsyncApi.postWithdrawsKrw(UpbitWithdrawKrwPostRequest(amount)))
            .thenReturn(success(withdrawKrwPostResponse))

        // when
        val result = cut.postWithdrawKrw(amount).joining()

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
        whenever(
            depositsAsyncApi.getDeposits(
                currency = currency,
                state = state,
                uuids = uuids,
                txids = txids,
                limit = limit,
                page = page,
                orderBy = orderBy
            )
        ).thenReturn(success(listOf(depositResponse)))

        // when
        val result = cut.getDeposits(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        ).joining()

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
        whenever(depositsAsyncApi.getDeposit(uuid, txid, currency)).thenReturn(success(depositResponse))

        // when
        val result = cut.getDeposit(uuid, txid, currency).joining()

        // then
        assertThat(result).isEqualTo(depositResponse.toDomain())
    }

    @Test
    fun createDepositCoinAddress() {
        // given
        val currency = "currency"
        val depositCoinAddressResponse = upbitCreateDepositCoinAddressResponseFixture()
        whenever(depositsAsyncApi.createDepositCoinAddress(UpbitCreateDepositCoinAddressRequest(currency)))
            .thenReturn(success(depositCoinAddressResponse))

        // when
        val result = cut.createDepositCoinAddress(currency).joining()

        // then
        assertThat(result).isEqualTo(depositCoinAddressResponse.toDomain())
    }

    @Test
    fun getDepositsCoinAddresses() {
        // given
        val depositCoinAddressResponse = upbitDepositCoinAddressResponseFixture()
        whenever(depositsAsyncApi.getDepositCoinAddresses())
            .thenReturn(success(listOf(depositCoinAddressResponse)))

        // when
        val result = cut.getDepositsCoinAddresses().joining()

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
        whenever(depositsAsyncApi.getDepositsCoinAddress(currency))
            .thenReturn(success(depositCoinAddressResponse))

        // when
        val result = cut.getDepositsCoinAddress(currency).joining()

        // then
        assertThat(result).isEqualTo(depositCoinAddressResponse.toDomain())
    }

    @Test
    fun postDepositKrw() {
        // given
        val amount = "amount"
        val depositKrwResponse = upbitDepositKrwResponseFixture()
        whenever(depositsAsyncApi.postDepositsKrw(UpbitDepositKrwRequest(amount)))
            .thenReturn(success(depositKrwResponse))

        // when
        val result = cut.postDepositKrw(amount).joining()

        // then
        assertThat(result).isEqualTo(depositKrwResponse.toDomain())
    }

    @Test
    fun getWalletStatus() {
        // given
        val walletStatusResponse = upbitWalletStatusResponseFixture()
        whenever(infoAsyncApi.getWalletStatus()).thenReturn(success(listOf(walletStatusResponse)))

        // when
        val result = cut.getWalletStatus().joining()

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
        whenever(infoAsyncApi.getApiKeys()).thenReturn(success(listOf(apiKeyResponse)))

        // when
        val result = cut.getApiKeys().joining()

        // then
        assertAll("apiKey",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(apiKeyResponse.toDomain()) }
        )
    }
}
