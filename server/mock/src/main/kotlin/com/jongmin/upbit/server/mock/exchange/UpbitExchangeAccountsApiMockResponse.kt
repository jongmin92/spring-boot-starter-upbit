package com.jongmin.upbit.server.mock.exchange

val getAccountsResponse = """
    [
      {
        "currency":"KRW",
        "balance":"1000000.0",
        "locked":"0.0",
        "avg_buy_price":"0",
        "avg_buy_price_modified":false,
        "unit_currency": "KRW"
      },
      {
        "currency":"BTC",
        "balance":"2.0",
        "locked":"0.0",
        "avg_buy_price":"101000",
        "avg_buy_price_modified":false,
        "unit_currency": "KRW"
      }
    ]
""".trimIndent()
