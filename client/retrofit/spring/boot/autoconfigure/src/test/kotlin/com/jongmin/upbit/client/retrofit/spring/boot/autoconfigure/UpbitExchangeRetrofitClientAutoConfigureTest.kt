package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.jongmin.upbit.exchange.UpbitExchangeService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest(classes = [
    UpbitExchangeRetrofitClientAutoConfigure::class,
    UpbitQuotationRetrofitClientAutoConfigure::class,
])
class UpbitExchangeRetrofitClientAutoConfigureTest {
    @Autowired
    lateinit var upbitExchangeService: UpbitExchangeService

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Test
    fun test() {
        assertThat(applicationContext.getBeansOfType(UpbitExchangeService::class.java)).isNotNull

        val accounts = upbitExchangeService.getAccounts()
        println(accounts)
    }
}
