package com.jongmin.upbit.client.retrofit.quotation.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty

data class UpbitTickersResponse(
    val data: List<UpbitTickerResponse>
) {
    data class UpbitTickerResponse(

        /**
         * 설명: 마켓명 (종목 구분코드)
         * 타입: String
         */
        @JsonProperty("market")
        val market: String,

        /**
         * 설명: 최근 거래 일자(UTC)
         * 타입: String
         */
        @JsonProperty("trade_date")
        val tradeDate: String,

        /**
         * 설명: 최근 거래 시간(UTC)
         * 타입: String
         */
        @JsonProperty("trade_time")
        val tradeTime: String,

        /**
         * 설명: 최근 거래 날짜(KST)
         * 타입: String
         */
        @JsonProperty("trade_date_kst")
        val tradeDateKst: String,

        /**
         * 설명: 최근 거래 시간(KST)
         * 타입: String
         */
        @JsonProperty("trade_time_kst")
        val tradeTimeKst: String,

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
         * 설명: 전일 종가
         * 타입: Double
         */
        @JsonProperty("prev_closing_price")
        val prevClosingPrice: Double,

        /**
         * 설명: 변화 (상승, 보합 ,하락)
         * 타입: UpbitChange
         */
        @JsonProperty("change")
        val change: UpbitChange,

        /**
         * 설명: 변화액의 절대값
         * 타입: Double
         */
        @JsonProperty("change_price")
        val changePrice: Double,

        /**
         * 설명: 변화율의 절대값
         * 타입: Double
         */
        @JsonProperty("change_rate")
        val changeRate: Double,

        /**
         * 설명: 부호 있는 변화액
         * 타입: Double
         */
        @JsonProperty("signed_change_price")
        val signedChangePrice: Double,

        /**
         * 설명: 부호 있는 변화율
         * 타입: Double
         */
        @JsonProperty("signed_change_rate")
        val signedChangeRate: Double,

        /**
         * 설명: 거래량
         * 타입: Double
         */
        @JsonProperty("trade_volume")
        val tradeVolume: Double,

        /**
         * 설명: 누적 거래 대금 (UTC 0시 기준)
         * 타입: Double
         */
        @JsonProperty("acc_trade_price")
        val accTradePrice: Double,

        /**
         * 설명: 누적 거래 대금 (24시간 누적)
         * 타입: Double
         */
        @JsonProperty("acc_trade_price_24h")
        val accTradePrice24h: Double,

        /**
         * 설명: 누적 거래량 (UTC 0시 기준)
         * 타입: Double
         */
        @JsonProperty("acc_trade_volume")
        val accTradeVolume: Double,

        /**
         * 설명: 누적 거래량 (24시간 누적)
         * 타입: Double
         */
        @JsonProperty("acc_trade_volume_24h")
        val accTradeVolume24h: Double,

        /**
         * 설명: 52주 신고가
         * 타입: Double
         */
        @JsonProperty("highest_52_week_price")
        val highest52WeekPrice: Double,

        /**
         * 설명: 52주 신고가 달성일
         * 타입: String
         */
        @JsonProperty("highest_52_week_date")
        val highest52WeekDate: String,

        /**
         * 설명: 52주 신저가
         * 타입: Double
         */
        @JsonProperty("lowest_52_week_price")
        val lowest52WeekPrice: Double,

        /**
         * 설명: 52주 신저가 달성일
         * 타입: String
         */
        @JsonProperty("lowest_52_week_date")
        val lowest52WeekDate: String,

        /**
         * 설명: 현재 시각 타임스탬프
         * 타입: Long
         */
        @JsonProperty("timestamp")
        val timestamp: Long
    )
}

enum class UpbitChange(val change: String){
    EVEN("EVEN"), RISE("RISE"), FALL("FALL")
}
