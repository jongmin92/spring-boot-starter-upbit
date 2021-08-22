package com.jongmin.upbit.exchange.deposit

data class UpbitDeposits(
    val orders: List<Deposit>
) {
    data class Deposit(
        /**
         * 설명: 입출금 종류
         * 타입: String
         */
        val type: String,

        /**
         * 설명: 입금에 대한 고유 아이디
         * 타입: String
         */
        val uuid: String,

        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        val currency: String,

        /**
         * 설명: 입금의 트랜잭션 아이디
         * 타입: String
         */
        val txid: String,

        /**
         * 설명: 입금 상태
         * 타입: String
         */
        val state: String,

        /**
         * 설명: 입금 생성 시간
         * 타입: DateString
         */
        val createdAt: String,

        /**
         * 설명: 입금 완료 시간
         * 타입: DateString
         */
        val doneAt: String,

        /**
         * 설명: 입금 수량
         * 타입: NumberString
         */
        val amount: String,

        /**
         * 설명: 입금 수수료
         * 타입: NumberString
         */
        val fee: String,

        /**
         * 설명: 입금 유형
         * 타입: String
         */
        val transactionType: String
    )
}

data class UpbitDeposit(
    /**
     * 설명: 입출금 종류
     * 타입: String
     */
    val type: String,

    /**
     * 설명: 입금에 대한 고유 아이디
     * 타입: String
     */
    val uuid: String,

    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    val currency: String,

    /**
     * 설명: 입금의 트랜잭션 아이디
     * 타입: String
     */
    val txid: String,

    /**
     * 설명: 입금 상태
     * 타입: String
     */
    val state: String,

    /**
     * 설명: 입금 생성 시간
     * 타입: DateString
     */
    val createdAt: String,

    /**
     * 설명: 입금 완료 시간
     * 타입: DateString
     */
    val doneAt: String,

    /**
     * 설명: 입금 수량
     * 타입: NumberString
     */
    val amount: String,

    /**
     * 설명: 입금 수수료
     * 타입: NumberString
     */
    val fee: String,

    /**
     * 설명: 입금 유형
     * 타입: String
     */
    val transactionType: String
)
