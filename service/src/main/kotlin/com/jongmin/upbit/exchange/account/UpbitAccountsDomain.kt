package com.jongmin.upbit.exchange.account

data class UpbitAccount(
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
