package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.UpbitExchangeApi
import com.jongmin.upbit.exchange.account.UpbitAccounts
import com.jongmin.upbit.exchange.account.UpbitAccountsService

class UpbitExchangeServiceImpl(
    val upbitExchangeApi: UpbitExchangeApi
) : UpbitAccountsService {
    override fun getAccounts(): UpbitAccounts {
        val response = upbitExchangeApi.getAccounts().execute()
        if (response.isSuccessful) {
        }
    }
}
