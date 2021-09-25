package com.jongmin.upbit.quotation

import com.jongmin.upbit.quotation.candles.UpbitCandleAsyncService
import com.jongmin.upbit.quotation.market.UpbitMarketAsyncService
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbookAsyncService
import com.jongmin.upbit.quotation.ticker.UpbitTickerAsyncService
import com.jongmin.upbit.quotation.trades.UpbitTradeAsyncService

interface UpbitQuotationAsyncService : UpbitCandleAsyncService, UpbitMarketAsyncService,
    UpbitOrderbookAsyncService, UpbitTickerAsyncService, UpbitTradeAsyncService
