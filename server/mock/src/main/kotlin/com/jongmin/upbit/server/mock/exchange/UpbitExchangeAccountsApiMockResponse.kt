package com.jongmin.upbit.server.mock.exchange

object GetAccountsResponse {
    const val currency1 = "KRW"
    const val balance1 = "1000000.0"
    const val locked1 = "0.0"
    const val avgBuyPrice1 = "0"
    const val avgBuyPriceModified1 = false
    const val unitCurrency1 = "KRW"

    const val currency2 = "BTC"
    const val balance2 = "2.0"
    const val locked2 = "0.0"
    const val avgBuyPrice2 = "101000"
    const val avgBuyPriceModified2 = false
    const val unitCurrency2 = "KRW"

    val fixture = """
        [
          {
            "currency":"$currency1",
            "balance":"$balance1",
            "locked":"$locked1",
            "avg_buy_price":"$avgBuyPrice1",
            "avg_buy_price_modified":$avgBuyPriceModified1,
            "unit_currency":"$unitCurrency1"
          },
          {
            "currency":"$currency2",
            "balance":"$balance2",
            "locked":"$locked2",
            "avg_buy_price":"$avgBuyPrice2",
            "avg_buy_price_modified":$avgBuyPriceModified2,
            "unit_currency":"$unitCurrency2"
          }
        ]
    """.trimIndent()
}
