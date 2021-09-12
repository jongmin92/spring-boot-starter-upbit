package com.jongmin.upbit.server.mock.exchange.deposit

object GetDepositsResponse {
    const val type = "deposit"
    const val uuid = "94332e99-3a87-4a35-ad98-28b0c969f830"
    const val currency = "KRW"
    const val txid = "9e37c537-6849-4c8b-a134-57313f5dfc5a"
    const val state = "ACCEPTED"
    const val createdAt = "2017-12-08T15:38:02+09:00"
    const val doneAt = "2017-12-08T15:38:02+09:00"
    const val amount = "100000.0"
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
