package com.jongmin.upbit.client.retrofit.spring.boot

import com.jongmin.upbit.client.retrofit.spring.boot.autoconfigure.UpbitRetrofitClientAutoConfigure
import com.jongmin.upbit.exchange.UpbitExchangeService
import com.jongmin.upbit.server.mock.exchange.account.GetAccountsResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositsCoinAddressResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositsCoinAddressesResponse
import com.jongmin.upbit.server.mock.exchange.deposit.GetDepositsResponse
import com.jongmin.upbit.server.mock.exchange.deposit.PostDepositsGenerateCoinAddressResponse1
import com.jongmin.upbit.server.mock.exchange.deposit.PostDepositsGenerateCoinAddressResponse2
import com.jongmin.upbit.server.mock.exchange.deposit.PostDepositsKrwResponse
import com.jongmin.upbit.server.mock.exchange.info.GetApiKyesResponse
import com.jongmin.upbit.server.mock.exchange.info.GetWalletStatusResponse
import com.jongmin.upbit.server.mock.exchange.order.DeleteOrderResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrderResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrdersChanceResponse
import com.jongmin.upbit.server.mock.exchange.order.GetOrdersResponse
import com.jongmin.upbit.server.mock.exchange.order.PostOrdersResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.GetWithdrawResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.GetWithdrawsChanceResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.GetWithdrawsResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.PostWithdrawsCoinResponse
import com.jongmin.upbit.server.mock.exchange.withdraw.PostWithdrawsKrwResponse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(classes = [UpbitRetrofitClientAutoConfigure::class])
class UpbitExchangeRetrofitClientIntegrationTest : UpbitLocalMockServer() {

    @Autowired
    lateinit var upbitExchangeService: UpbitExchangeService

    @Test
    fun getAccounts() {
        // given
        /**
         * @see GetAccountsResponse.fixture
         */

        // when
        val result = upbitExchangeService.getAccounts()

        // then
        assertAll("UpbitAccount[0]",
            { assertThat(result[0].currency).isEqualTo(GetAccountsResponse.currency1) },
            { assertThat(result[0].balance).isEqualTo(GetAccountsResponse.balance1) },
            { assertThat(result[0].locked).isEqualTo(GetAccountsResponse.locked1) },
            { assertThat(result[0].avgBuyPrice).isEqualTo(GetAccountsResponse.avgBuyPrice1) },
            { assertThat(result[0].avgBuyPriceModified).isEqualTo(GetAccountsResponse.avgBuyPriceModified1) },
            { assertThat(result[0].unitCurrency).isEqualTo(GetAccountsResponse.unitCurrency1) }
        )
        assertAll("UpbitAccount[1]",
            { assertThat(result[1].currency).isEqualTo(GetAccountsResponse.currency2) },
            { assertThat(result[1].balance).isEqualTo(GetAccountsResponse.balance2) },
            { assertThat(result[1].locked).isEqualTo(GetAccountsResponse.locked2) },
            { assertThat(result[1].avgBuyPrice).isEqualTo(GetAccountsResponse.avgBuyPrice2) },
            { assertThat(result[1].avgBuyPriceModified).isEqualTo(GetAccountsResponse.avgBuyPriceModified2) },
            { assertThat(result[1].unitCurrency).isEqualTo(GetAccountsResponse.unitCurrency2) }
        )
    }

    @Test
    fun getOrdersChance() {
        // given
        /**
         * @see GetOrdersChanceResponse.fixture
         */

        // when
        val result = upbitExchangeService.getOrdersChance("market")

        // then
        assertAll(
            "UpbitOrdersChance",
            { assertThat(result.bidFee).isEqualTo(GetOrdersChanceResponse.bidFee) },
            { assertThat(result.askFee).isEqualTo(GetOrdersChanceResponse.askFee) },
            { assertThat(result.market.id).isEqualTo(GetOrdersChanceResponse.marketId) },
            { assertThat(result.market.name).isEqualTo(GetOrdersChanceResponse.marketName) },
            { assertThat(result.market.orderTypes[0]).isEqualTo(GetOrdersChanceResponse.marketOrderType1) },
            { assertThat(result.market.orderSides[0]).isEqualTo(GetOrdersChanceResponse.marketOrderSide1) },
            { assertThat(result.market.orderSides[1]).isEqualTo(GetOrdersChanceResponse.marketOrderSide2) },
            { assertThat(result.market.bid.currency).isEqualTo(GetOrdersChanceResponse.marketBidCurrency) },
            { assertThat(result.market.bid.priceUnit).isEqualTo(GetOrdersChanceResponse.marketBidPriceUnit) },
            { assertThat(result.market.bid.minTotal).isEqualTo(GetOrdersChanceResponse.marketBidMinTotal) },
            { assertThat(result.market.ask.currency).isEqualTo(GetOrdersChanceResponse.marketAskCurrency) },
            { assertThat(result.market.ask.priceUnit).isEqualTo(GetOrdersChanceResponse.marketAskPriceUnit) },
            { assertThat(result.market.ask.minTotal).isEqualTo(GetOrdersChanceResponse.marketAskMinTotal) },
            { assertThat(result.market.maxTotal).isEqualTo(GetOrdersChanceResponse.maxTotal) },
            { assertThat(result.market.state).isEqualTo(GetOrdersChanceResponse.state) },
            { assertThat(result.bidAccount.currency).isEqualTo(GetOrdersChanceResponse.bidAccountCurrency) },
            { assertThat(result.bidAccount.balance).isEqualTo(GetOrdersChanceResponse.bidAccountBalance) },
            { assertThat(result.bidAccount.locked).isEqualTo(GetOrdersChanceResponse.bidAccountLocked) },
            { assertThat(result.bidAccount.avgBuyPrice).isEqualTo(GetOrdersChanceResponse.bidAccountAvgBuyPrice) },
            { assertThat(result.bidAccount.avgBuyPriceModified).isEqualTo(GetOrdersChanceResponse.bidAccountAvgBuyPriceModified) },
            { assertThat(result.bidAccount.unitCurrency).isEqualTo(GetOrdersChanceResponse.bidAccountUnitCurrency) },
            { assertThat(result.askAccount.currency).isEqualTo(GetOrdersChanceResponse.askAccountCurrency) },
            { assertThat(result.askAccount.balance).isEqualTo(GetOrdersChanceResponse.askAccountBalance) },
            { assertThat(result.askAccount.locked).isEqualTo(GetOrdersChanceResponse.askAccountLocked) },
            { assertThat(result.askAccount.avgBuyPrice).isEqualTo(GetOrdersChanceResponse.askAccountAvgBuyPrice) },
            { assertThat(result.askAccount.avgBuyPriceModified).isEqualTo(GetOrdersChanceResponse.askAccountAvgBuyPriceModified) },
            { assertThat(result.askAccount.unitCurrency).isEqualTo(GetOrdersChanceResponse.askAccountUnitCurrency) },
        )
    }

    @Test
    fun getOrder() {
        // given
        /**
         * @see GetOrderResponse.fixture
         */

        // when
        val result = upbitExchangeService.getOrder("uuid")

        // then
        assertAll("UpbitOrderIncludingTrades",
            { assertThat(result.uuid).isEqualTo(GetOrderResponse.uuid) },
            { assertThat(result.side).isEqualTo(GetOrderResponse.side) },
            { assertThat(result.ordType).isEqualTo(GetOrderResponse.ordType) },
            { assertThat(result.price).isEqualTo(GetOrderResponse.price) },
            { assertThat(result.state).isEqualTo(GetOrderResponse.state) },
            { assertThat(result.market).isEqualTo(GetOrderResponse.market) },
            { assertThat(result.createdAt).isEqualTo(GetOrderResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(GetOrderResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(GetOrderResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(GetOrderResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(GetOrderResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(GetOrderResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(GetOrderResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(GetOrderResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(GetOrderResponse.tradesCount) },
            { assertThat(result.trades[0].market).isEqualTo(GetOrderResponse.tradeMarket) },
            { assertThat(result.trades[0].uuid).isEqualTo(GetOrderResponse.tradeUuid) },
            { assertThat(result.trades[0].price).isEqualTo(GetOrderResponse.tradePrice) },
            { assertThat(result.trades[0].volume).isEqualTo(GetOrderResponse.tradeVolume) },
            { assertThat(result.trades[0].funds).isEqualTo(GetOrderResponse.tradeFunds) },
            { assertThat(result.trades[0].side).isEqualTo(GetOrderResponse.tradeSide) }
        )
    }

    @Test
    fun getOrders() {
        // given
        /**
         * @see GetOrdersResponse.fixture
         */

        // when
        val result = upbitExchangeService.getOrders(
            state = "done",
            uuids = listOf("uuid")
        )

        // then
        assertAll("UpbitOrder[0]",
            { assertThat(result[0].uuid).isEqualTo(GetOrdersResponse.uuid) },
            { assertThat(result[0].side).isEqualTo(GetOrdersResponse.side) },
            { assertThat(result[0].ordType).isEqualTo(GetOrdersResponse.ordType) },
            { assertThat(result[0].price).isEqualTo(GetOrdersResponse.price) },
            { assertThat(result[0].state).isEqualTo(GetOrdersResponse.state) },
            { assertThat(result[0].market).isEqualTo(GetOrdersResponse.market) },
            { assertThat(result[0].createdAt).isEqualTo(GetOrdersResponse.createdAt) },
            { assertThat(result[0].volume).isEqualTo(GetOrdersResponse.volume) },
            { assertThat(result[0].remainingVolume).isEqualTo(GetOrdersResponse.remainingVolume) },
            { assertThat(result[0].reservedFee).isEqualTo(GetOrdersResponse.reservedFee) },
            { assertThat(result[0].remainingFee).isEqualTo(GetOrdersResponse.remainingFee) },
            { assertThat(result[0].paidFee).isEqualTo(GetOrdersResponse.paidFee) },
            { assertThat(result[0].locked).isEqualTo(GetOrdersResponse.locked) },
            { assertThat(result[0].executedVolume).isEqualTo(GetOrdersResponse.executedVolume) },
            { assertThat(result[0].tradesCount).isEqualTo(GetOrdersResponse.tradesCount) }
        )
    }

    @Test
    fun deleteOrder() {
        // given
        /**
         * @see DeleteOrderResponse.fixture
         */

        // when
        val result = upbitExchangeService.deleteOrder(uuid = "uuid")

        // then
        assertAll("UpbitOrderDelete",
            { assertThat(result.uuid).isEqualTo(DeleteOrderResponse.uuid) },
            { assertThat(result.side).isEqualTo(DeleteOrderResponse.side) },
            { assertThat(result.ordType).isEqualTo(DeleteOrderResponse.ordType) },
            { assertThat(result.price).isEqualTo(DeleteOrderResponse.price) },
            { assertThat(result.state).isEqualTo(DeleteOrderResponse.state) },
            { assertThat(result.market).isEqualTo(DeleteOrderResponse.market) },
            { assertThat(result.createdAt).isEqualTo(DeleteOrderResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(DeleteOrderResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(DeleteOrderResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(DeleteOrderResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(DeleteOrderResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(DeleteOrderResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(DeleteOrderResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(DeleteOrderResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(DeleteOrderResponse.tradesCount) }
        )
    }

    @Test
    fun postOrders() {
        // given
        /**
         * @see PostOrdersResponse.fixture
         */

        // when
        val result = upbitExchangeService.postOrder(
            PostOrdersResponse.market,
            PostOrdersResponse.side,
            PostOrdersResponse.volume,
            PostOrdersResponse.price,
            PostOrdersResponse.ordType
        )

        // then
        assertAll("UpbitOrderPost",
            { assertThat(result.uuid).isEqualTo(PostOrdersResponse.uuid) },
            { assertThat(result.side).isEqualTo(PostOrdersResponse.side) },
            { assertThat(result.ordType).isEqualTo(PostOrdersResponse.ordType) },
            { assertThat(result.price).isEqualTo(PostOrdersResponse.price) },
            { assertThat(result.avgPrice).isEqualTo(PostOrdersResponse.avgPrice) },
            { assertThat(result.state).isEqualTo(PostOrdersResponse.state) },
            { assertThat(result.market).isEqualTo(PostOrdersResponse.market) },
            { assertThat(result.createdAt).isEqualTo(PostOrdersResponse.createdAt) },
            { assertThat(result.volume).isEqualTo(PostOrdersResponse.volume) },
            { assertThat(result.remainingVolume).isEqualTo(PostOrdersResponse.remainingVolume) },
            { assertThat(result.reservedFee).isEqualTo(PostOrdersResponse.reservedFee) },
            { assertThat(result.remainingFee).isEqualTo(PostOrdersResponse.remainingFee) },
            { assertThat(result.paidFee).isEqualTo(PostOrdersResponse.paidFee) },
            { assertThat(result.locked).isEqualTo(PostOrdersResponse.locked) },
            { assertThat(result.executedVolume).isEqualTo(PostOrdersResponse.executedVolume) },
            { assertThat(result.tradesCount).isEqualTo(PostOrdersResponse.tradesCount) }
        )
    }

    @Test
    fun getWithdraws() {
        // given
        /**
         * @see GetWithdrawsResponse.fixture
         */

        // when
        val result = upbitExchangeService.getWithdraws(
            currency = "currency",
            txids = listOf("txid")
        )

        // then
        assertAll("UpbitWithdraw[0]",
            { assertThat(result[0].type).isEqualTo(GetWithdrawsResponse.type) },
            { assertThat(result[0].uuid).isEqualTo(GetWithdrawsResponse.uuid) },
            { assertThat(result[0].currency).isEqualTo(GetWithdrawsResponse.currency) },
            { assertThat(result[0].txid).isEqualTo(GetWithdrawsResponse.txid) },
            { assertThat(result[0].state).isEqualTo(GetWithdrawsResponse.state) },
            { assertThat(result[0].createdAt).isEqualTo(GetWithdrawsResponse.createdAt) },
            { assertThat(result[0].doneAt).isEqualTo(GetWithdrawsResponse.doneAt) },
            { assertThat(result[0].amount).isEqualTo(GetWithdrawsResponse.amount) },
            { assertThat(result[0].fee).isEqualTo(GetWithdrawsResponse.fee) },
            { assertThat(result[0].transactionType).isEqualTo(GetWithdrawsResponse.transactionType) }
        )
    }

    @Test
    fun getWithdraw() {
        // given
        /**
         * @see GetWithdrawResponse.fixture
         */

        // when
        val result = upbitExchangeService.getWithdraw(uuid = "uuid")

        // then
        assertAll("UpbitWithdraw",
            { assertThat(result.type).isEqualTo(GetWithdrawResponse.type) },
            { assertThat(result.uuid).isEqualTo(GetWithdrawResponse.uuid) },
            { assertThat(result.currency).isEqualTo(GetWithdrawResponse.currency) },
            { assertThat(result.txid).isEqualTo(GetWithdrawResponse.txid) },
            { assertThat(result.state).isEqualTo(GetWithdrawResponse.state) },
            { assertThat(result.createdAt).isEqualTo(GetWithdrawResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(GetWithdrawResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(GetWithdrawResponse.amount) },
            { assertThat(result.fee).isEqualTo(GetWithdrawResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(GetWithdrawResponse.transactionType) }
        )
    }

    @Test
    fun getWithdrawsChance() {
        // given
        /**
         * @see GetWithdrawsChanceResponse.fixture
         */

        // when
        val result = upbitExchangeService.getWithdrawsChance("currency")

        // then
        assertAll("UptibTwithdrawsChance",
            { assertThat(result.memberLevel.securityLevel).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.securityLevel) },
            { assertThat(result.memberLevel.feeLevel).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.feeLevel) },
            { assertThat(result.memberLevel.emailVerified).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.emailVerified) },
            { assertThat(result.memberLevel.identityAuthVerified).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.identityAuthVerified) },
            { assertThat(result.memberLevel.bankAccountVerified).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.bankAccountVerified) },
            { assertThat(result.memberLevel.kakaoPayAuthVerified).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.kakaoPayAuthVerified) },
            { assertThat(result.memberLevel.locked).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.locked) },
            { assertThat(result.memberLevel.walletLocked).isEqualTo(GetWithdrawsChanceResponse.MemberLevel.walletLocked) },
            { assertThat(result.currency.code).isEqualTo(GetWithdrawsChanceResponse.Currency.code) },
            { assertThat(result.currency.withdrawFee).isEqualTo(GetWithdrawsChanceResponse.Currency.withdrawFee) },
            { assertThat(result.currency.isCoin).isEqualTo(GetWithdrawsChanceResponse.Currency.isCoin) },
            { assertThat(result.currency.walletState).isEqualTo(GetWithdrawsChanceResponse.Currency.walletState) },
            { assertThat(result.currency.walletSupport[0]).isEqualTo(GetWithdrawsChanceResponse.Currency.walletSupport1) },
            { assertThat(result.currency.walletSupport[1]).isEqualTo(GetWithdrawsChanceResponse.Currency.walletSupport2) },
            { assertThat(result.account.currency).isEqualTo(GetWithdrawsChanceResponse.Account.currency) },
            { assertThat(result.account.balance).isEqualTo(GetWithdrawsChanceResponse.Account.balance) },
            { assertThat(result.account.locked).isEqualTo(GetWithdrawsChanceResponse.Account.locked) },
            { assertThat(result.account.avgBuyPrice).isEqualTo(GetWithdrawsChanceResponse.Account.avgBuyPrice) },
            { assertThat(result.account.avgBuyPriceModified).isEqualTo(GetWithdrawsChanceResponse.Account.avgBuyPriceModified) },
            { assertThat(result.account.unitCurrency).isEqualTo(GetWithdrawsChanceResponse.Account.unitCurrency) },
            { assertThat(result.withdrawLimit.currency).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.currency) },
            { assertThat(result.withdrawLimit.minimum).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.minimum) },
            { assertThat(result.withdrawLimit.onetime).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.onetime) },
            { assertThat(result.withdrawLimit.daily).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.daily) },
            { assertThat(result.withdrawLimit.remainingDaily).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.remainingDaily) },
            { assertThat(result.withdrawLimit.remainingDailyKrw).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.remainingDailyKrw) },
            { assertThat(result.withdrawLimit.fixed).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.fixed) },
            { assertThat(result.withdrawLimit.canWithdraw).isEqualTo(GetWithdrawsChanceResponse.WithdrawLimit.canWithdraw) }
        )
    }

    @Test
    fun postWithdrawsCoin() {
        // given
        /**
         * @see PostWithdrawsCoinResponse.fixture
         */

        // when
        val result = upbitExchangeService.postWithdrawCoin(
            currency = "currency",
            amount = "amount",
            address = "address"
        )

        // then
        assertAll("upbitWithdrawCoinPost",
            { assertThat(result.type).isEqualTo(PostWithdrawsCoinResponse.type) },
            { assertThat(result.uuid).isEqualTo(PostWithdrawsCoinResponse.uuid) },
            { assertThat(result.currency).isEqualTo(PostWithdrawsCoinResponse.currency) },
            { assertThat(result.txid).isEqualTo(PostWithdrawsCoinResponse.txid) },
            { assertThat(result.state).isEqualTo(PostWithdrawsCoinResponse.state) },
            { assertThat(result.createdAt).isEqualTo(PostWithdrawsCoinResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(PostWithdrawsCoinResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(PostWithdrawsCoinResponse.amount) },
            { assertThat(result.fee).isEqualTo(PostWithdrawsCoinResponse.fee) },
            { assertThat(result.krwAmount).isEqualTo(PostWithdrawsCoinResponse.krwAmount) },
            { assertThat(result.transactionType).isEqualTo(PostWithdrawsCoinResponse.transactionType) }
        )
    }

    @Test
    fun postWithdrawsKrw() {
        // given
        /**
         * @see PostWithdrawsKrwResponse.fixture
         */

        // when
        val result = upbitExchangeService.postWithdrawKrw("amount")

        // then
        assertAll("upbitWithdrawKrwPost",
            { assertThat(result.type).isEqualTo(PostWithdrawsKrwResponse.type) },
            { assertThat(result.uuid).isEqualTo(PostWithdrawsKrwResponse.uuid) },
            { assertThat(result.currency).isEqualTo(PostWithdrawsKrwResponse.currency) },
            { assertThat(result.txid).isEqualTo(PostWithdrawsKrwResponse.txid) },
            { assertThat(result.state).isEqualTo(PostWithdrawsKrwResponse.state) },
            { assertThat(result.createdAt).isEqualTo(PostWithdrawsKrwResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(PostWithdrawsKrwResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(PostWithdrawsKrwResponse.amount) },
            { assertThat(result.fee).isEqualTo(PostWithdrawsKrwResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(PostWithdrawsKrwResponse.transactionType) }
        )
    }

    @Test
    fun getDeposits() {
        // given
        /**
         * @see GetDepositsResponse.fixture
         */

        // when
        val result = upbitExchangeService.getDeposits(
            currency = "currency",
            txids = listOf("txid")
        )

        // then
        assertAll("UpbitDeposit[0]",
            { assertThat(result[0].type).isEqualTo(GetDepositsResponse.type) },
            { assertThat(result[0].uuid).isEqualTo(GetDepositsResponse.uuid) },
            { assertThat(result[0].currency).isEqualTo(GetDepositsResponse.currency) },
            { assertThat(result[0].txid).isEqualTo(GetDepositsResponse.txid) },
            { assertThat(result[0].state).isEqualTo(GetDepositsResponse.state) },
            { assertThat(result[0].createdAt).isEqualTo(GetDepositsResponse.createdAt) },
            { assertThat(result[0].doneAt).isEqualTo(GetDepositsResponse.doneAt) },
            { assertThat(result[0].amount).isEqualTo(GetDepositsResponse.amount) },
            { assertThat(result[0].fee).isEqualTo(GetDepositsResponse.fee) },
            { assertThat(result[0].transactionType).isEqualTo(GetDepositsResponse.transactionType) }
        )
    }

    @Test
    fun getDeposit() {
        // given
        /**
         * @see GetDepositResponse.fixture
         */

        // when
        val result = upbitExchangeService.getDeposit(uuid = "uuid")

        // then
        assertAll("UpbitDeposit",
            { assertThat(result.type).isEqualTo(GetDepositResponse.type) },
            { assertThat(result.uuid).isEqualTo(GetDepositResponse.uuid) },
            { assertThat(result.currency).isEqualTo(GetDepositResponse.currency) },
            { assertThat(result.txid).isEqualTo(GetDepositResponse.txid) },
            { assertThat(result.state).isEqualTo(GetDepositResponse.state) },
            { assertThat(result.createdAt).isEqualTo(GetDepositResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(GetDepositResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(GetDepositResponse.amount) },
            { assertThat(result.fee).isEqualTo(GetDepositResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(GetDepositResponse.transactionType) }
        )
    }

    @Test
    fun `postDepositsGenerateCoinAddress before created`() {
        // given
        /**
         * @see PostDepositsGenerateCoinAddressResponse1.fixture
         */

        // when
        val result = upbitExchangeService.createDepositCoinAddress("currency")

        // then
        assertAll("UpbitCreateDepositCoinAddress",
            { assertThat(result.success).isEqualTo(PostDepositsGenerateCoinAddressResponse1.success) },
            { assertThat(result.message).isEqualTo(PostDepositsGenerateCoinAddressResponse1.message) },
            { assertThat(result.currency).isNull() },
            { assertThat(result.depositAddress).isNull() },
            { assertThat(result.secondaryAddress).isNull() }
        )
    }

    @Disabled
    @Test
    fun `postDepositsGenerateCoinAddress after created`() {
        // given
        /**
         * @see PostDepositsGenerateCoinAddressResponse2.fixture
         */

        // when
        val result = upbitExchangeService.createDepositCoinAddress("currency")

        // then
        assertAll("UpbitCreateDepositCoinAddress",
            { assertThat(result.success).isNull() },
            { assertThat(result.message).isNull() },
            { assertThat(result.currency).isEqualTo(PostDepositsGenerateCoinAddressResponse2.currency) },
            { assertThat(result.depositAddress).isEqualTo(PostDepositsGenerateCoinAddressResponse2.depositAddress) },
            { assertThat(result.secondaryAddress).isEqualTo(PostDepositsGenerateCoinAddressResponse2.secondaryAddress) }
        )
    }

    @Test
    fun getDepositsCoinAddresses() {
        // given
        /**
         * @see GetDepositsCoinAddressesResponse.fixture
         */

        // when
        val result = upbitExchangeService.getDepositsCoinAddresses()

        // then
        assertAll("UpbitDepositCoinAddress[0]",
            { assertThat(result[0].currency).isEqualTo(GetDepositsCoinAddressesResponse.currency1) },
            { assertThat(result[0].depositAddress).isEqualTo(GetDepositsCoinAddressesResponse.depositAddress1) },
            { assertThat(result[0].secondaryAddress).isEqualTo(GetDepositsCoinAddressesResponse.secondaryAddress1) }
        )
        assertAll("UpbitDepositCoinAddress[1]",
            { assertThat(result[1].currency).isEqualTo(GetDepositsCoinAddressesResponse.currency2) },
            { assertThat(result[1].depositAddress).isEqualTo(GetDepositsCoinAddressesResponse.depositAddress2) },
            { assertThat(result[1].secondaryAddress).isEqualTo(GetDepositsCoinAddressesResponse.secondaryAddress2) }
        )
    }

    @Test
    fun getDepositsCoinAddress() {
        // given
        /**
         * @see GetDepositsCoinAddressResponse.fixture
         */

        // when
        val result = upbitExchangeService.getDepositsCoinAddress("currency")

        // then
        assertAll("UpbitDepositCoinAddress",
            { assertThat(result.currency).isEqualTo(GetDepositsCoinAddressResponse.currency) },
            { assertThat(result.depositAddress).isEqualTo(GetDepositsCoinAddressResponse.depositAddress) },
            { assertThat(result.secondaryAddress).isEqualTo(GetDepositsCoinAddressResponse.secondaryAddress) }
        )
    }

    @Test
    fun postDepositsKrw() {
        // given
        /**
         * @see PostDepositsKrwResponse.fixture
         */

        // when
        val result = upbitExchangeService.postDepositKrw("amount")

        // then
        assertAll(
            "UpbitDepositKrw",
            { assertThat(result.type).isEqualTo(PostDepositsKrwResponse.type) },
            { assertThat(result.uuid).isEqualTo(PostDepositsKrwResponse.uuid) },
            { assertThat(result.currency).isEqualTo(PostDepositsKrwResponse.currency) },
            { assertThat(result.txid).isEqualTo(PostDepositsKrwResponse.txid) },
            { assertThat(result.state).isEqualTo(PostDepositsKrwResponse.state) },
            { assertThat(result.createdAt).isEqualTo(PostDepositsKrwResponse.createdAt) },
            { assertThat(result.doneAt).isEqualTo(PostDepositsKrwResponse.doneAt) },
            { assertThat(result.amount).isEqualTo(PostDepositsKrwResponse.amount) },
            { assertThat(result.fee).isEqualTo(PostDepositsKrwResponse.fee) },
            { assertThat(result.transactionType).isEqualTo(PostDepositsKrwResponse.transactionType) }
        )
    }

    @Test
    fun getWalletStatus() {
        // given
        /**
         * @see GetWalletStatusResponse.fixture
         */

        // when
        val result = upbitExchangeService.getWalletStatus()

        // then
        assertAll("UpbitWalletStatus[0]",
            { assertThat(result[0].currency).isEqualTo(GetWalletStatusResponse.currency) },
            { assertThat(result[0].walletState).isEqualTo(GetWalletStatusResponse.walletState) },
            { assertThat(result[0].blockState).isEqualTo(GetWalletStatusResponse.blockState) },
            { assertThat(result[0].blockHeight).isEqualTo(GetWalletStatusResponse.blockHeight) },
            { assertThat(result[0].blockUpdatedAt).isEqualTo(GetWalletStatusResponse.blockUpdatedAt) }
        )
    }

    @Test
    fun getApiKeys() {
        // given
        /**
         * @see GetApiKyesResponse.fixture
         */

        // when
        val result = upbitExchangeService.getApiKeys()

        // then
        assertAll("UpbitApiKey[0]",
            { assertThat(result[0].accessKey).isEqualTo(GetApiKyesResponse.accessKey) },
            { assertThat(result[0].expireAt).isEqualTo(GetApiKyesResponse.expireAt) }
        )
    }

    @AfterEach
    fun checkAuthorizationTokenExistInRequest() {
        assertThat(upbitMockServer.getAuthorizationToken()).isNotNull
    }
}
