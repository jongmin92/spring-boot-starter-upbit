package com.jongmin.upbit.client.retrofit.exchange.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.exchange.order.UpbitOrdersChance

data class UpbitOrdersChanceResponse(
    /**
     * 설명: 매수 수수료 비율
     * 타입: NumberString
     */
    @JsonProperty("bid_fee")
    val bidFee: String,

    /**
     * 설명: 매도 수수료 비율
     * 타입: NumberString
     */
    @JsonProperty("ask_fee")
    val askFee: String,

    /**
     * 설명: 마켓에 대한 정보
     * 타입: Market
     */
    @JsonProperty("market")
    val market: MarketResponse,

    /**
     * 설명: 매수 시 사용하는 화폐의 계좌 상태
     * 타입: BidAccount
     */
    @JsonProperty("bid_account")
    val bidAccount: BidAccountResponse,

    /**
     * 설명: 매도 시 사용하는 화폐의 계좌 상태
     * 타입: AskAccount
     */
    @JsonProperty("ask_account")
    val askAccount: AskAccountResponse
) {
    data class MarketResponse(
        /**
         * 설명: 마켓의 유일 키
         * 타입: String
         */
        @JsonProperty("id")
        val id: String,

        /**
         * 설명: 마켓 이름
         * 타입: String
         */
        @JsonProperty("name")
        val name: String,

        /**
         * 설명: 지원 주문 방식
         * 타입: List<String>
         */
        @JsonProperty("order_types")
        val orderTypes: List<String>,

        /**
         * 설명: 지원 주문 종류
         * 타입: List<String>
         */
        @JsonProperty("order_sides")
        val orderSides: List<String>,

        /**
         * 설명: 매수 시 제약사항
         * 타입: Bid
         */
        @JsonProperty("bid")
        val bid: Bid,

        /**
         * 설명: 매도 시 제약사항
         * 타입: Ask
         */
        @JsonProperty("ask")
        val ask: Ask,

        /**
         * 설명: 최대 매도/매수 금액
         * 타입: NumberString
         */
        @JsonProperty("max_total")
        val maxTotal: String,

        /**
         * 설명: 마켓 운영 상태
         * 타입: String
         */
        @JsonProperty("state")
        val state: String
    ) {
        data class Bid(
            /**
             * 설명: 화폐를 의미하는 영문 대문자 코드
             * 타입: String
             */
            @JsonProperty("currency")
            val currency: String,

            /**
             * 설명: 주문금액 단위
             * 타입: String
             */
            @JsonProperty("price_unit")
            val priceUnit: String,

            /**
             * 설명: 최소 매도/매수 금액
             * 타입: Number
             */
            @JsonProperty("min_total")
            val minTotal: Int,
        )

        data class Ask(
            /**
             * 설명: 화폐를 의미하는 영문 대문자 코드
             * 타입: String
             */
            @JsonProperty("currency")
            val currency: String,

            /**
             * 설명: 주문금액 단위
             * 타입: String
             */
            @JsonProperty("price_unit")
            val priceUnit: String,

            /**
             * 설명: 최소 매도/매수 금액
             * 타입: Number
             */
            @JsonProperty("min_total")
            val minTotal: Int,
        )
    }

    data class BidAccountResponse(
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

    data class AskAccountResponse(
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
}

fun UpbitOrdersChanceResponse.toDomain() = UpbitOrdersChance(
    bidFee = bidFee,
    askFee = askFee,
    market = market.toDomain(),
    bidAccount = bidAccount.toDomain(),
    askAccount = askAccount.toDomain()
)

fun UpbitOrdersChanceResponse.MarketResponse.toDomain() = UpbitOrdersChance.Market(
    id = id,
    name = name,
    orderTypes = orderTypes,
    orderSides = orderSides,
    bid = bid.toDomain(),
    ask = ask.toDomain(),
    maxTotal = maxTotal,
    state = state
)

fun UpbitOrdersChanceResponse.MarketResponse.Bid.toDomain() = UpbitOrdersChance.Market.Bid(
    currency = currency,
    priceUnit = priceUnit,
    minTotal = minTotal
)

fun UpbitOrdersChanceResponse.MarketResponse.Ask.toDomain() = UpbitOrdersChance.Market.Ask(
    currency = currency,
    priceUnit = priceUnit,
    minTotal = minTotal
)

fun UpbitOrdersChanceResponse.BidAccountResponse.toDomain() = UpbitOrdersChance.BidAccount(
    currency = currency,
    balance = balance,
    locked = locked,
    avgBuyPrice = avgBuyPrice,
    avgBuyPriceModified = avgBuyPriceModified,
    unitCurrency = unitCurrency
)

fun UpbitOrdersChanceResponse.AskAccountResponse.toDomain() = UpbitOrdersChance.AskAccount(
    currency = currency,
    balance = balance,
    locked = locked,
    avgBuyPrice = avgBuyPrice,
    avgBuyPriceModified = avgBuyPriceModified,
    unitCurrency = unitCurrency
)
