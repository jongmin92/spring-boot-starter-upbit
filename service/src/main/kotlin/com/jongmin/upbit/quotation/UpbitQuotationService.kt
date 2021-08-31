package com.jongmin.upbit.quotation

import com.jongmin.upbit.quotation.candles.UpbitCandleService
import com.jongmin.upbit.quotation.market.UpbitMarketService
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbookService
import com.jongmin.upbit.quotation.ticker.UpbitTickerService
import com.jongmin.upbit.quotation.trades.UpbitTradeService

interface UpbitQuotationService : UpbitCandleService, UpbitMarketService, UpbitOrderbookService,
    UpbitTickerService, UpbitTradeService {
}
