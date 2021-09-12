package com.jongmin.upbit.exchange.withdraw

data class UpbitWithdraw(
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
    val txid: String?,

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
    val doneAt: String?,

    /**
     * 설명: 출금 금액/수량
     * 타입: NumberString
     */
    val amount: String,

    /**
     * 설명: 출금 수수료
     * 타입: NumberString
     */
    val fee: String,

    /**
     * 설명: 출금 유형
     * 타입: String
     */
    val transactionType: String
)

data class UpbitWithdrawsChance(
    /**
     * 설명: 사용자의 보안등급 정보
     * 타입: MemberLevel
     */
    val memberLevel: MemberLevel,

    /**
     * 설명: 화폐 정보
     * 타입: Currency
     */
    val currency: Currency,

    /**
     * 설명: 사용자의 계좌 정보
     * 타입: Account
     */
    val account: Account,

    /**
     * 설명: 출금 제약 정보
     * 타입: WithdrawLimit
     */
    val withdrawLimit: WithdrawLimit
) {
    data class MemberLevel(
        /**
         * 설명: 사용자의 보안등급
         * 타입: Integer
         */
        val securityLevel: Int,

        /**
         * 설명: 사용자의 수수료등급
         * 타입: Integer
         */
        val feeLevel: Int,

        /**
         * 설명: 사용자의 이메일 인증 여부
         * 타입: Boolean
         */
        val emailVerified: Boolean,

        /**
         * 설명: 사용자의 실명 인증 여부
         * 타입: Boolean
         */
        val identityAuthVerified: Boolean,

        /**
         * 설명: 사용자의 계좌 인증 여부
         * 타입: Boolean
         */
        val bankAccountVerified: Boolean,

        /**
         * 설명: 사용자의 카카오페이 인증 여부
         * 타입: Boolean
         */
        val kakaoPayAuthVerified: Boolean,

        /**
         * 설명: 사용자의 계정 보호 상태
         * 타입: Boolean
         */
        val locked: Boolean,

        /**
         * 설명: 사용자의 출금 보호 상태
         * 타입: Boolean
         */
        val walletLocked: Boolean
    )

    data class Currency(
        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        val code: String,

        /**
         * 설명: 해당 화폐의 출금 수수료
         * 타입: NumberString
         */
        val withdrawFee: String,

        /**
         * 설명: 화폐의 코인 여부
         * 타입: Boolean
         */
        val isCoin: Boolean,

        /**
         * 설명: 해당 화폐의 지갑 상태
         * 타입: String
         */
        val walletState: String,

        /**
         * 설명: 해당 화폐가 지원하는 입출금 정보
         * 타입: List<String>
         */
        val walletSupport: List<String>
    )

    data class Account(
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

    data class WithdrawLimit(
        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        val currency: String,

        /**
         * 설명: 출금 최소 금액/수량
         * 타입: NumberString
         */
        val minimum: String?,

        /**
         * 설명: 1회 출금 한도
         * 타입: NumberString
         */
        val onetime: String?,

        /**
         * 설명: 1일 출금 한도
         * 타입: NumberString
         */
        val daily: String,

        /**
         * 설명: 1일 잔여 출금 한도
         * 타입: NumberString
         */
        val remainingDaily: String,

        /**
         * 설명: 통합 1일 잔여 출금 한도
         * 타입: NumberString
         */
        val remainingDailyKrw: String,

        /**
         * 설명: 출금 금액/수량 소수점 자리 수
         * 타입: Integer
         */
        val fixed: Int?,

        /**
         * 설명: 출금 지원 여부
         * 타입: Boolean
         */
        val canWithdraw: Boolean
    )
}

data class UpbitWithdrawCoinPost(
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
    val doneAt: String?,

    /**
     * 설명: 출금 금액/수량
     * 타입: NumberString
     */
    val amount: String,

    /**
     * 설명: 출금 수수료
     * 타입: NumberString
     */
    val fee: String,

    /**
     * 설명: 원화 환산 가격
     * 타입: NumberString
     */
    val krwAmount: String,

    /**
     * 설명: 출금 유형
     * 타입: String
     */
    val transactionType: String
)

data class UpbitWithdrawKrwPost(
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
     * 타입: NumberString
     */
    val amount: String,

    /**
     * 설명: 출금 수수료
     * 타입: NumberString
     */
    val fee: String,

    /**
     * 설명: 출금 유형
     * 타입: String
     */
    val transactionType: String
)
