package com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure

import com.jongmin.upbit.exchange.UpbitExchangeService
import com.jongmin.upbit.quotation.UpbitQuotationService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext

@SpringBootTest(classes = [UpbitRetrofitClientAutoConfigure::class])
class UpbitRetrofitClientAutoConfigureTest {

    @Autowired
    lateinit var applicationContext: ApplicationContext

    @Test
    fun `check service beans existence`() {
        assertThat(applicationContext.getBeansOfType(UpbitExchangeService::class.java)).isNotNull
        assertThat(applicationContext.getBeansOfType(UpbitQuotationService::class.java)).isNotNull
    }
}
