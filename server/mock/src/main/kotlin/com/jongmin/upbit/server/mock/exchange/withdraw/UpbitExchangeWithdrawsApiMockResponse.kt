package com.jongmin.upbit.server.mock.exchange.withdraw

object GetWithdrawsResponse {
    const val type = "withdraws"
    const val uuid = "35a4f1dc-1db5-4d6b-89b5-7ec137875956"
    const val currency = "XRP"
    const val txid = "98c15999f0bdc4ae0e8a-ed35868bb0c204fe6ec29e4058a3451e-88636d1040f4baddf943274ce37cf9cc"
    const val state = "DONE"
    const val createdAt = "2019-02-28T15:17:51+09:00"
    const val doneAt = "2019-02-28T15:22:12+09:00"
    const val amount = "1.00"
    const val fee = "0.0"
    const val transactionType = "default"

    val fixture = """
        [
          {
            "type": "$type",
            "uuid": "$uuid",
            "currency": "$currency",
            "txid": "$txid",
            "state": "$state",
            "created_at": "$createdAt",
            "done_at": "$doneAt",
            "amount": "$amount",
            "fee": "$fee",
            "transaction_type": "$transactionType"
          }
        ]
    """.trimIndent()
}

object GetWithdrawResponse {
    const val type = "withdraws"
    const val uuid = "9f432943-54e0-40b7-825f-b6fec8b42b79"
    const val currency = "BTC"
    val txid = null
    const val state = "processing"
    const val createdAt = "2018-04-13T11:24:01+09:00"
    val doneAt = null
    const val amount = "0.01"
    const val fee = "0.0"
    const val transactionType = "default"

    val fixture = """
        {
          "type": "$type",
          "uuid": "$uuid",
          "currency": "$currency",
          "txid": $txid,
          "state": "$state",
          "created_at": "$createdAt",
          "done_at": $doneAt,
          "amount": "$amount",
          "fee": "$fee",
          "transaction_type": "$transactionType"
        }
    """.trimIndent()
}
