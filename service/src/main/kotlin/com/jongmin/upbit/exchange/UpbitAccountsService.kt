package com.jongmin.upbit.exchange

import UpbitAccounts

interface UpbitAccountsService {
    fun getAccounts(): UpbitAccounts
}
