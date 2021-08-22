package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.UpbitExchangeApi
import com.jongmin.upbit.exchange.account.UpbitAccounts
import com.jongmin.upbit.exchange.account.UpbitAccountsService

class UpbitAccountsServiceImpl(
    val upbitExchangeApi: UpbitExchangeApi
) : UpbitAccountsService {
    override fun getAccounts(): UpbitAccounts {
        TODO("Not yet implemented")
    }
}
