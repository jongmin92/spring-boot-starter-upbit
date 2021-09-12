package com.jongmin.upbit.client.retrofit.exchange.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.exchange.withdraw.UpbitWithdraw
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawCoinPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawKrwPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawsChance

data class UpbitWithdrawResponse(
    /**
     * 설명: 입출금 종류
     * 타입: String
     */
    @JsonProperty("type")
    val type: String,

    /**
     * 설명: 출금의 고유 아이디
     * 타입: String
     */
    @JsonProperty("uuid")
    val uuid: String,

    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    @JsonProperty("currency")
    val currency: String,

    /**
     * 설명: 출금의 트랜잭션 아이디
     * 타입: String
     */
    @JsonProperty("txid")
    val txid: String?,

    /**
     * 설명: 출금 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 출금 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 출금 완료 시간
     * 타입: DateString
     */
    @JsonProperty("done_at")
    val doneAt: String?,

    /**
     * 설명: 출금 금액/수량
     * 타입: NumberString
     */
    @JsonProperty("amount")
    val amount: String,

    /**
     * 설명: 출금 수수료
     * 타입: NumberString
     */
    @JsonProperty("fee")
    val fee: String,

    /**
     * 설명: 출금 유형
     * 타입: String
     */
    @JsonProperty("transaction_type")
    val transactionType: String
)

data class UpbitWithdrawsChanceResponse(
    /**
     * 설명: 사용자의 보안등급 정보
     * 타입: MemberLevel
     */
    @JsonProperty("member_level")
    val memberLevel: MemberLevelResponse,

    /**
     * 설명: 화폐 정보
     * 타입: Currency
     */
    @JsonProperty("currency")
    val currency: CurrencyResponse,

    /**
     * 설명: 사용자의 계좌 정보
     * 타입: Account
     */
    @JsonProperty("account")
    val account: AccountResponse,

    /**
     * 설명: 출금 제약 정보
     * 타입: WithdrawLimit
     */
    @JsonProperty("withdraw_limit")
    val withdrawLimit: WithdrawLimitResponse
) {
    data class MemberLevelResponse(
        /**
         * 설명: 사용자의 보안등급
         * 타입: Integer
         */
        @JsonProperty("security_level")
        val securityLevel: Int,

        /**
         * 설명: 사용자의 수수료등급
         * 타입: Integer
         */
        @JsonProperty("fee_level")
        val feeLevel: Int,

        /**
         * 설명: 사용자의 이메일 인증 여부
         * 타입: Boolean
         */
        @JsonProperty("email_verified")
        val emailVerified: Boolean,

        /**
         * 설명: 사용자의 실명 인증 여부
         * 타입: Boolean
         */
        @JsonProperty("identity_auth_verified")
        val identityAuthVerified: Boolean,

        /**
         * 설명: 사용자의 계좌 인증 여부
         * 타입: Boolean
         */
        @JsonProperty("bank_account_verified")
        val bankAccountVerified: Boolean,

        /**
         * 설명: 사용자의 카카오페이 인증 여부
         * 타입: Boolean
         */
        @JsonProperty("kakao_pay_auth_verified")
        val kakaoPayAuthVerified: Boolean,

        /**
         * 설명: 사용자의 계정 보호 상태
         * 타입: Boolean
         */
        @JsonProperty("locked")
        val locked: Boolean,

        /**
         * 설명: 사용자의 출금 보호 상태
         * 타입: Boolean
         */
        @JsonProperty("wallet_locked")
        val walletLocked: Boolean
    )

    data class CurrencyResponse(
        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        @JsonProperty("code")
        val code: String,

        /**
         * 설명: 해당 화폐의 출금 수수료
         * 타입: NumberString
         */
        @JsonProperty("withdraw_fee")
        val withdrawFee: String,

        /**
         * 설명: 화폐의 코인 여부
         * 타입: Boolean
         */
        @JsonProperty("is_coin")
        val isCoin: Boolean,

        /**
         * 설명: 해당 화폐의 지갑 상태
         * 타입: String
         */
        @JsonProperty("wallet_state")
        val walletState: String,

        /**
         * 설명: 해당 화폐가 지원하는 입출금 정보
         * 타입: List<String>
         */
        @JsonProperty("wallet_support")
        val walletSupport: List<String>
    )

    data class AccountResponse(
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

    data class WithdrawLimitResponse(
        /**
         * 설명: 화폐를 의미하는 영문 대문자 코드
         * 타입: String
         */
        @JsonProperty("currency")
        val currency: String,

        /**
         * 설명: 출금 최소 금액/수량
         * 타입: NumberString
         */
        @JsonProperty("minimum")
        val minimum: String?,

        /**
         * 설명: 1회 출금 한도
         * 타입: NumberString
         */
        @JsonProperty("onetime")
        val onetime: String?,

        /**
         * 설명: 1일 출금 한도
         * 타입: NumberString
         */
        @JsonProperty("daily")
        val daily: String,

        /**
         * 설명: 1일 잔여 출금 한도
         * 타입: NumberString
         */
        @JsonProperty("remaining_daily")
        val remainingDaily: String,

        /**
         * 설명: 통합 1일 잔여 출금 한도
         * 타입: NumberString
         */
        @JsonProperty("remaining_daily_krw")
        val remainingDailyKrw: String,

        /**
         * 설명: 출금 금액/수량 소수점 자리 수
         * 타입: Integer
         */
        @JsonProperty("fixed")
        val fixed: Int?,

        /**
         * 설명: 출금 지원 여부
         * 타입: Boolean
         */
        @JsonProperty("can_withdraw")
        val canWithdraw: Boolean
    )
}

data class UpbitWithdrawCoinPostRequest(
    /**
     * 설명: Currency symbol
     * 타입: String
     */
    @JsonProperty("currency")
    val currency: String,

    /**
     * 설명: 출금 코인 수량
     * 타입: String
     */
    @JsonProperty("amount")
    val amount: String,

    /**
     * 설명: 출금 지갑 주소
     * 타입: String
     */
    @JsonProperty("address")
    val address: String,

    /**
     * 설명: 2차 출금주소 (필요한 코인에 한해서)
     * 타입: String
     */
    @JsonProperty("secondary_address")
    val secondaryAddress: String?,

    /**
     * 설명: 출금 유형
     * 타입: String
     */
    @JsonProperty("transaction_type")
    val transactionType: String? = "default"
)

data class UpbitWithdrawCoinPostResponse(
    /**
     * 설명: 입출금 종류
     * 타입: String
     */
    @JsonProperty("type")
    val type: String,

    /**
     * 설명: 출금의 고유 아이디
     * 타입: String
     */
    @JsonProperty("uuid")
    val uuid: String,

    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    @JsonProperty("currency")
    val currency: String,

    /**
     * 설명: 출금의 트랜잭션 아이디
     * 타입: String
     */
    @JsonProperty("txid")
    val txid: String,

    /**
     * 설명: 출금 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 출금 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 출금 완료 시간
     * 타입: DateString
     */
    @JsonProperty("done_at")
    val doneAt: String,

    /**
     * 설명: 출금 금액/수량
     * 타입: NumberString
     */
    @JsonProperty("amount")
    val amount: String,

    /**
     * 설명: 출금 수수료
     * 타입: NumberString
     */
    @JsonProperty("fee")
    val fee: String,

    /**
     * 설명: 원화 환산 가격
     * 타입: NumberString
     */
    @JsonProperty("krw_amount")
    val krwAmount: String,

    /**
     * 설명: 출금 유형
     * 타입: String
     */
    @JsonProperty("transaction_type")
    val transactionType: String
)

data class UpbitWithdrawKrwPostRequest(
    /**
     * 설명: 출금 원화 수량
     * 타입: String
     */
    @JsonProperty("amount")
    val amount: String
)

data class UpbitWithdrawKrwPostResponse(
    /**
     * 설명: 입출금 종류
     * 타입: String
     */
    @JsonProperty("type")
    val type: String,

    /**
     * 설명: 출금의 고유 아이디
     * 타입: String
     */
    @JsonProperty("uuid")
    val uuid: String,

    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    @JsonProperty("currency")
    val currency: String,

    /**
     * 설명: 출금의 트랜잭션 아이디
     * 타입: String
     */
    @JsonProperty("txid")
    val txid: String,

    /**
     * 설명: 출금 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 출금 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 출금 완료 시간
     * 타입: DateString
     */
    @JsonProperty("done_at")
    val doneAt: String,

    /**
     * 설명: 출금 금액/수량
     * 타입: NumberString
     */
    @JsonProperty("amount")
    val amount: String,

    /**
     * 설명: 출금 수수료
     * 타입: NumberString
     */
    @JsonProperty("fee")
    val fee: String,

    /**
     * 설명: 출금 유형
     * 타입: String
     */
    @JsonProperty("transaction_type")
    val transactionType: String
)

fun UpbitWithdrawResponse.toDomain() = UpbitWithdraw(
    type = type,
    uuid = uuid,
    currency = currency,
    txid = txid,
    state = state,
    createdAt = createdAt,
    doneAt = doneAt,
    amount = amount,
    fee = fee,
    transactionType = transactionType
)

fun UpbitWithdrawsChanceResponse.toDomain() = UpbitWithdrawsChance(
    memberLevel = memberLevel.toDomain(),
    currency = currency.toDomain(),
    account = account.toDomain(),
    withdrawLimit = withdrawLimit.toDomain()
)

fun UpbitWithdrawsChanceResponse.MemberLevelResponse.toDomain() = UpbitWithdrawsChance.MemberLevel(
    securityLevel = securityLevel,
    feeLevel = feeLevel,
    emailVerified = emailVerified,
    identityAuthVerified = identityAuthVerified,
    bankAccountVerified = bankAccountVerified,
    kakaoPayAuthVerified = kakaoPayAuthVerified,
    locked = locked,
    walletLocked = walletLocked
)

fun UpbitWithdrawsChanceResponse.CurrencyResponse.toDomain() = UpbitWithdrawsChance.Currency(
    code = code,
    withdrawFee = withdrawFee,
    isCoin = isCoin,
    walletState = walletState,
    walletSupport = walletSupport
)

fun UpbitWithdrawsChanceResponse.AccountResponse.toDomain() = UpbitWithdrawsChance.Account(
    currency = currency,
    balance = balance,
    locked = locked,
    avgBuyPrice = avgBuyPrice,
    avgBuyPriceModified = avgBuyPriceModified,
    unitCurrency = unitCurrency
)

fun UpbitWithdrawsChanceResponse.WithdrawLimitResponse.toDomain() = UpbitWithdrawsChance.WithdrawLimit(
    currency = currency,
    minimum = minimum,
    onetime = onetime,
    daily = daily,
    remainingDaily = remainingDaily,
    remainingDailyKrw = remainingDailyKrw,
    fixed = fixed,
    canWithdraw = canWithdraw
)

fun UpbitWithdrawCoinPostResponse.toDomain() = UpbitWithdrawCoinPost(
    type = type,
    uuid = uuid,
    currency = currency,
    txid = txid,
    state = state,
    createdAt = createdAt,
    doneAt = doneAt,
    amount = amount,
    fee = fee,
    krwAmount = krwAmount,
    transactionType = transactionType
)

fun UpbitWithdrawKrwPostResponse.toDomain() = UpbitWithdrawKrwPost(
    type = type,
    uuid = uuid,
    currency = currency,
    txid = txid,
    state = state,
    createdAt = createdAt,
    doneAt = doneAt,
    amount = amount,
    fee = fee,
    transactionType = transactionType
)
