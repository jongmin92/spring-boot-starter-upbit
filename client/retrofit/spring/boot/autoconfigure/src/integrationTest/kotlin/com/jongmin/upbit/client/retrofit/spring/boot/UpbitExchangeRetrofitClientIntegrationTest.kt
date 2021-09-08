package com.jongmin.upbit.client.retrofit.spring.boot

import com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure.UpbitRetrofitClientAutoConfigure
import com.jongmin.upbit.exchange.UpbitExchangeService
import com.jongmin.upbit.server.mock.exchange.GetAccountsResponse
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
        // when
        val result = upbitExchangeService.getAccounts()

        // then
        assertAll("result[0]",
            { assertThat(result[0].currency).isEqualTo(GetAccountsResponse.currency1) },
            { assertThat(result[0].balance).isEqualTo(GetAccountsResponse.balance1) },
            { assertThat(result[0].locked).isEqualTo(GetAccountsResponse.locked1) },
            { assertThat(result[0].avgBuyPrice).isEqualTo(GetAccountsResponse.avgBuyPrice1) },
            { assertThat(result[0].avgBuyPriceModified).isEqualTo(GetAccountsResponse.avgBuyPriceModified1) },
            { assertThat(result[0].unitCurrency).isEqualTo(GetAccountsResponse.unitCurrency1) }
        )
        assertAll("result[1]",
            { assertThat(result[1].currency).isEqualTo(GetAccountsResponse.currency2) },
            { assertThat(result[1].balance).isEqualTo(GetAccountsResponse.balance2) },
            { assertThat(result[1].locked).isEqualTo(GetAccountsResponse.locked2) },
            { assertThat(result[1].avgBuyPrice).isEqualTo(GetAccountsResponse.avgBuyPrice2) },
            { assertThat(result[1].avgBuyPriceModified).isEqualTo(GetAccountsResponse.avgBuyPriceModified2) },
            { assertThat(result[1].unitCurrency).isEqualTo(GetAccountsResponse.unitCurrency2) }
        )
    }

    @AfterEach
    fun checkAuthorizationTokenExistInRequest() {
        assertThat(upbitMockServer.getAuthorizationToken()).isNotNull
    }
}
