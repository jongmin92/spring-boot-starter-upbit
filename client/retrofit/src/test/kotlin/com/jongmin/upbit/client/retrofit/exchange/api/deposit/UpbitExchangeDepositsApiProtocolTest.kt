package com.jongmin.upbit.client.retrofit.exchange.api.deposit

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitExchangeDepositsApiProtocolTest {

    @Test
    fun `upbitDepositResponse toDomain`() {
        // given
        val depositResponse = upbitDepositResponseFixture()

        // when
        val result = depositResponse.toDomain()

        // then
        assertAll("deposit",
            { assertThat(result.type).isEqualTo(depositResponse.type) },
            { assertThat(result.uuid).isEqualTo(depositResponse.uuid) },
            { assertThat(result.currency).isEqualTo(depositResponse.currency) },
            { assertThat(result.txid).isEqualTo(depositResponse.txid) },
            { assertThat(result.state).isEqualTo(depositResponse.state) },
            { assertThat(result.createdAt).isEqualTo(depositResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(depositResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(depositResponse.amount) },
            { assertThat(result.fee).isEqualTo(depositResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(depositResponse.transactionType) }
        )
    }

    @Test
    fun `upbitCreateDepositCoinAddressResponse toDomain`() {
        // given
        val createDepositCoinAddressResponse = upbitCreateDepositCoinAddressResponseFixture()

        // when
        val result = createDepositCoinAddressResponse.toDomain()

        // then
        assertAll("createDepositCoinAddress",
            { assertThat(result.success).isEqualTo(createDepositCoinAddressResponse.success) },
            { assertThat(result.message).isEqualTo(createDepositCoinAddressResponse.message) },
            { assertThat(result.currency).isEqualTo(createDepositCoinAddressResponse.currency) },
            { assertThat(result.depositAddress).isEqualTo(createDepositCoinAddressResponse.depositAddress) },
            { assertThat(result.secondaryAddress).isEqualTo(createDepositCoinAddressResponse.secondaryAddress) }
        )
    }

    @Test
    fun `upbitDepositCoinAddressResponse toDomain`() {
        // given
        val depositCoinAddressResponse = upbitDepositCoinAddressResponseFixture()

        // when
        val result = depositCoinAddressResponse.toDomain()

        // then
        assertAll("depositCoinAddress",
            { assertThat(result.currency).isEqualTo(depositCoinAddressResponse.currency) },
            { assertThat(result.depositAddress).isEqualTo(depositCoinAddressResponse.depositAddress) },
            { assertThat(result.secondaryAddress).isEqualTo(depositCoinAddressResponse.secondaryAddress) }
        )
    }

    @Test
    fun `upbitDepositKrwResponse toDomain`() {
        // given
        val depositKrwResponse = upbitDepositKrwResponseFixture()

        // when
        val result = depositKrwResponse.toDomain()

        // then
        assertAll("depositKrwResponse",
            { assertThat(result.type).isEqualTo(depositKrwResponse.type) },
            { assertThat(result.uuid).isEqualTo(depositKrwResponse.uuid) },
            { assertThat(result.currency).isEqualTo(depositKrwResponse.currency) },
            { assertThat(result.txid).isEqualTo(depositKrwResponse.txid) },
            { assertThat(result.state).isEqualTo(depositKrwResponse.state) },
            { assertThat(result.createdAt).isEqualTo(depositKrwResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(depositKrwResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(depositKrwResponse.amount) },
            { assertThat(result.fee).isEqualTo(depositKrwResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(depositKrwResponse.transactionType) }
        )
    }
}

internal fun upbitDepositResponseFixture() = UpbitDepositResponse(
    type = "type",
    uuid = "uuid",
    currency = "currency",
    txid = "txid",
    state = "state",
    createdAt = "createdAt",
    doneAt = "doneAt",
    amount = "amount",
    fee = "fee",
    transactionType = "transactionType"
)

internal fun upbitCreateDepositCoinAddressResponseFixture() = UpbitCreateDepositCoinAddressResponse(
    success = true,
    message = "message",
    currency = "currency",
    depositAddress = "depositAddress",
    secondaryAddress = "secondaryAddress"
)

internal fun upbitDepositCoinAddressResponseFixture() = UpbitDepositCoinAddressResponse(
    currency = "currency",
    depositAddress = "depositAddress",
    secondaryAddress = "secondaryAddress"
)

internal fun upbitDepositKrwResponseFixture() = UpbitDepositKrwResponse(
    type = "type",
    uuid = "uuid",
    currency = "currency",
    txid = "txid",
    state = "state",
    createdAt = "createdAt",
    doneAt = "doneAt",
    amount = "amount",
    fee = "fee",
    transactionType = "transactionType"
)
