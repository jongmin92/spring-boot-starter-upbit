package com.jongmin.upbit.quotation.candles

data class MinuteCandles(
    val data: List<MinuteCandle>
) {
    data class MinuteCandle(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        val candleDateTimeKst: String,

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
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        val timeStamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        val candleAccTradeVolume: Double,

        /**
         * 설명: 분 단위 유닛
         * 타입: Int
         */
        val unit: Int
    )
}

data class DayCandles(
    val data: List<DayCandle>
) {
    data class DayCandle(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        val candleDateTimeKst: String,

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
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        val timeStamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        val candleAccTradeVolume: Double,

        /**
         * 설명: 전일 종가
         * 타입: Double
         */
        val prevClosingPrice: Double,

        /**
         * 설명: 전일 종가 대비 변화 금액
         * 타입: Double
         */
        val changePrice: Double,

        /**
         * 설명: 전일 종가 대비 변화율
         * 타입: Double
         */
        val changeRate: Double,

        /**
         * 설명: 종가 환상 화폐 단위로 환산된 가격
         * 타입: Double
         */
        val convertedTradePrice: Double
    )
}

data class WeekCandles(
    val data: List<WeekCandle>
) {
    data class WeekCandle(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        val candleDateTimeKst: String,

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
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        val timeStamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        val candleAccTradeVolume: Double,

        /**
         * 설명: 캔들 기간의 가장 첫날
         * 타입: String
         */
        val firstDayOfPeroid: String
    )
}

data class MonthCandles(
    val data: List<MonthCandle>
) {
    data class MonthCandle(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        val candleDateTimeKst: String,

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
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        val timeStamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        val candleAccTradeVolume: Double,

        /**
         * 설명: 캔들 기간의 가장 첫날
         * 타입: String
         */
        val firstDayOfPeroid: String
    )
}
