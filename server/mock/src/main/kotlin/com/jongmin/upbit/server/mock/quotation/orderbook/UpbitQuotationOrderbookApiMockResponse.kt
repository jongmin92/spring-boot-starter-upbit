package com.jongmin.upbit.server.mock.quotation.orderbook


object GetOrderbookResponse {
    const val market = "KRW-BTC"
    const val timestamp = 1_600_000L
    const val totalAskSize = 0.00
    const val totalBidSize = 0.00

    val fixture = """
        [
          {
            "market": "$market",
            "timestamp": "$timestamp",
            "total_ask_size": "$totalAskSize",
            "total_bid_size": "$totalBidSize",
            "orderbook_units": [{
              "ask_price": 0.00,
              "bid_price": 0.00,
              "ask_size": 0.00,
              "bid_size": 0.00
            }]
          }
        ]
    """.trimIndent()
}
