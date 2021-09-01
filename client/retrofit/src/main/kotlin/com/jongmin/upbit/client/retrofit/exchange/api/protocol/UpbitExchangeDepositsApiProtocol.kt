package com.jongmin.upbit.client.retrofit.exchange.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.exchange.deposit.UpbitCreateDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDeposit
import com.jongmin.upbit.exchange.deposit.UpbitDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDepositKrw

data class UpbitDepositResponse(
    /**
     * 설명: 입출금 종류
     * 타입: String
     */
    @JsonProperty("type")
    val type: String,

    /**
     * 설명: 입금에 대한 고유 아이디
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
     * 설명: 입금의 트랜잭션 아이디
     * 타입: String
     */
    @JsonProperty("txid")
    val txid: String,

    /**
     * 설명: 입금 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 입금 생성 시간
     * 타입: DateString
     */
    @JsonProperty("createdAt")
    val createdAt: String,

    /**
     * 설명: 입금 완료 시간
     * 타입: DateString
     */
    @JsonProperty("doneAt")
    val doneAt: String,

    /**
     * 설명: 입금 수량
     * 타입: NumberString
     */
    @JsonProperty("amount")
    val amount: String,

    /**
     * 설명: 입금 수수료
     * 타입: NumberString
     */
    @JsonProperty("fee")
    val fee: String,

    /**
     * 설명: 입금 유형
     * 타입: String
     */
    @JsonProperty("transaction_type")
    val transactionType: String
)

data class UpbitCreateDepositCoinAddressResponse(
    /**
     * 설명: 요청 성공 여부
     * 타입: Boolean
     */
    @JsonProperty("success")
    val success: Boolean?,

    /**
     * 설명: 요청 결과에 대한 메세지
     * 타입: String
     */
    @JsonProperty("message")
    val message: String?,

    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    @JsonProperty("currency")
    val currency: String,

    /**
     * 설명: 입금 주소
     * 타입: String
     */
    @JsonProperty("deposit_address")
    val depositAddress: String,

    /**
     * 설명: 2차 입금 주소
     * 타입: String
     */
    @JsonProperty("secondary_address")
    val secondaryAddress: String
)

data class UpbitDepositCoinAddressResponse(
    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    @JsonProperty("currency")
    val currency: String,

    /**
     * 설명: 입금 주소
     * 타입: String
     */
    @JsonProperty("deposit_address")
    val depositAddress: String?,

    /**
     * 설명: 2차 입금 주소
     * 타입: String
     */
    @JsonProperty("secondary_address")
    val secondaryAddress: String?
)

data class UpbitDepositKrwRequest(
    /**
     * 설명: 입금액
     * 타입: String
     */
    @JsonProperty("amount")
    val amount: String
)

data class UpbitDepositKrwResponse(
    /**
     * 설명: 입출금 종류
     * 타입: String
     */
    @JsonProperty("type")
    val type: String,

    /**
     * 설명: 입금에 대한 고유 아이디
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
     * 설명: 입금의 트랜잭션 아이디
     * 타입: String
     */
    @JsonProperty("txid")
    val txid: String,

    /**
     * 설명: 입금 상태
     * 타입: String
     */
    @JsonProperty("state")
    val state: String,

    /**
     * 설명: 입금 생성 시간
     * 타입: DateString
     */
    @JsonProperty("created_at")
    val createdAt: String,

    /**
     * 설명: 입금 완료 시간
     * 타입: DateString
     */
    @JsonProperty("done_at")
    val doneAt: String,

    /**
     * 설명: 입금 금액/수량
     * 타입: NumberString
     */
    @JsonProperty("amount")
    val amount: String,

    /**
     * 설명: 입금 수수료
     * 타입: NumberString
     */
    @JsonProperty("fee")
    val fee: String,

    /**
     * 설명: 입금 유형
     * 타입: String
     */
    @JsonProperty("transaction_type")
    val transactionType: String
)

fun UpbitDepositResponse.toDomain() = UpbitDeposit(
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

fun UpbitCreateDepositCoinAddressResponse.toDomain() = UpbitCreateDepositCoinAddress(
    success = success,
    message = message,
    currency = currency,
    depositAddress = depositAddress,
    secondaryAddress = secondaryAddress
)

fun UpbitDepositCoinAddressResponse.toDomain() = UpbitDepositCoinAddress(
    currency, depositAddress, secondaryAddress
)

fun UpbitDepositKrwResponse.toDomain() = UpbitDepositKrw(
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
