package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.client.retrofit.exchange.api.account.UpbitExchangeAccountsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.deposit.UpbitExchangeDepositsAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.info.UpbitExchangeInfoAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.order.UpbitExchangeOrdersAsyncApi
import com.jongmin.upbit.client.retrofit.exchange.api.withdraw.UpbitExchangeWithdrawsAsyncApi
import com.jongmin.upbit.exchange.UpbitExchangeAsyncService
import com.jongmin.upbit.exchange.account.UpbitAccount
import com.jongmin.upbit.exchange.deposit.UpbitCreateDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDeposit
import com.jongmin.upbit.exchange.deposit.UpbitDepositCoinAddress
import com.jongmin.upbit.exchange.deposit.UpbitDepositKrw
import com.jongmin.upbit.exchange.info.UpbitApiKey
import com.jongmin.upbit.exchange.info.UpbitWalletStatus
import com.jongmin.upbit.exchange.order.UpbitOrder
import com.jongmin.upbit.exchange.order.UpbitOrderDelete
import com.jongmin.upbit.exchange.order.UpbitOrderPost
import com.jongmin.upbit.exchange.order.UpbitOrderWithTrades
import com.jongmin.upbit.exchange.order.UpbitOrdersChance
import com.jongmin.upbit.exchange.withdraw.UpbitWithdraw
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawCoinPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawKrwPost
import com.jongmin.upbit.exchange.withdraw.UpbitWithdrawsChance
import com.jongmin.upbit.token.AuthorizationTokenService
import java.util.concurrent.CompletableFuture

class UpbitExchangeAsyncServiceImpl(
    private val accountsAsyncApi: UpbitExchangeAccountsAsyncApi,
    private val ordersAsyncApi: UpbitExchangeOrdersAsyncApi,
    private val withdrawsAsyncApi: UpbitExchangeWithdrawsAsyncApi,
    private val depositsAsyncApi: UpbitExchangeDepositsAsyncApi,
    private val infoAsyncApi: UpbitExchangeInfoAsyncApi,
    private val authorizationTokenService: AuthorizationTokenService
) : UpbitExchangeAsyncService {

    override fun getAccounts(): CompletableFuture<List<UpbitAccount>> {
        TODO("Not yet implemented")
    }

    override fun getOrdersChance(market: String): CompletableFuture<UpbitOrdersChance> {
        TODO("Not yet implemented")
    }

    override fun getOrder(uuid: String?, identifier: String?): CompletableFuture<UpbitOrderWithTrades> {
        TODO("Not yet implemented")
    }

    override fun getOrders(
        market: String?,
        state: String?,
        states: List<String>,
        uuids: List<String>,
        identifiers: List<String>,
        page: Int?,
        limit: Int?,
        orderBy: String?
    ): CompletableFuture<List<UpbitOrder>> {
        TODO("Not yet implemented")
    }

    override fun deleteOrder(uuid: String?, identifier: String?): CompletableFuture<UpbitOrderDelete> {
        TODO("Not yet implemented")
    }

    override fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String?
    ): CompletableFuture<UpbitOrderPost> {
        TODO("Not yet implemented")
    }

    override fun getWithdraws(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): CompletableFuture<List<UpbitWithdraw>> {
        TODO("Not yet implemented")
    }

    override fun getWithdraw(uuid: String, txid: String?, currency: String?): CompletableFuture<UpbitWithdraw> {
        TODO("Not yet implemented")
    }

    override fun getWithdrawsChance(currency: String): CompletableFuture<UpbitWithdrawsChance> {
        TODO("Not yet implemented")
    }

    override fun postWithdrawCoin(
        currency: String,
        amount: String,
        address: String,
        secondaryAddress: String?,
        transactionType: String?
    ): CompletableFuture<UpbitWithdrawCoinPost> {
        TODO("Not yet implemented")
    }

    override fun postWithdrawKrw(amount: String): CompletableFuture<UpbitWithdrawKrwPost> {
        TODO("Not yet implemented")
    }

    override fun getDeposits(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): CompletableFuture<List<UpbitDeposit>> {
        TODO("Not yet implemented")
    }

    override fun getDeposit(uuid: String, txid: String?, currency: String?): CompletableFuture<UpbitDeposit> {
        TODO("Not yet implemented")
    }

    override fun createDepositCoinAddress(currency: String): CompletableFuture<UpbitCreateDepositCoinAddress> {
        TODO("Not yet implemented")
    }

    override fun getDepositsCoinAddresses(): CompletableFuture<List<UpbitDepositCoinAddress>> {
        TODO("Not yet implemented")
    }

    override fun getDepositsCoinAddress(currency: String): CompletableFuture<UpbitDepositCoinAddress> {
        TODO("Not yet implemented")
    }

    override fun postDepositKrw(amount: String): CompletableFuture<UpbitDepositKrw> {
        TODO("Not yet implemented")
    }

    override fun getWalletStatus(): CompletableFuture<List<UpbitWalletStatus>> {
        TODO("Not yet implemented")
    }

    override fun getApiKeys(): CompletableFuture<List<UpbitApiKey>> {
        TODO("Not yet implemented")
    }
}
