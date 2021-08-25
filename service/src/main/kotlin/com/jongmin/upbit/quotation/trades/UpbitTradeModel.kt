package com.jongmin.upbit.quotation.trades

class UpbitTicks(
    val data: List<UpbitTick>
){
    class UpbitTick(

        /**
         * 설명: 마켓명
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 체결 일자(UTC)
         * 타입: String
         */
        val tradeDateUtc: String,

        /**
         * 설명: 체결 시각(UTC)
         * 타입: String
         */
        val tradeTimeUtc: String,

        /**
         * 설명: 체결 타임스탬프
         * 타입: Long
         */
        val timestamp: Long,

        /**
         * 설명: 체결 가격
         * 타입: Double
         */
        val tradePrice: Double,

        /**
         * 설명: 체결량
         * 타입: Double
         */
        val tradeVolume: Double,

        /**
         * 설명: 전일 종가
         * 타입: Double
         */
        val prevClosingPrice: Double,

        /**
         * 설명: 변화량
         * 타입: Double
         */
        val changePrice: Double,

        /**
         * 설명: 매도 / 매수
         * 타입: String
         */
        val askBid: String,

        /**
         * 설명: 체결 번호(Unique)
         * 타입: Long
         */
        val sequentialId: Long
    )
}