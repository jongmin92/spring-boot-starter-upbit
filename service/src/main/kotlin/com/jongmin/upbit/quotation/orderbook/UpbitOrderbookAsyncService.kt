package com.jongmin.upbit.quotation.orderbook

import java.util.concurrent.CompletableFuture

interface UpbitOrderbookAsyncService {

    /**
     * 오더북 정보들을 보여준다.
     *
     * @param markets 마켓코드 (반점으로 구분  ex. KRW-BTC, BTC-ETH)
     * @return 오더북 정보
     */
    fun getUpbitOrderbooks(markets: String): CompletableFuture<List<UpbitOrderbook>>
}