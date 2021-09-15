package com.jongmin.upbit.client.retrofit.exchange.api.order

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.exchange.order.UpbitOrder
import com.jongmin.upbit.exchange.order.UpbitOrderDelete
import com.jongmin.upbit.exchange.order.UpbitOrderPost
import com.jongmin.upbit.exchange.order.UpbitOrderWithTrades
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
            val priceUnit: String?,

            /**
             * 설명: 최소 매도/매수 금액
             * 타입: String
             */
            @JsonProperty("min_total")
            val minTotal: String
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
            val priceUnit: String?,

            /**
             * 설명: 최소 매도/매수 금액
             * 타입: String
             */
            @JsonProperty("min_total")
            val minTotal: String
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

data class UpbitOrderWithTradesResponse(
    /**
     * 설명: 주문의 고유 아이디
     * 타입: String
     */
    @JsonProperty("uuid")
    val uuid: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    @JsonProperty("side")
    val side: String,

    /**
     * 설명: 주문 방식
     * 타입: String
     */
    @JsonProperty("ord_type")
    val ordType: String,

    /**
     * 설명: 주문 당시 화폐 가격
     * 타입: NumberString
     */
    @JsonProperty("price")
    val price: String,

    /**
     * 설명: 주문 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 마켓의 유일키
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 주문 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 사용자가 입력한 주문 양
     * 타입: NumberString
     */
    @JsonProperty("volume")
    val volume: String,

    /**
     * 설명: 체결 후 남은 주문 양
     * 타입: NumberString
     */
    @JsonProperty("remaining_volume")
    val remainingVolume: String,

    /**
     * 설명: 수수료로 예약된 비용
     * 타입: NumberString
     */
    @JsonProperty("reserved_fee")
    val reservedFee: String,

    /**
     * 설명: 남은 수수료
     * 타입: NumberString
     */
    @JsonProperty("remaining_fee")
    val remainingFee: String,

    /**
     * 설명: 사용된 수수료
     * 타입: NumberString
     */
    @JsonProperty("paid_fee")
    val paidFee: String,

    /**
     * 설명: 거래에 사용중인 비용
     * 타입: NumberString
     */
    @JsonProperty("locked")
    val locked: String,

    /**
     * 설명: 체결된 양
     * 타입: NumberString
     */
    @JsonProperty("executed_volume")
    val executedVolume: String,

    /**
     * 설명: 해당 주문에 걸린 체결 수
     * 타입: NumberString
     */
    @JsonProperty("trades_count")
    val tradesCount: Int,

    /**
     * 설명: 체결
     * 타입: List<Trade>
     */
    @JsonProperty("trades")
    val trades: List<TradeResponse>
) {
    data class TradeResponse(
        /**
         * 설명: 마켓의 유일 키
         * 타입: String
         */
        @JsonProperty("market")
        val market: String,

        /**
         * 설명: 체결의 고유 아이디
         * 타입: String
         */
        @JsonProperty("uuid")
        val uuid: String,

        /**
         * 설명: 체결 가격
         * 타입: NumberString
         */
        @JsonProperty("price")
        val price: String,

        /**
         * 설명: 체결 양
         * 타입: NumberString
         */
        @JsonProperty("volume")
        val volume: String,

        /**
         * 설명: 체결된 총 가격
         * 타입: NumberString
         */
        @JsonProperty("funds")
        val funds: String,

        /**
         * 설명: 체결 종류
         * 타입: String
         */
        @JsonProperty("side")
        val side: String
    )
}

data class UpbitOrderResponse(
    /**
     * 설명: 주문의 고유 아이디
     * 타입: String
     */
    @JsonProperty("uuid")
    val uuid: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    @JsonProperty("side")
    val side: String,

    /**
     * 설명: 주문 방식
     * 타입: String
     */
    @JsonProperty("ord_type")
    val ordType: String,

    /**
     * 설명: 주문 당시 화폐 가격
     * 타입: NumberString
     */
    @JsonProperty("price")
    val price: String?,

    /**
     * 설명: 주문 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 마켓의 유일키
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 주문 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 사용자가 입력한 주문 양
     * 타입: NumberString
     */
    @JsonProperty("volume")
    val volume: String,

    /**
     * 설명: 체결 후 남은 주문 양
     * 타입: NumberString
     */
    @JsonProperty("remaining_volume")
    val remainingVolume: String,

    /**
     * 설명: 수수료로 예약된 비용
     * 타입: NumberString
     */
    @JsonProperty("reserved_fee")
    val reservedFee: String,

    /**
     * 설명: 남은 수수료
     * 타입: NumberString
     */
    @JsonProperty("remaining_fee")
    val remainingFee: String,

    /**
     * 설명: 사용된 수수료
     * 타입: NumberString
     */
    @JsonProperty("paid_fee")
    val paidFee: String,

    /**
     * 설명: 거래에 사용중인 비용
     * 타입: NumberString
     */
    @JsonProperty("locked")
    val locked: String,

    /**
     * 설명: 체결된 양
     * 타입: NumberString
     */
    @JsonProperty("executed_volume")
    val executedVolume: String,

    /**
     * 설명: 해당 주문에 걸린 체결 수
     * 타입: NumberString
     */
    @JsonProperty("trades_count")
    val tradesCount: Int
)

data class UpbitOrderDeleteResponse(
    /**
     * 설명: 주문의 고유 아이디
     * 타입: String
     */
    @JsonProperty("uuid")
    val uuid: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    @JsonProperty("side")
    val side: String,

    /**
     * 설명: 주문 방식
     * 타입: String
     */
    @JsonProperty("ord_type")
    val ordType: String,

    /**
     * 설명: 주문 당시 화폐 가격
     * 타입: NumberString
     */
    @JsonProperty("price")
    val price: String,

    /**
     * 설명: 주문 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 마켓의 유일키
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 주문 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 사용자가 입력한 주문 양
     * 타입: NumberString
     */
    @JsonProperty("volume")
    val volume: String,

    /**
     * 설명: 체결 후 남은 주문 양
     * 타입: NumberString
     */
    @JsonProperty("remaining_volume")
    val remainingVolume: String,

    /**
     * 설명: 수수료로 예약된 비용
     * 타입: NumberString
     */
    @JsonProperty("reserved_fee")
    val reservedFee: String,

    /**
     * 설명: 남은 수수료
     * 타입: NumberString
     */
    @JsonProperty("remaining_fee")
    val remainingFee: String,

    /**
     * 설명: 사용된 수수료
     * 타입: NumberString
     */
    @JsonProperty("paid_fee")
    val paidFee: String,

    /**
     * 설명: 거래에 사용중인 비용
     * 타입: NumberString
     */
    @JsonProperty("locked")
    val locked: String,

    /**
     * 설명: 체결된 양
     * 타입: NumberString
     */
    @JsonProperty("executed_volume")
    val executedVolume: String,

    /**
     * 설명: 해당 주문에 걸린 체결 수
     * 타입: NumberString
     */
    @JsonProperty("trades_count")
    val tradesCount: Int
)

data class UpbitOrderPostRequest(
    /**
     * 설명: Market ID
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    @JsonProperty("side")
    val side: String,

    /**
     * 설명: 주문량
     * 타입: NumberString
     */
    @JsonProperty("volume")
    val volume: String,

    /**
     * 설명: 주문 가격
     * 타입: NumberString
     */
    @JsonProperty("price")
    val price: String,

    /**
     * 설명: 주문 타입
     * 타입: String
     */
    @JsonProperty("ord_type")
    val ordType: String,

    /**
     * 설명: 조회용 사용자 지정값
     * 타입: String
     */
    @JsonProperty("identifier")
    val identifier: String?
)

data class UpbitOrderPostResponse(
    /**
     * 설명: 주문의 고유 아이디
     * 타입: String
     */
    @JsonProperty("uuid")
    val uuid: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    @JsonProperty("side")
    val side: String,

    /**
     * 설명: 주문 방식
     * 타입: String
     */
    @JsonProperty("ord_type")
    val ordType: String,

    /**
     * 설명: 주문 당시 화폐 가격
     * 타입: NumberString
     */
    @JsonProperty("price")
    val price: String,

    /**
     * 설명: 체결 가격의 평균가
     * 타입: NumberString
     */
    @JsonProperty("avg_price")
    val avgPrice: String?,

    /**
     * 설명: 주문 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 마켓의 유일키
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 주문 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 사용자가 입력한 주문 양
     * 타입: NumberString
     */
    @JsonProperty("volume")
    val volume: String,

    /**
     * 설명: 체결 후 남은 주문 양
     * 타입: NumberString
     */
    @JsonProperty("remaining_volume")
    val remainingVolume: String,

    /**
     * 설명: 수수료로 예약된 비용
     * 타입: NumberString
     */
    @JsonProperty("reserved_fee")
    val reservedFee: String,

    /**
     * 설명: 남은 수수료
     * 타입: NumberString
     */
    @JsonProperty("remaining_fee")
    val remainingFee: String,

    /**
     * 설명: 사용된 수수료
     * 타입: NumberString
     */
    @JsonProperty("paid_fee")
    val paidFee: String,

    /**
     * 설명: 거래에 사용중인 비용
     * 타입: NumberString
     */
    @JsonProperty("locked")
    val locked: String,

    /**
     * 설명: 체결된 양
     * 타입: NumberString
     */
    @JsonProperty("executed_volume")
    val executedVolume: String,

    /**
     * 설명: 해당 주문에 걸린 체결 수
     * 타입: NumberString
     */
    @JsonProperty("trades_count")
    val tradesCount: Int
)

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

fun UpbitOrderWithTradesResponse.toDomain() = UpbitOrderWithTrades(
    uuid = uuid,
    side = side,
    ordType = ordType,
    price = price,
    state = state,
    market = market,
    createdAt = createdAt,
    volume = volume,
    remainingVolume = remainingVolume,
    reservedFee = reservedFee,
    remainingFee = remainingFee,
    paidFee = paidFee,
    locked = locked,
    executedVolume = executedVolume,
    tradesCount = tradesCount,
    trades = trades.map { it.toDomain() }
)

fun UpbitOrderWithTradesResponse.TradeResponse.toDomain() = UpbitOrderWithTrades.Trade(
    market = market,
    uuid = uuid,
    price = price,
    volume = volume,
    funds = funds,
    side = side
)

fun UpbitOrderResponse.toDomain() = UpbitOrder(
    uuid = uuid,
    side = side,
    ordType = ordType,
    price = price,
    state = state,
    market = market,
    createdAt = createdAt,
    volume = volume,
    remainingVolume = remainingVolume,
    reservedFee = reservedFee,
    remainingFee = remainingFee,
    paidFee = paidFee,
    locked = locked,
    executedVolume = executedVolume,
    tradesCount = tradesCount
)

fun UpbitOrderDeleteResponse.toDomain() = UpbitOrderDelete(
    uuid = uuid,
    side = side,
    ordType = ordType,
    price = price,
    state = state,
    market = market,
    createdAt = createdAt,
    volume = volume,
    remainingVolume = remainingVolume,
    reservedFee = reservedFee,
    remainingFee = remainingFee,
    paidFee = paidFee,
    locked = locked,
    executedVolume = executedVolume,
    tradesCount = tradesCount
)

fun UpbitOrderPostResponse.toDomain() = UpbitOrderPost(
    uuid = uuid,
    side = side,
    ordType = ordType,
    price = price,
    avgPrice = avgPrice,
    state = state,
    market = market,
    createdAt = createdAt,
    volume = volume,
    remainingVolume = remainingVolume,
    reservedFee = reservedFee,
    remainingFee = remainingFee,
    paidFee = paidFee,
    locked = locked,
    executedVolume = executedVolume,
    tradesCount = tradesCount
)
