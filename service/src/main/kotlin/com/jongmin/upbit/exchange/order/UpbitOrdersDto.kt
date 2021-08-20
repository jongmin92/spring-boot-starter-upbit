package com.jongmin.upbit.exchange.order

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
