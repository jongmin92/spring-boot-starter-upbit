package com.jongmin.upbit.client.retrofit.exchange.api.withdraw

import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawCoinPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawKrwPostResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.UpbitWithdrawsChanceResponse
import com.jongmin.upbit.client.retrofit.exchange.api.protocol.toDomain
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class UpbitExchangeWithdrawsApiProtocolTest {

    @Test
    fun `upbitWithdrawResponse toDomain`() {
        // given
        val withdrawResponse = upbitWithdrawResponseFixture()

        // when
        val result = withdrawResponse.toDomain()

        // then
        assertAll("withdraw",
            { assertThat(result.type).isEqualTo(withdrawResponse.type) },
            { assertThat(result.uuid).isEqualTo(withdrawResponse.uuid) },
            { assertThat(result.currency).isEqualTo(withdrawResponse.currency) },
            { assertThat(result.txid).isEqualTo(withdrawResponse.txid) },
            { assertThat(result.state).isEqualTo(withdrawResponse.state) },
            { assertThat(result.createdAt).isEqualTo(withdrawResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(withdrawResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(withdrawResponse.amount) },
            { assertThat(result.fee).isEqualTo(withdrawResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(withdrawResponse.transactionType) }
        )
    }

    @Test
    fun `upbitWithdrawsChanceResponse toDomain`() {
        // given
        val withdrawsChanceResponse = upbitWithdrawsChanceResponseFixture()

        // when
        val result = withdrawsChanceResponse.toDomain()

        // then
        assertAll("withdrawsChance",
            { assertThat(result.memberLevel.securityLevel).isEqualTo(withdrawsChanceResponse.memberLevel.securityLevel) },
            { assertThat(result.memberLevel.feeLevel).isEqualTo(withdrawsChanceResponse.memberLevel.feeLevel) },
            { assertThat(result.memberLevel.emailVerified).isEqualTo(withdrawsChanceResponse.memberLevel.emailVerified) },
            { assertThat(result.memberLevel.identityAuthVerified).isEqualTo(withdrawsChanceResponse.memberLevel.identityAuthVerified) },
            { assertThat(result.memberLevel.bankAccountVerified).isEqualTo(withdrawsChanceResponse.memberLevel.bankAccountVerified) },
            { assertThat(result.memberLevel.kakaoPayAuthVerified).isEqualTo(withdrawsChanceResponse.memberLevel.kakaoPayAuthVerified) },
            { assertThat(result.memberLevel.locked).isEqualTo(withdrawsChanceResponse.memberLevel.locked) },
            { assertThat(result.memberLevel.walletLocked).isEqualTo(withdrawsChanceResponse.memberLevel.walletLocked) },
            { assertThat(result.currency.code).isEqualTo(withdrawsChanceResponse.currency.code) },
            { assertThat(result.currency.withdrawFee).isEqualTo(withdrawsChanceResponse.currency.withdrawFee) },
            { assertThat(result.currency.isCoin).isEqualTo(withdrawsChanceResponse.currency.isCoin) },
            { assertThat(result.currency.walletState).isEqualTo(withdrawsChanceResponse.currency.walletState) },
            { assertThat(result.currency.walletSupport).isEqualTo(withdrawsChanceResponse.currency.walletSupport) },
            { assertThat(result.account.currency).isEqualTo(withdrawsChanceResponse.account.currency) },
            { assertThat(result.account.balance).isEqualTo(withdrawsChanceResponse.account.balance) },
            { assertThat(result.account.locked).isEqualTo(withdrawsChanceResponse.account.locked) },
            { assertThat(result.account.avgBuyPrice).isEqualTo(withdrawsChanceResponse.account.avgBuyPrice) },
            { assertThat(result.account.avgBuyPriceModified).isEqualTo(withdrawsChanceResponse.account.avgBuyPriceModified) },
            { assertThat(result.account.unitCurrency).isEqualTo(withdrawsChanceResponse.account.unitCurrency) },
            { assertThat(result.withdrawLimit.currency).isEqualTo(withdrawsChanceResponse.withdrawLimit.currency) },
            { assertThat(result.withdrawLimit.minimum).isEqualTo(withdrawsChanceResponse.withdrawLimit.minimum) },
            { assertThat(result.withdrawLimit.onetime).isEqualTo(withdrawsChanceResponse.withdrawLimit.onetime) },
            { assertThat(result.withdrawLimit.daily).isEqualTo(withdrawsChanceResponse.withdrawLimit.daily) },
            { assertThat(result.withdrawLimit.remainingDaily).isEqualTo(withdrawsChanceResponse.withdrawLimit.remainingDaily) },
            { assertThat(result.withdrawLimit.remainingDailyKrw).isEqualTo(withdrawsChanceResponse.withdrawLimit.remainingDailyKrw) },
            { assertThat(result.withdrawLimit.fixed).isEqualTo(withdrawsChanceResponse.withdrawLimit.fixed) },
            { assertThat(result.withdrawLimit.canWithdraw).isEqualTo(withdrawsChanceResponse.withdrawLimit.canWithdraw) }
        )
    }

    @Test
    fun `upbitWithdrawCoinPostResponse toDomain`() {
        // given
        val withdrawCoinPostResponse = upbitWithdrawCoinPostResponseFixture()

        // when
        val result = withdrawCoinPostResponse.toDomain()

        // then
        assertAll("withdrawCoinPost",
            { assertThat(result.type).isEqualTo(withdrawCoinPostResponse.type) },
            { assertThat(result.uuid).isEqualTo(withdrawCoinPostResponse.uuid) },
            { assertThat(result.currency).isEqualTo(withdrawCoinPostResponse.currency) },
            { assertThat(result.txid).isEqualTo(withdrawCoinPostResponse.txid) },
            { assertThat(result.state).isEqualTo(withdrawCoinPostResponse.state) },
            { assertThat(result.createdAt).isEqualTo(withdrawCoinPostResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(withdrawCoinPostResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(withdrawCoinPostResponse.amount) },
            { assertThat(result.fee).isEqualTo(withdrawCoinPostResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(withdrawCoinPostResponse.transactionType) },
            { assertThat(result.krwAmount).isEqualTo(withdrawCoinPostResponse.krwAmount) }
        )
    }

    @Test
    fun `upbitWithdrawKrwPostResponse toDomain`() {
        // given
        val withdrawKrwPostResponse = upbitWithdrawKrwPostResponseFixture()

        // when
        val result = withdrawKrwPostResponse.toDomain()

        // then
        assertAll("withdrawKrwPost",
            { assertThat(result.type).isEqualTo(withdrawKrwPostResponse.type) },
            { assertThat(result.uuid).isEqualTo(withdrawKrwPostResponse.uuid) },
            { assertThat(result.currency).isEqualTo(withdrawKrwPostResponse.currency) },
            { assertThat(result.txid).isEqualTo(withdrawKrwPostResponse.txid) },
            { assertThat(result.state).isEqualTo(withdrawKrwPostResponse.state) },
            { assertThat(result.createdAt).isEqualTo(withdrawKrwPostResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(withdrawKrwPostResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(withdrawKrwPostResponse.amount) },
            { assertThat(result.fee).isEqualTo(withdrawKrwPostResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(withdrawKrwPostResponse.transactionType) }
        )
    }
}

internal fun upbitWithdrawResponseFixture() = UpbitWithdrawResponse(
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

internal fun upbitWithdrawsChanceResponseFixture() = UpbitWithdrawsChanceResponse(
    memberLevel = memberLevelResponseFixture(),
    currency = currencyResponseFixture(),
    account = accountResponseFixture(),
    withdrawLimit = withdrawLimitResponseFixture()
)

internal fun memberLevelResponseFixture() = UpbitWithdrawsChanceResponse.MemberLevelResponse(
    securityLevel = 0,
    feeLevel = 0,
    emailVerified = true,
    identityAuthVerified = true,
    bankAccountVerified = true,
    kakaoPayAuthVerified = true,
    locked = true,
    walletLocked = true
)

internal fun currencyResponseFixture() = UpbitWithdrawsChanceResponse.CurrencyResponse(
    code = "code",
    withdrawFee = "withdrawFee",
    isCoin = true,
    walletState = "walletState",
    walletSupport = listOf("walletSupport")
)

internal fun accountResponseFixture() = UpbitWithdrawsChanceResponse.AccountResponse(
    currency = "currency",
    balance = "balance",
    locked = "locked",
    avgBuyPrice = "avgBuyPrice",
    avgBuyPriceModified = true,
    unitCurrency = "unitCurrency"
)

internal fun withdrawLimitResponseFixture() = UpbitWithdrawsChanceResponse.WithdrawLimitResponse(
    currency = "currency",
    minimum = "minimum",
    onetime = "onetime",
    daily = "daily",
    remainingDaily = "remainingDaily",
    remainingDailyKrw = "remainingDailyKrw",
    fixed = 0,
    canWithdraw = true
)

internal fun upbitWithdrawCoinPostResponseFixture() = UpbitWithdrawCoinPostResponse(
    type = "type",
    uuid = "uuid",
    currency = "currency",
    txid = "txid",
    state = "state",
    createdAt = "createdAt",
    doneAt = "doneAt",
    amount = "amount",
    fee = "fee",
    transactionType = "transactionType",
    krwAmount = "krwAmount"
)

internal fun upbitWithdrawKrwPostResponseFixture() = UpbitWithdrawKrwPostResponse(
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
