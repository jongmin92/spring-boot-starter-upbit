package com.jongmin.upbit.client.retrofit.exchange.api.info

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitExchangeInfoProtocolTest {

    @Test
    fun `upbitWalletStatusResponse toDomain`() {
        // given
        val walletStatusResponse = upbitWalletStatusResponseFixture()

        // when
        val result = walletStatusResponse.toDomain()

        // then
        assertAll("walletStatus",
            { assertThat(result.currency).isEqualTo(walletStatusResponse.currency) },
            { assertThat(result.walletState).isEqualTo(walletStatusResponse.walletState) },
            { assertThat(result.blockState).isEqualTo(walletStatusResponse.blockState) },
            { assertThat(result.blockHeight).isEqualTo(walletStatusResponse.blockHeight) },
            { assertThat(result.blockUpdatedAt).isEqualTo(walletStatusResponse.blockUpdatedAt) }
        )
    }

    @Test
    fun `upbitApiKeyResponse toDomain`() {
        // given
        val apiKeyResponse = upbitApiKeyResponseFixture()

        // when
        val result = apiKeyResponse.toDomain()

        // then
        assertAll("apiKey",
            { assertThat(result.accessKey).isEqualTo(result.accessKey) },
            { assertThat(result.expireAt).isEqualTo(result.expireAt) }
        )
    }
}

internal fun upbitWalletStatusResponseFixture() = UpbitWalletStatusResponse(
    currency = "currency",
    walletState = "walletState",
    blockState = "blockState",
    blockHeight = 0,
    blockUpdatedAt = "blockUpdatedAt"
)

internal fun upbitApiKeyResponseFixture() = UpbitApiKeyResponse(
    accessKey = "accessKey",
    expireAt = "expireAt"
)
