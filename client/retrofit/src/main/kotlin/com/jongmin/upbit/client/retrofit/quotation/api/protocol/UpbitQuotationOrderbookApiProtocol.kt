package com.jongmin.upbit.client.retrofit.quotation.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbook
import com.jongmin.upbit.quotation.orderbook.UpbitOrderbookUnit

data class UpbitOrderbookResponse(
    /**
     * 설명: 마켓 코드 (종목 정보)
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 타임스탬프
     * 타입: Long
     */
    @JsonProperty("timestamp")
    val timestamp: Long,

    /**
     * 설명: 호가 매도 총 잔량
     * 타입: Double
     */
    @JsonProperty("total_ask_size")
    val totalAskSize: Double,

    /**
     * 설명: 호가 매수 총 잔량
     * 타입: Double
     */
    @JsonProperty("total_bid_size")
    val totalBidSize: Double,

    /**
     * 설명: 호가 유닛 리스트
     * 타입: List<UpbitOrderbookUnit>
     */
    @JsonProperty("orderbook_units")
    val orderbookUnits: List<UpbitOrderbookResponseUnit>
)

data class UpbitOrderbookResponseUnit(
    /**
     * 설명: 매도 가격
     * 타입: Double
     */
    @JsonProperty("ask_price")
    val askPrice: Double,

    /**
     * 설명: 매수 가격
     * 타입: Double
     */
    @JsonProperty("bid_price")
    val bidPrice: Double,

    /**
     * 설명: 매도 잔량
     * 타입: Double
     */
    @JsonProperty("ask_size")
    val askSize: Double,

    /**
     * 설명: 매수 잔량
     * 타입: Double
     */
    @JsonProperty("bid_size")
    val bidSize: Double
)

fun UpbitOrderbookResponseUnit.toDomain() = UpbitOrderbookUnit(
    askPrice, bidPrice, askSize, bidSize
)

fun UpbitOrderbookResponse.toDomain() = UpbitOrderbook(
    market = market,
    timestamp = timestamp,
    totalAskSize = totalAskSize,
    totalBidSize = totalBidSize,
    orderbookUnits = orderbookUnits.map { it.toDomain() }
)
