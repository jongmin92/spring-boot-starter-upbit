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

object GetWithdrawsChanceResponse {
    object MemberLevel {
        const val securityLevel = 3
        const val feeLevel = 0
        const val emailVerified = true
        const val identityAuthVerified = true
        const val bankAccountVerified = true
        const val kakaoPayAuthVerified = false
        const val locked = false
        const val walletLocked = false
    }

    object Currency {
        const val code = "BTC"
        const val withdrawFee = "0.0005"
        const val isCoin = true
        const val walletState = "working"
        const val walletSupport1 = "deposit"
        const val walletSupport2 = "withdraw"
    }

    object Account {
        const val currency = "BTC"
        const val balance = "10.0"
        const val locked = "0.0"
        const val avgBuyPrice = "80042000"
        const val avgBuyPriceModified = false
        const val unitCurrency = "KRW"
    }

    object WithdrawLimit {
        const val currency = "BTC"
        val minimum = null
        val onetime = null
        const val daily = "10.0"
        const val remainingDaily = "10.0"
        const val remainingDailyKrw = "0.0"
        val fixed = null
        const val canWithdraw = true
    }

    val fixture = """
        {
          "member_level": {
            "security_level": ${MemberLevel.securityLevel},
            "fee_level": ${MemberLevel.feeLevel},
            "email_verified": ${MemberLevel.emailVerified},
            "identity_auth_verified": ${MemberLevel.identityAuthVerified},
            "bank_account_verified": ${MemberLevel.bankAccountVerified},
            "kakao_pay_auth_verified": ${MemberLevel.kakaoPayAuthVerified},
            "locked": ${MemberLevel.locked},
            "wallet_locked": ${MemberLevel.walletLocked}
          },
          "currency": {
            "code": "${Currency.code}",
            "withdraw_fee": "${Currency.withdrawFee}",
            "is_coin": ${Currency.isCoin},
            "wallet_state": "${Currency.walletState}",
            "wallet_support": [
              "${Currency.walletSupport1}",
              "${Currency.walletSupport2}"
            ]
          },
          "account": {
            "currency": "${Account.currency}",
            "balance": "${Account.balance}",
            "locked": "${Account.locked}",
            "avg_buy_price": "${Account.avgBuyPrice}",
            "avg_buy_price_modified": ${Account.avgBuyPriceModified},
            "unit_currency": "${Account.unitCurrency}"
          },
          "withdraw_limit": {
            "currency": "${WithdrawLimit.currency}",
            "minimum": ${WithdrawLimit.minimum},
            "onetime": ${WithdrawLimit.onetime},
            "daily": "${WithdrawLimit.daily}",
            "remaining_daily": "${WithdrawLimit.remainingDaily}",
            "remaining_daily_krw": "${WithdrawLimit.remainingDailyKrw}",
            "fixed": ${WithdrawLimit.fixed},
            "can_withdraw": ${WithdrawLimit.canWithdraw}
          }
        }
    """.trimIndent()
}
