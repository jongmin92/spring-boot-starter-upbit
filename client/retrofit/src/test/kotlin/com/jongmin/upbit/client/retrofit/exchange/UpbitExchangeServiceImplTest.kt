package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitAccountResponse
import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsApi
import com.jongmin.upbit.token.AuthorizationTokenService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import retrofit2.Call
import retrofit2.Response

class UpbitExchangeServiceImplTest {
    private val accountsApi = mock<UpbitExchangeAccountsApi>()
    private val ordersApi = mock<UpbitExchangeOrdersApi>()
    private val withdrawsApi = mock<UpbitExchangeWithdrawsApi>()
    private val depositsApi = mock<UpbitExchangeDepositsApi>()
    private val infoApi = mock<UpbitExchangeInfoApi>()
    private val authorizationTokenService = mock<AuthorizationTokenService> {
        on { createToken() } doReturn "token"
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
            "currency",
            "balance",
            "locked",
            "avgBuyPrice",
            false,
            "unitCurrency"
        )
        val call = mock<Call<List<UpbitAccountResponse>>> {
            on { execute() } doReturn Response.success(listOf(account))
        }

        whenever(accountsApi.getAccounts()).thenReturn(call)

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
}
