package com.jongmin.upbit.server.mock.exchange.info

object GetWalletStatusResponse {
    const val currency = "BTC"
    const val walletState = "working"
    const val blockState = "normal"
    const val blockHeight = 637432
    const val blockUpdatedAt = "2020-07-03T02:04:45.523+00:00"

    val fixture = """
        [
          {
            "currency": "$currency",
            "wallet_state": "$walletState",
            "block_state": "$blockState",
            "block_height": $blockHeight,
            "block_updated_at": "$blockUpdatedAt"
          }
        ]
    """.trimIndent()
}
