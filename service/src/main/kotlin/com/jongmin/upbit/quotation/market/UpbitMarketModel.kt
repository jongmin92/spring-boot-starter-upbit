package com.jongmin.upbit.quotation.market

data class UpbitMarkets(
    val data: List<UpbitMarket>
) {
    data class UpbitMarket(

        /**
         * 설명: 업비트에서 제공중인 시장 정보 (마켓명)
         * 타입: String
         */
        val market: String,

        /**
         * 설명: 거래 대상 암호화폐 한글명
         * 타입: String
         */

        val koreanName: String,
        /**
         * 설명: 거래 대상 암호화폐 영문명
         * 타입: String
         */

        val englishName: String,
        /**
         * 설명: 유의 종목 여부
         * 타입: NONE(해당 사항 없음), CAUTION(투자유의)
         */

        val marketWarning: MarketWarning
    )

}

enum class MarketWarning(val str: String) {
    NONE("NONE"), CAUTION("CAUTION")
}