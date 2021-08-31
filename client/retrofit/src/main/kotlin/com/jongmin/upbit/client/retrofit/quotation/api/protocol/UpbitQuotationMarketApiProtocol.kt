package com.jongmin.upbit.client.retrofit.quotation.api.protocol

import com.fasterxml.jackson.annotation.JsonProperty
import com.jongmin.upbit.quotation.market.MarketWarning
import com.jongmin.upbit.quotation.market.UpbitMarket

data class UpbitMarketResponse(
    /**
     * 설명: 업비트에서 제공중인 시장 정보 (마켓명)
     * 타입: String
     */
    @JsonProperty("market")
    val market: String,

    /**
     * 설명: 거래 대상 암호화폐 한글명
     * 타입: String
     */
    @JsonProperty("korean_name")
    val koreanName: String,

    /**
     * 설명: 거래 대상 암호화폐 영문명
     * 타입: String
     */
    @JsonProperty("english_name")
    val englishName: String,

    /**
     * 설명: 유의 종목 여부
     * 타입: NONE(해당 사항 없음), CAUTION(투자유의)
     */
    @JsonProperty("market_warning")
    val marketWarning: MarketWarningProtocol
)


enum class MarketWarningProtocol(val str: String) {
    NONE("NONE"), CAUTION("CAUTION")
}

fun UpbitMarketResponse.toDomain(): UpbitMarket =
    UpbitMarket(
        market,
        koreanName,
        englishName,
        marketWarning = MarketWarning.valueOf(marketWarning.name)
    )
