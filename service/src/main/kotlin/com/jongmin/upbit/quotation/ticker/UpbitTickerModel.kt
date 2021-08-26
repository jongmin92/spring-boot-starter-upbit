package com.jongmin.upbit.quotation.ticker

data class UpbitTickers(
    val data: List<UpbitTicker>
) {
    data class UpbitTicker(

        /**
         * 설명: 마켓명 (종목 구분코드)
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 최근 거래 일자(UTC)
         * 타입: String
         */
        val tradeDate: String,

        /**
         * 설명: 최근 거래 시간(UTC)
         * 타입: String
         */
        val tradeTime: String,

        /**
         * 설명: 최근 거래 날짜(KST)
         * 타입: String
         */
        val tradeDateKst: String,

        /**
         * 설명: 최근 거래 시간(KST)
         * 타입: String
         */
        val tradeTimeKst: String,

        /**
         * 설명: 시가
         * 타입: Double
         */
        val openingPrice: Double,

        /**
         * 설명: 고가
         * 타입: Double
         */
        val highPrice: Double,

        /**
         * 설명: 저가
         * 타입: Double
         */
        val lowPrice: Double,

        /**
         * 설명: 종가
         * 타입: Double
         */
        val tradePrice: Double,

        /**
         * 설명: 전일 종가
         * 타입: Double
         */
        val prevClosingPrice: Double,

        /**
         * 설명: 변화 (상승, 보합 ,하락)
         * 타입: UpbitChange
         */
        val change: UpbitChange,

        /**
         * 설명: 변화액의 절대값
         * 타입: Double
         */
        val changePrice: Double,

        /**
         * 설명: 변화율의 절대값
         * 타입: Double
         */
        val changeRate: Double,

        /**
         * 설명: 부호 있는 변화액
         * 타입: Double
         */
        val signedChangePrice: Double,

        /**
         * 설명: 부호 있는 변화율
         * 타입: Double
         */
        val signedChangeRate: Double,

        /**
         * 설명: 거래량
         * 타입: Double
         */
        val tradeVolume: Double,

        /**
         * 설명: 누적 거래 대금 (UTC 0시 기준)
         * 타입: Double
         */
        val accTradePrice: Double,

        /**
         * 설명: 누적 거래 대금 (24시간 누적)
         * 타입: Double
         */
        val accTradePrice24h: Double,

        /**
         * 설명: 누적 거래량 (UTC 0시 기준)
         * 타입: Double
         */
        val accTradeVolume: Double,

        /**
         * 설명: 누적 거래량 (24시간 누적)
         * 타입: Double
         */
        val accTradeVolume24h: Double,

        /**
         * 설명: 52주 신고가
         * 타입: Double
         */
        val highest52WeekPrice: Double,

        /**
         * 설명: 52주 신고가 달성일
         * 타입: String
         */
        val highest52WeekDate: String,

        /**
         * 설명: 52주 신저가
         * 타입: Double
         */
        val lowest52WeekPrice: Double,

        /**
         * 설명: 52주 신저가 달성일
         * 타입: String
         */
        val lowest52WeekDate: String,

        /**
         * 설명: 현재 시각 타임스탬프
         * 타입: Long
         */
        val timestamp: Long
    )
}

enum class UpbitChange(val change: String){
    EVEN("EVEN"), RISE("RISE"), FALL("FALL")
}
