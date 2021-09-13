package com.jongmin.upbit.quotation.market

interface UpbitMarketService {

    /**
     * 전체 마켓 조회
     * 업비트의 전체 마켓 정보를 보여줍니다.
     *
     * @param isDetails 유의종목 필드과 같은 상세 정보 노출 여부
     * @return 마켓 리스트
     */
    fun getUpbitMarkets(isDetails: Boolean? = false): List<UpbitMarket>
}
