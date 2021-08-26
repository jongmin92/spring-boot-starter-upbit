package com.jongmin.upbit.quotation.orderbook

data class UpbitOrderbooks(
    val data: List<UpbitOrderbook>
) {
    data class UpbitOrderbook(
        /**
         * 설명: 마켓 코드 (종목 정보)
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 타임스탬프
         * 타입: Long
         */
        val timestamp: Long,

        /**
         * 설명: 호가 매도 총 잔량
         * 타입: Double
         */
        val totalAskSize: Double,

        /**
         * 설명: 호가 매수 총 잔량
         * 타입: Double
         */
        val totalBidSize: Double,

        /**
         * 설명: 호가 유닛 리스트
         * 타입: List<UpbitOrderbookUnit>
         */
        val orderbookUnits: List<UpbitOrderbookUnit>
    )
    data class UpbitOrderbookUnit(
        /**
         * 설명: 매도 가격
         * 타입: Double
         */
        val askPrice: Double,

        /**
         * 설명: 매수 가격
         * 타입: Double
         */
        val bidPrice: Double,

        /**
         * 설명: 매도 잔량
         * 타입: Double
         */
        val askSize: Double,

        /**
         * 설명: 매수 잔량
         * 타입: Double
         */
        val bidSize: Double
    )
}
