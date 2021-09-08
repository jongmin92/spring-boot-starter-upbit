package com.jongmin.upbit.server.mock.exchange.order

object GetOrdersChanceResponse {
    const val bidFee = "0.0015"
    const val askFee = "0.0015"
    const val marketId = "KRW-BTC"
    const val marketName = "BTC/KRW"
    const val marketOrderType1 = "limit"
    const val marketOrderSide1 = "ask"
    const val marketOrderSide2 = "ask"
    const val marketBidCurrency = "KRW"
    val marketBidPriceUnit = null
    const val marketBidMinTotal = 1000
    const val marketAskCurrency = "BTC"
    val marketAskPriceUnit = null
    const val marketAskMinTotal = 1000
    const val maxTotal = "100000000.0"
    const val state = "active"
    const val bidAccountCurrency = "KRW"
    const val bidAccountBalance = "0.0"
    const val bidAccountLocked = "0.0"
    const val bidAccountAvgBuyPrice = "0"
    const val bidAccountAvgBuyPriceModified = false
    const val bidAccountUnitCurrency = "KRW"
    const val askAccountCurrency = "BTC"
    const val askAccountBalance = "10.0"
    const val askAccountLocked = "0.0"
    const val askAccountAvgBuyPrice = "8042000"
    const val askAccountAvgBuyPriceModified = false
    const val askAccountUnitCurrency = "KRW"

    val fixture = """
        {
          "bid_fee": "$bidFee",
          "ask_fee": "$askFee",
          "market": {
            "id": "$marketId",
            "name": "$marketName",
            "order_types": [
              "$marketOrderType1"
            ],
            "order_sides": [
              "$marketOrderSide1",
              "$marketOrderSide2"
            ],
            "bid": {
              "currency": "$marketBidCurrency",
              "price_unit": $marketBidPriceUnit,
              "min_total": $marketBidMinTotal
            },
            "ask": {
              "currency": "$marketAskCurrency",
              "price_unit": $marketAskPriceUnit,
              "min_total": $marketAskMinTotal
            },
            "max_total": "$maxTotal",
            "state": "$state"
          },
          "bid_account": {
            "currency": "$bidAccountCurrency",
            "balance": "$bidAccountBalance",
            "locked": "$bidAccountLocked",
            "avg_buy_price": "$bidAccountAvgBuyPrice",
            "avg_buy_price_modified": $bidAccountAvgBuyPriceModified,
            "unit_currency": "$bidAccountUnitCurrency"
          },
          "ask_account": {
            "currency": "$askAccountCurrency",
            "balance": "$askAccountBalance",
            "locked": "$askAccountLocked",
            "avg_buy_price": "$askAccountAvgBuyPrice",
            "avg_buy_price_modified": $askAccountAvgBuyPriceModified,
            "unit_currency": "$askAccountUnitCurrency"
          }
        }
    """.trimIndent()
}
