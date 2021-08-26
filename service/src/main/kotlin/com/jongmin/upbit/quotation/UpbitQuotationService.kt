package com.jongmin.upbit.quotation

import com.jongmin.upbit.exchange.order.UpbitOrdersService
import com.jongmin.upbit.quotation.candles.UpbitCandleService
import com.jongmin.upbit.quotation.market.UpbitMarketService
import com.jongmin.upbit.quotation.ticker.UpbitTickerService
import com.jongmin.upbit.quotation.trades.UpbitTradeService

interface UpbitQuotationService : UpbitCandleService, UpbitMarketService, UpbitOrdersService,
    UpbitTickerService, UpbitTradeService {
}
