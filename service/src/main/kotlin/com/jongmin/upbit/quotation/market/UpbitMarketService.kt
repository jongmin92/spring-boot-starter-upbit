package com.jongmin.upbit.quotation.market

interface UpbitMarketService {

    /**
     * 전체 마켓 조회
     * 업비트의 전체 마켓 정보를 보여줍니다.
     *
     * @return 마켓 리스트
     */
    fun getMarketAll(): UpbitMarkets
}
