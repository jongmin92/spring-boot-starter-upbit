package com.jongmin.upbit.exchange

import com.jongmin.upbit.exchange.account.UpbitAccountsCoroutineService
import com.jongmin.upbit.exchange.deposit.UpbitDepositsCoroutineService
import com.jongmin.upbit.exchange.info.UpbitInfoCoroutineService
import com.jongmin.upbit.exchange.order.UpbitOrdersCoroutineService
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawsCoroutineService

interface UpbitExchangeCoroutineService : UpbitAccountsCoroutineService, UpbitOrdersCoroutineService,
    UpbitWithdrawsCoroutineService, UpbitDepositsCoroutineService, UpbitInfoCoroutineService
