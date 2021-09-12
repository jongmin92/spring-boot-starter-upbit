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

object GetDepositResponse {
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
    """.trimIndent()
}

// 주소 발급 완료 이전
object PostDepositsGenerateCoinAddressResponse1 {
    const val success = true
    const val message = "BTC 입금주소를 생성중입니다."

    val fixture = """
        {
          "success": $success,
          "message": "$message"
        }
    """.trimIndent()
}

// 주소 발급 완료 이후
object PostDepositsGenerateCoinAddressResponse2 {
    const val currency = "currency"
    const val depositAddress = "deposit_address"
    const val secondaryAddress = "secondary_address"

    val fixture = """
        {
          "currency": "$currency",
          "deposit_address": "$depositAddress",
          "secondary_address": "$secondaryAddress"
        }
    """.trimIndent()
}

object GetDepositsCoinAddressesResponse {
    const val currency1 = "BTC"
    const val depositAddress1 = "3EusRwybuZUhVDeHL7gh3HSLmbhLcy7NqD"
    val secondaryAddress1 = null
    const val currency2 = "XRP"
    const val depositAddress2 = "rN9qNpgnBaZwqCg8CvUZRPqCcPPY7wfWep"
    const val secondaryAddress2 = "3057887915"

    val fixture = """
        [
          {
            "currency": "$currency1",
            "deposit_address": "$depositAddress1",
            "secondary_address": $secondaryAddress1
          },
          {
            "currency": "$currency2",
            "deposit_address": "$depositAddress2",
            "secondary_address": "$secondaryAddress2"
          }
        ]
    """.trimIndent()
}

object GetDepositsCoinAddressResponse {
    const val currency = "BTC"
    const val depositAddress = "3EusRwybuZUhVDeHL7gh3HSLmbhLcy7NqD"
    val secondaryAddress = null

    val fixture = """
        {
          "currency": "$currency",
          "deposit_address": "$depositAddress",
          "secondary_address": $secondaryAddress
        }
    """.trimIndent()
}
