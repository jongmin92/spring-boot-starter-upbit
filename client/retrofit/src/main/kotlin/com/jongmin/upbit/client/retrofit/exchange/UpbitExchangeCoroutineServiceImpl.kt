package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.exchange.UpbitExchangeAsyncService
import com.jongmin.upbit.exchange.UpbitExchangeCoroutineService
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
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.future.asDeferred

class UpbitExchangeCoroutineServiceImpl(
    private val upbitExchangeAsyncService: UpbitExchangeAsyncService
) : UpbitExchangeCoroutineService {

    override fun getAccounts(): Deferred<List<UpbitAccount>> {
        return upbitExchangeAsyncService.getAccounts().asDeferred()
    }

    override fun getOrdersChance(market: String): Deferred<UpbitOrdersChance> {
        return upbitExchangeAsyncService.getOrdersChance(market).asDeferred()
    }

    override fun getOrder(uuid: String?, identifier: String?): Deferred<UpbitOrderWithTrades> {
        return upbitExchangeAsyncService.getOrder(uuid, identifier).asDeferred()
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
    ): Deferred<List<UpbitOrder>> {
        return upbitExchangeAsyncService.getOrders(
            market = market,
            state = state,
            states = states,
            uuids = uuids,
            identifiers = identifiers,
            page = page,
            limit = limit,
            orderBy = orderBy
        ).asDeferred()
    }

    override fun deleteOrder(uuid: String?, identifier: String?): Deferred<UpbitOrderDelete> {
        return upbitExchangeAsyncService.deleteOrder(uuid, identifier).asDeferred()
    }

    override fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String?
    ): Deferred<UpbitOrderPost> {
        return upbitExchangeAsyncService.postOrder(
            market = market,
            side = side,
            volume = volume,
            price = price,
            ordType = ordType,
            identifier = identifier
        ).asDeferred()
    }

    override fun getWithdraws(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): Deferred<List<UpbitWithdraw>> {
        return upbitExchangeAsyncService.getWithdraws(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        ).asDeferred()
    }

    override fun getWithdraw(uuid: String, txid: String?, currency: String?): Deferred<UpbitWithdraw> {
        return upbitExchangeAsyncService.getWithdraw(uuid, txid, currency).asDeferred()
    }

    override fun getWithdrawsChance(currency: String): Deferred<UpbitWithdrawsChance> {
        return upbitExchangeAsyncService.getWithdrawsChance(currency).asDeferred()
    }

    override fun postWithdrawCoin(
        currency: String,
        amount: String,
        address: String,
        secondaryAddress: String?,
        transactionType: String?
    ): Deferred<UpbitWithdrawCoinPost> {
        return upbitExchangeAsyncService.postWithdrawCoin(
            currency = currency,
            amount = amount,
            address = address,
            secondaryAddress = secondaryAddress,
            transactionType = transactionType
        ).asDeferred()
    }

    override fun postWithdrawKrw(amount: String): Deferred<UpbitWithdrawKrwPost> {
        return upbitExchangeAsyncService.postWithdrawKrw(amount).asDeferred()
    }

    override fun getDeposits(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): Deferred<List<UpbitDeposit>> {
        return upbitExchangeAsyncService.getDeposits(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            page = page,
            limit = limit,
            orderBy = orderBy
        ).asDeferred()
    }

    override fun getDeposit(uuid: String, txid: String?, currency: String?): Deferred<UpbitDeposit> {
        return upbitExchangeAsyncService.getDeposit(uuid, txid, currency).asDeferred()
    }

    override fun createDepositCoinAddress(currency: String): Deferred<UpbitCreateDepositCoinAddress> {
        return upbitExchangeAsyncService.createDepositCoinAddress(currency).asDeferred()
    }

    override fun getDepositsCoinAddresses(): Deferred<List<UpbitDepositCoinAddress>> {
        return upbitExchangeAsyncService.getDepositsCoinAddresses().asDeferred()
    }

    override fun getDepositsCoinAddress(currency: String): Deferred<UpbitDepositCoinAddress> {
        return upbitExchangeAsyncService.getDepositsCoinAddress(currency).asDeferred()
    }

    override fun postDepositKrw(amount: String): Deferred<UpbitDepositKrw> {
        return upbitExchangeAsyncService.postDepositKrw(amount).asDeferred()
    }

    override fun getWalletStatus(): Deferred<List<UpbitWalletStatus>> {
        return upbitExchangeAsyncService.getWalletStatus().asDeferred()
    }

    override fun getApiKeys(): Deferred<List<UpbitApiKey>> {
        return upbitExchangeAsyncService.getApiKeys().asDeferred()
    }
}
