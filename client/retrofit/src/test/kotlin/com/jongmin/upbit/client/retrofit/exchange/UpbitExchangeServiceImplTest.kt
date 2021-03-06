package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.account.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.account.upbitAccountResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitCreateDepositCoinAddressResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositCoinAddressResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositKrwResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.upbitDepositResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.info.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.info.upbitApiKeyResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.info.upbitWalletStatusResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderDeleteResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderIncludingTradesResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrdersChanceResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawCoinPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawKrwPostResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.upbitWithdrawsChanceResponseFixture
import com.jongmin.upbit.client.retrofit.utils.success
import com.jongmin.upbit.exchange.UpbitExchangeAsyncService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class UpbitExchangeServiceImplTest {
    private val upbitExchangeAsyncService = mock<UpbitExchangeAsyncService>()

    private val cut = UpbitExchangeServiceImpl(upbitExchangeAsyncService)

    @Test
    fun getAccounts() {
        // given
        val accountResponse = upbitAccountResponseFixture()
        whenever(upbitExchangeAsyncService.getAccounts())
            .thenReturn(success(listOf(accountResponse.toDomain())))

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
        whenever(upbitExchangeAsyncService.getOrdersChance(market))
            .thenReturn(success(ordersChanceResponse.toDomain()))

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
        whenever(upbitExchangeAsyncService.getOrder(uuid, identifier))
            .thenReturn(success(orderResponse.toDomain()))

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
        whenever(
            upbitExchangeAsyncService.getOrders(
                market = market,
                state = state,
                states = states,
                uuids = uuids,
                identifiers = identifiers,
                page = page,
                limit = limit,
                orderBy = orderBy
            )
        ).thenReturn(success(listOf(orderResponse.toDomain())))

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
        whenever(upbitExchangeAsyncService.deleteOrder(uuid, identifier))
            .thenReturn(success(orderDeleteResponse.toDomain()))

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
        whenever(
            upbitExchangeAsyncService.postOrder(
                market = market,
                side = side,
                volume = volume,
                price = price,
                ordType = ordType,
                identifier = identifier
            )
        ).thenReturn(success(orderPostResponse.toDomain()))

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
        whenever(
            upbitExchangeAsyncService.getWithdraws(
                currency = currency,
                state = state,
                uuids = uuids,
                txids = txids,
                limit = limit,
                page = page,
                orderBy = orderBy
            )
        ).thenReturn(success(listOf(withdrawResponse.toDomain())))

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
        whenever(upbitExchangeAsyncService.getWithdraw(uuid, txid, currency))
            .thenReturn(success(withdrawResponse.toDomain()))

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
        whenever(upbitExchangeAsyncService.getWithdrawsChance(currency))
            .thenReturn(success(withdrawsChanceResponse.toDomain()))

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
        whenever(
            upbitExchangeAsyncService.postWithdrawCoin(
                currency = currency,
                amount = amount,
                address = address,
                secondaryAddress = secondaryAddress,
                transactionType = transactionType
            )
        ).thenReturn(success(withdrawCoinPostResponse.toDomain()))

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
        whenever(upbitExchangeAsyncService.postWithdrawKrw(amount))
            .thenReturn(success(withdrawKrwPostResponse.toDomain()))

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
        whenever(
            upbitExchangeAsyncService.getDeposits(
                currency = currency,
                state = state,
                uuids = uuids,
                txids = txids,
                limit = limit,
                page = page,
                orderBy = orderBy
            )
        ).thenReturn(success(listOf(depositResponse.toDomain())))

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
        whenever(upbitExchangeAsyncService.getDeposit(uuid, txid, currency))
            .thenReturn(success(depositResponse.toDomain()))

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
        whenever(upbitExchangeAsyncService.createDepositCoinAddress(currency))
            .thenReturn(success(depositCoinAddressResponse.toDomain()))

        // when
        val result = cut.createDepositCoinAddress(currency)

        // then
        assertThat(result).isEqualTo(depositCoinAddressResponse.toDomain())
    }

    @Test
    fun getDepositsCoinAddresses() {
        // given
        val depositCoinAddressResponse = upbitDepositCoinAddressResponseFixture()
        whenever(upbitExchangeAsyncService.getDepositsCoinAddresses())
            .thenReturn(success(listOf(depositCoinAddressResponse.toDomain())))

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
        whenever(upbitExchangeAsyncService.getDepositsCoinAddress(currency))
            .thenReturn(success(depositCoinAddressResponse.toDomain()))

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
        whenever(upbitExchangeAsyncService.postDepositKrw(amount))
            .thenReturn(success(depositKrwResponse.toDomain()))

        // when
        val result = cut.postDepositKrw(amount)

        // then
        assertThat(result).isEqualTo(depositKrwResponse.toDomain())
    }

    @Test
    fun getWalletStatus() {
        // given
        val walletStatusResponse = upbitWalletStatusResponseFixture()
        whenever(upbitExchangeAsyncService.getWalletStatus())
            .thenReturn(success(listOf(walletStatusResponse.toDomain())))

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
        whenever(upbitExchangeAsyncService.getApiKeys())
            .thenReturn(success(listOf(apiKeyResponse.toDomain())))

        // when
        val result = cut.getApiKeys()

        // then
        assertAll("apiKey",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(apiKeyResponse.toDomain()) }
        )
    }
}
