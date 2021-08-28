package com.jongmin.upbit.exchange.order

data class UpbitOrdersChance(
    /**
     * 설명: 매수 수수료 비율
     * 타입: NumberString
     */
    val bidFee: String,

    /**
     * 설명: 매도 수수료 비율
     * 타입: NumberString
     */
    val askFee: String,

    /**
     * 설명: 마켓에 대한 정보
     * 타입: Market
     */
    val market: Market,

    /**
     * 설명: 매수 시 사용하는 화폐의 계좌 상태
     * 타입: BidAccount
     */
    val bidAccount: BidAccount,

    /**
     * 설명: 매도 시 사용하는 화폐의 계좌 상태
     * 타입: AskAccount
     */
    val askAccount: AskAccount
) {
    data class Market(
        /**
         * 설명: 마켓의 유일 키
         * 타입: String
         */
        val id: String,

        /**
         * 설명: 마켓 이름
         * 타입: String
         */
        val name: String,

        /**
         * 설명: 지원 주문 방식
         * 타입: List<String>
         */
        val orderTypes: List<String>,

        /**
         * 설명: 지원 주문 종류
         * 타입: List<String>
         */
        val orderSides: List<String>,

        /**
         * 설명: 매수 시 제약사항
         * 타입: Bid
         */
        val bid: Bid,

        /**
         * 설명: 매도 시 제약사항
         * 타입: Ask
         */
        val ask: Ask,

        /**
         * 설명: 최대 매도/매수 금액
         * 타입: NumberString
         */
        val maxTotal: String,

        /**
         * 설명: 마켓 운영 상태
         * 타입: String
         */
        val state: String
    ) {
        data class Bid(
            /**
             * 설명: 화폐를 의미하는 영문 대문자 코드
             * 타입: String
             */
            val currency: String,

            /**
             * 설명: 주문금액 단위
             * 타입: String
             */
            val priceUnit: String,

            /**
             * 설명: 최소 매도/매수 금액
             * 타입: Number
             */
            val minTotal: Int,
        )

        data class Ask(
            /**
             * 설명: 화폐를 의미하는 영문 대문자 코드
             * 타입: String
             */
            val currency: String,

            /**
             * 설명: 주문금액 단위
             * 타입: String
             */
            val priceUnit: String,

            /**
             * 설명: 최소 매도/매수 금액
             * 타입: Number
             */
            val minTotal: Int,
        )
    }

    data class BidAccount(
        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        val currency: String,

        /**
         * 설명: 주문가능 금액/수량
         * 타입: NumberString
         */
        val balance: String,

        /**
         * 설명: 주문 중 묶여있는 금액/수량
         * 타입: NumberString
         */
        val locked: String,

        /**
         * 설명: 매수평균가
         * 타입: NumberString
         */
        val avgBuyPrice: String,

        /**
         * 설명: 매수평균가 수정 여부
         * 타입: Boolean
         */
        val avgBuyPriceModified: Boolean,

        /**
         * 설명: 평단가 기준 화폐
         * 타입: String
         */
        val unitCurrency: String
    )

    data class AskAccount(
        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        val currency: String,

        /**
         * 설명: 주문가능 금액/수량
         * 타입: NumberString
         */
        val balance: String,

        /**
         * 설명: 주문 중 묶여있는 금액/수량
         * 타입: NumberString
         */
        val locked: String,

        /**
         * 설명: 매수평균가
         * 타입: NumberString
         */
        val avgBuyPrice: String,

        /**
         * 설명: 매수평균가 수정 여부
         * 타입: Boolean
         */
        val avgBuyPriceModified: Boolean,

        /**
         * 설명: 평단가 기준 화폐
         * 타입: String
         */
        val unitCurrency: String
    )
}

data class UpbitOrder(
    /**
     * 설명: 주문의 고유 아이디
     * 타입: String
     */
    val uuid: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    val side: String,

    /**
     * 설명: 주문 방식
     * 타입: String
     */
    val ordType: String,

    /**
     * 설명: 주문 당시 화폐 가격
     * 타입: NumberString
     */
    val price: String,

    /**
     * 설명: 주문 상태
     * 타입: String
     */
    val state: String,

    /**
     * 설명: 마켓의 유일키
     * 타입: String
     */
    val market: String,

    /**
     * 설명: 주문 생성 시간
     * 타입: DateString
     */
    val createdAt: String,

    /**
     * 설명: 사용자가 입력한 주문 양
     * 타입: NumberString
     */
    val volume: String,

    /**
     * 설명: 체결 후 남은 주문 양
     * 타입: NumberString
     */
    val remainingVolume: String,

    /**
     * 설명: 수수료로 예약된 비용
     * 타입: NumberString
     */
    val reservedFee: String,

    /**
     * 설명: 남은 수수료
     * 타입: NumberString
     */
    val remainingFee: String,

    /**
     * 설명: 사용된 수수료
     * 타입: NumberString
     */
    val paidFee: String,

    /**
     * 설명: 거래에 사용중인 비용
     * 타입: NumberString
     */
    val locked: String,

    /**
     * 설명: 체결된 양
     * 타입: NumberString
     */
    val executedVolume: String,

    /**
     * 설명: 해당 주문에 걸린 체결 수
     * 타입: NumberString
     */
    val tradeCount: Int,

    /**
     * 설명: 체결
     * 타입: List<Trade>
     */
    val trades: List<Trade>
) {
    data class Trade(
        /**
         * 설명: 마켓의 유일 키
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 체결의 고유 아이디
         * 타입: String
         */
        val uuid: String,

        /**
         * 설명: 체결 가격
         * 타입: NumberString
         */
        val price: String,

        /**
         * 설명: 체결 양
         * 타입: NumberString
         */
        val volume: String,

        /**
         * 설명: 체결된 총 가격
         * 타입: NumberString
         */
        val funds: String,

        /**
         * 설명: 체결 종류
         * 타입: String
         */
        val side: String,

        /**
         * 설명: 체결 시각
         * 타입: DateString
         */
        val createdAt: String
    )
}

data class UpbitOrders(
    val orders: List<Order>
) {
    data class Order(
        /**
         * 설명: 주문의 고유 아이디
         * 타입: String
         */
        val uuid: String,

        /**
         * 설명: 주문 종류
         * 타입: String
         */
        val side: String,

        /**
         * 설명: 주문 방식
         * 타입: String
         */
        val ordType: String,

        /**
         * 설명: 주문 당시 화폐 가격
         * 타입: NumberString
         */
        val price: String,

        /**
         * 설명: 주문 상태
         * 타입: String
         */
        val state: String,

        /**
         * 설명: 마켓의 유일키
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 주문 생성 시간
         * 타입: DateString
         */
        val createdAt: String,

        /**
         * 설명: 사용자가 입력한 주문 양
         * 타입: NumberString
         */
        val volume: String,

        /**
         * 설명: 체결 후 남은 주문 양
         * 타입: NumberString
         */
        val remainingVolume: String,

        /**
         * 설명: 수수료로 예약된 비용
         * 타입: NumberString
         */
        val reservedFee: String,

        /**
         * 설명: 남은 수수료
         * 타입: NumberString
         */
        val remainingFee: String,

        /**
         * 설명: 사용된 수수료
         * 타입: NumberString
         */
        val paidFee: String,

        /**
         * 설명: 거래에 사용중인 비용
         * 타입: NumberString
         */
        val locked: String,

        /**
         * 설명: 체결된 양
         * 타입: NumberString
         */
        val executedVolume: String,

        /**
         * 설명: 해당 주문에 걸린 체결 수
         * 타입: NumberString
         */
        val tradeCount: Int
    )
}

data class UpbitOrderDelete(
    /**
     * 설명: 주문의 고유 아이디
     * 타입: String
     */
    val uuid: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    val side: String,

    /**
     * 설명: 주문 방식
     * 타입: String
     */
    val ordType: String,

    /**
     * 설명: 주문 당시 화폐 가격
     * 타입: NumberString
     */
    val price: String,

    /**
     * 설명: 주문 상태
     * 타입: String
     */
    val state: String,

    /**
     * 설명: 마켓의 유일키
     * 타입: String
     */
    val market: String,

    /**
     * 설명: 주문 생성 시간
     * 타입: DateString
     */
    val createdAt: String,

    /**
     * 설명: 사용자가 입력한 주문 양
     * 타입: NumberString
     */
    val volume: String,

    /**
     * 설명: 체결 후 남은 주문 양
     * 타입: NumberString
     */
    val remainingVolume: String,

    /**
     * 설명: 수수료로 예약된 비용
     * 타입: NumberString
     */
    val reservedFee: String,

    /**
     * 설명: 남은 수수료
     * 타입: NumberString
     */
    val remainingFee: String,

    /**
     * 설명: 사용된 수수료
     * 타입: NumberString
     */
    val paidFee: String,

    /**
     * 설명: 거래에 사용중인 비용
     * 타입: NumberString
     */
    val locked: String,

    /**
     * 설명: 체결된 양
     * 타입: NumberString
     */
    val executedVolume: String,

    /**
     * 설명: 해당 주문에 걸린 체결 수
     * 타입: NumberString
     */
    val tradeCount: Int
)

data class UpbitOrderPost(
    /**
     * 설명: 주문의 고유 아이디
     * 타입: String
     */
    val uuid: String,

    /**
     * 설명: 주문 종류
     * 타입: String
     */
    val side: String,

    /**
     * 설명: 주문 방식
     * 타입: String
     */
    val ordType: String,

    /**
     * 설명: 주문 당시 화폐 가격
     * 타입: NumberString
     */
    val price: String,

    /**
     * 설명: 주문 상태
     * 타입: String
     */
    val state: String,

    /**
     * 설명: 마켓의 유일키
     * 타입: String
     */
    val market: String,

    /**
     * 설명: 주문 생성 시간
     * 타입: DateString
     */
    val createdAt: String,

    /**
     * 설명: 사용자가 입력한 주문 양
     * 타입: NumberString
     */
    val volume: String,

    /**
     * 설명: 체결 후 남은 주문 양
     * 타입: NumberString
     */
    val remainingVolume: String,

    /**
     * 설명: 수수료로 예약된 비용
     * 타입: NumberString
     */
    val reservedFee: String,

    /**
     * 설명: 남은 수수료
     * 타입: NumberString
     */
    val remainingFee: String,

    /**
     * 설명: 사용된 수수료
     * 타입: NumberString
     */
    val paidFee: String,

    /**
     * 설명: 거래에 사용중인 비용
     * 타입: NumberString
     */
    val locked: String,

    /**
     * 설명: 체결된 양
     * 타입: NumberString
     */
    val executedVolume: String,

    /**
     * 설명: 해당 주문에 걸린 체결 수
     * 타입: NumberString
     */
    val tradeCount: Int
)
