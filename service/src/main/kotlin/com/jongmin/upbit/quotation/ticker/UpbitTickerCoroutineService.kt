package com.jongmin.upbit.quotation.ticker

import kotlinx.coroutines.Deferred

interface UpbitTickerCoroutineService {

    /**
     * 현재가 정보 리스트들을 보여준다.
     *
     * @param markets 마켓코드 (반점으로 구분  ex. KRW-BTC, BTC-ETH)
     * @return 현재가 정보 리스트
     */
    fun getUpbitTicker(markets: String): Deferred<List<UpbitTicker>>
}
