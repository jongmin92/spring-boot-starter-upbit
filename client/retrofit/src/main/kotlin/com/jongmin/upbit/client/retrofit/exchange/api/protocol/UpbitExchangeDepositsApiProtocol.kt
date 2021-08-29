package com.jongmin.upbit.client.retrofit.exchange.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.exchange.deposit.UpbitDeposit

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
