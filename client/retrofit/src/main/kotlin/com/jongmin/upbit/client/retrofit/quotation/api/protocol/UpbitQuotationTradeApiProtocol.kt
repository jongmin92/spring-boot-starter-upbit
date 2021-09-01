package com.jongmin.upbit.client.retrofit.quotation.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.quotation.trades.UpbitTick

class UpbitTickResponse(
    /**
     * 설명: 마켓명
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 체결 일자(UTC)
     * 타입: String
     */
    @JsonProperty("trade_date_utc")
    val tradeDateUtc: String,

    /**
     * 설명: 체결 시각(UTC)
     * 타입: String
     */
    @JsonProperty("trade_time_utc")
    val tradeTimeUtc: String,

    /**
     * 설명: 체결 타임스탬프
     * 타입: Long
     */
    @JsonProperty("timestamp")
    val timestamp: Long,

    /**
     * 설명: 체결 가격
     * 타입: Double
     */
    @JsonProperty("trade_price")
    val tradePrice: Double,

    /**
     * 설명: 체결량
     * 타입: Double
     */
    @JsonProperty("trade_volume")
    val tradeVolume: Double,

    /**
     * 설명: 전일 종가
     * 타입: Double
     */
    @JsonProperty("prev_closing_price")
    val prevClosingPrice: Double,

    /**
     * 설명: 변화량
     * 타입: Double
     */
    @JsonProperty("change_price")
    val changePrice: Double,

    /**
     * 설명: 매도 / 매수
     * 타입: String
     */
    @JsonProperty("ask_bid")
    val askBid: String,

    /**
     * 설명: 체결 번호(Unique)
     * 타입: Long
     */
    @JsonProperty("sequential_id")
    val sequentialId: Long
)

fun UpbitTickResponse.toDomain() = UpbitTick(
    market = market,
    tradeDateUtc = tradeDateUtc,
    tradeTimeUtc = tradeTimeUtc,
    timestamp = timestamp,
    tradePrice = tradePrice,
    tradeVolume = tradeVolume,
    prevClosingPrice = prevClosingPrice,
    changePrice = changePrice,
    askBid = askBid,
    sequentialId = sequentialId
)
