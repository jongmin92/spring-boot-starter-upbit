package com.jongmin.upbit.client.retrofit.spring.boot

import com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure.UpbitRetrofitClientAutoConfigure
import com.jongmin.upbit.exchange.UpbitExchangeService
import org.junit.jupiter.api.Test
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
        // TODO
    }
}
