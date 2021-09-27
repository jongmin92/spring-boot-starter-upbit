package com.jongmin.upbit.quotation

import com.jongmin.upbit.quotation.candles.UpbitCandleCoroutineService
import com.jongmin.upbit.quotation.market.UpbitMarketCoroutineService
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbookCoroutineService
import com.jongmin.upbit.quotation.ticker.UpbitTickerCoroutineService
import com.jongmin.upbit.quotation.trades.UpbitTradeCoroutineService

interface UpbitQuotationCoroutineService : UpbitCandleCoroutineService, UpbitMarketCoroutineService,
    UpbitOrderbookCoroutineService, UpbitTickerCoroutineService, UpbitTradeCoroutineService
