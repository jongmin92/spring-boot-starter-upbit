package com.jongmin.upbit.exchange

import com.jongmin.upbit.exchange.account.UpbitAccountsAsyncService
import com.jongmin.upbit.exchange.deposit.UpbitDepositsAsyncService
import com.jongmin.upbit.exchange.info.UpbitInfoAsyncService
import com.jongmin.upbit.exchange.order.UpbitOrdersAsyncService
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawsAsyncService

interface UpbitExchangeAsyncService : UpbitAccountsAsyncService, UpbitOrdersAsyncService,
    UpbitWithdrawsAsyncService, UpbitDepositsAsyncService, UpbitInfoAsyncService
