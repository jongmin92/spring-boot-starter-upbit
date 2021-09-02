package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsApi
import com.jongmin.upbit.client.retrofit.exchange.api.account.toDomain
import com.jongmin.upbit.client.retrofit.exchange.api.account.upbitAccountResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrderIncludingTradesResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.upbitOrdersChanceResponseFixture
import com.jongmin.upbit.client.retrofit.exchange.api.order.toDomain
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
        val account = upbitAccountResponseFixture()
        doReturn(success(listOf(account))).whenever(accountsApi).getAccounts()

        // when
        val result = cut.getAccounts()

        // then
        assertAll("account",
            { assertThat(result).hasSize(1) },
            { assertThat(result.first()).isEqualTo(account.toDomain()) }
        )
    }

    @Test
    fun getOrdersChance() {
        // given
        val market = "market"
        val ordersChance = upbitOrdersChanceResponseFixture()
        doReturn(success(ordersChance)).whenever(ordersApi).getOrdersChance(market)

        // when
        val result = cut.getOrdersChance(market)

        // then
        assertThat(result).isEqualTo(ordersChance.toDomain())
    }

    @Test
    fun getOrder() {
        // given
        val uuid = "uuid"
        val identifier = "identifier"
        val order = upbitOrderIncludingTradesResponseFixture()
        doReturn(success(order)).whenever(ordersApi).getOrder(uuid, identifier)

        // when
        val result = cut.getOrder(uuid, identifier)

        // then
        assertThat(result).isEqualTo(order.toDomain())
    }
}
