package com.jongmin.upbit.client.retrofit.exchange.api.account

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.exchange.account.UpbitAccount

data class UpbitAccountResponse(
    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    @JsonProperty("currency")
    val currency: String,

    /**
     * 설명: 주문가능 금액/수량
     * 타입: NumberString
     */
    @JsonProperty("balance")
    val balance: String,

    /**
     * 설명: 주문 중 묶여있는 금액/수량
     * 타입: NumberString
     */
    @JsonProperty("locked")
    val locked: String,

    /**
     * 설명: 매수평균가
     * 타입: NumberString
     */
    @JsonProperty("avg_buy_price")
    val avgBuyPrice: String,

    /**
     * 설명: 매수평균가 수정 여부
     * 타입: Boolean
     */
    @JsonProperty("avg_buy_price_modified")
    val avgBuyPriceModified: Boolean,

    /**
     * 설명: 평단가 기준 화폐
     * 타입: String
     */
    @JsonProperty("unit_currency")
    val unitCurrency: String
)

fun UpbitAccountResponse.toDomain() = UpbitAccount(
    currency = currency,
    balance = balance,
    locked = locked,
    avgBuyPrice = avgBuyPrice,
    avgBuyPriceModified = avgBuyPriceModified,
    unitCurrency = unitCurrency
)
