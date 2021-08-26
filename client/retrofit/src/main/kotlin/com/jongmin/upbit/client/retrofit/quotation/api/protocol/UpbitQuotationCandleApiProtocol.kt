package com.jongmin.upbit.client.retrofit.quotation.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty

data class MinuteCandlesResponse(
    val data: List<MinuteCandleResponse>
) {
    data class MinuteCandleResponse(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        @JsonProperty("market")
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        @JsonProperty("candle_date_time_utc")
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        @JsonProperty("candle_date_time_kst")
        val candleDateTimeKst: String,

        /**
         * 설명: 시가
         * 타입: Double
         */
        @JsonProperty("opening_price")
        val openingPrice: Double,

        /**
         * 설명: 고가
         * 타입: Double
         */
        @JsonProperty("high_price")
        val highPrice: Double,

        /**
         * 설명: 저가
         * 타입: Double
         */
        @JsonProperty("low_price")
        val lowPrice: Double,

        /**
         * 설명: 종가
         * 타입: Double
         */
        @JsonProperty("trade_price")
        val tradePrice: Double,

        /**
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        @JsonProperty("timestamp")
        val timestamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_price")
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_volume")
        val candleAccTradeVolume: Double,

        /**
         * 설명: 분 단위 유닛
         * 타입: Int
         */
        @JsonProperty("unit")
        val unit: Int
    )
}

data class DayCandlesResponse(
    val data: List<DayCandleResponse>
) {
    data class DayCandleResponse(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        @JsonProperty("market")
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        @JsonProperty("candle_date_time_utc")
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        @JsonProperty("candle_date_time_kst")
        val candleDateTimeKst: String,

        /**
         * 설명: 시가
         * 타입: Double
         */
        @JsonProperty("opening_price")
        val openingPrice: Double,

        /**
         * 설명: 고가
         * 타입: Double
         */
        @JsonProperty("high_price")
        val highPrice: Double,

        /**
         * 설명: 저가
         * 타입: Double
         */
        @JsonProperty("low_price")
        val lowPrice: Double,

        /**
         * 설명: 종가
         * 타입: Double
         */
        @JsonProperty("trade_price")
        val tradePrice: Double,

        /**
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        @JsonProperty("timestamp")
        val timestamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_price")
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_volume")
        val candleAccTradeVolume: Double,

        /**
         * 설명: 전일 종가
         * 타입: Double
         */
        @JsonProperty("prev_closing_price")
        val prevClosingPrice: Double,

        /**
         * 설명: 전일 종가 대비 변화 금액
         * 타입: Double
         */
        @JsonProperty("change_price")
        val changePrice: Double,

        /**
         * 설명: 전일 종가 대비 변화율
         * 타입: Double
         */
        @JsonProperty("change_rate")
        val changeRate: Double,

        /**
         * 설명: 종가 환상 화폐 단위로 환산된 가격
         * 타입: Double
         */
        @JsonProperty("converted_trade_price")
        val convertedTradePrice: Double
    )
}

data class WeekCandlesResponse(
    val data: List<WeekCandleResponse>
) {
    data class WeekCandleResponse(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        @JsonProperty("market")
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        @JsonProperty("candle_date_time_utc")
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        @JsonProperty("candle_date_time_kst")
        val candleDateTimeKst: String,

        /**
         * 설명: 시가
         * 타입: Double
         */
        @JsonProperty("opening_price")
        val openingPrice: Double,

        /**
         * 설명: 고가
         * 타입: Double
         */
        @JsonProperty("high_price")
        val highPrice: Double,

        /**
         * 설명: 저가
         * 타입: Double
         */
        @JsonProperty("low_price")
        val lowPrice: Double,

        /**
         * 설명: 종가
         * 타입: Double
         */
        @JsonProperty("trade_price")
        val tradePrice: Double,

        /**
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        @JsonProperty("timestamp")
        val timestamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_price")
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_volume")
        val candleAccTradeVolume: Double,

        /**
         * 설명: 캔들 기간의 가장 첫날
         * 타입: String
         */
        @JsonProperty("first_day_of_period")
        val firstDayOfPeroid: String
    )
}

data class MonthCandlesResponse(
    val data: List<MonthCandleResponse>
) {
    data class MonthCandleResponse(
        /**
         * 설명: 마켓명
         * 타입: String
         */
        @JsonProperty("market")
        val market: String,

        /**
         * 설명: 캔들 기준 시각 (UTC)
         * 타입: String
         */
        @JsonProperty("candle_date_time_utc")
        val candleDateTimeUtc: String,

        /**
         * 설명: 캔들 기준 시각 (KST)
         * 타입: String
         */
        @JsonProperty("candle_date_time_kst")
        val candleDateTimeKst: String,

        /**
         * 설명: 시가
         * 타입: Double
         */
        @JsonProperty("opening_price")
        val openingPrice: Double,

        /**
         * 설명: 고가
         * 타입: Double
         */
        @JsonProperty("high_price")
        val highPrice: Double,

        /**
         * 설명: 저가
         * 타입: Double
         */
        @JsonProperty("low_price")
        val lowPrice: Double,

        /**
         * 설명: 종가
         * 타입: Double
         */
        @JsonProperty("trade_price")
        val tradePrice: Double,

        /**
         * 설명: 해당 캔들의 마지막 틱이 저장된 시각
         * 타입: Long
         */
        @JsonProperty("timestamp")
        val timestamp: Long,

        /**
         * 설명: 누적 거래 금액
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_price")
        val candleAccTradePrice: Double,

        /**
         * 설명: 누적 거래량
         * 타입: Double
         */
        @JsonProperty("candle_acc_trade_volume")
        val candleAccTradeVolume: Double,

        /**
         * 설명: 캔들 기간의 가장 첫날
         * 타입: String
         */
        @JsonProperty("first_day_of_period")
        val firstDayOfPeroid: String
    )
}

