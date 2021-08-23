package com.jongmin.upbit.exchange

import com.jongmin.upbit.exchange.account.UpbitAccountsService
import com.jongmin.upbit.exchange.deposit.UpbitDepositsService
import com.jongmin.upbit.exchange.info.UpbitInfoService
import com.jongmin.upbit.exchange.order.UpbitOrdersService
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawsService

interface UpbitExchangeService : UpbitAccountsService, UpbitOrdersService, UpbitWithdrawsService,
    UpbitDepositsService, UpbitInfoService
