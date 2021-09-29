package com.jongmin.upbit.quotation.orderbook

import kotlinx.coroutines.Deferred

interface UpbitOrderbookCoroutineService {

    /**
     * 오더북 정보들을 보여준다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param markets 마켓코드 (반점으로 구분  ex. KRW-BTC, BTC-ETH)
     * @return 오더북 정보
     */
    fun getUpbitOrderbooks(markets: String): Deferred<List<UpbitOrderbook>>
}
