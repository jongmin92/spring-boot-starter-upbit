package com.jongmin.upbit.server.mock.quotation.market

object GetMarketResponse {
    const val market = "KRW-BTC"
    const val koreanName = "비트코인"
    const val englishName = "Bitcoin"
    const val marketWarning = "NONE"

    const val market2 = "KRW-ETH"
    const val koreanName2 = "이더리움"
    const val englishName2 = "Etherium"
    const val marketWarning2 = "CAUTION"

    val fixture = """
        [
          {
            "market":"$market",
            "korean_name":"$koreanName",
            "english_name":"$englishName",
            "market_warning":"$marketWarning"
          },
          {
            "market":"$market2",
            "korean_name":"$koreanName2",
            "english_name":"$englishName2",
            "market_warning":"$marketWarning2"
          }
        ]
    """.trimIndent()
}
