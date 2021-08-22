package com.jongmin.upbit.exchange.withdraw

data class UpbitWithdraws(
    val withdraws: List<Withdraw>
) {
    data class Withdraw(
        /**
         * 설명: 입출금 종류
         * 타입: String
         */
        val type: String,

        /**
         * 설명: 출금의 고유 아이디
         * 타입: String
         */
        val uuid: String,

        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        val currency: String,

        /**
         * 설명: 출금의 트랜잭션 아이디
         * 타입: String
         */
        val txid: String,

        /**
         * 설명: 출금 상태
         * 타입: String
         */
        val state: String,

        /**
         * 설명: 출금 생성 시간
         * 타입: DateString
         */
        val createdAt: String,

        /**
         * 설명: 출금 완료 시간
         * 타입: DateString
         */
        val doneAt: String,

        /**
         * 설명: 출금 금액/수량
         * 타입: String
         */
        val amount: String,

        /**
         * 설명: 출금 수수료
         * 타입: String
         */
        val fee: String,

        /**
         * 설명: 출금 유형
         * 타입: String
         */
        val transactionType: String
    )
}
