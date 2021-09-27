package com.jongmin.upbit.client.retrofit.exchange

import com.jongmin.upbit.exchange.UpbitExchangeAsyncService
import com.jongmin.upbit.exchange.UpbitExchangeService
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
import joining

class UpbitExchangeServiceImpl(
    private val upbitExchangeAsyncService: UpbitExchangeAsyncService
) : UpbitExchangeService {

    override fun getAccounts(): List<UpbitAccount> {
        return upbitExchangeAsyncService.getAccounts().joining()
    }

    override fun getOrdersChance(market: String): UpbitOrdersChance {
        return upbitExchangeAsyncService.getOrdersChance(market).joining()
    }

    override fun getOrder(uuid: String?, identifier: String?): UpbitOrderWithTrades {
        return upbitExchangeAsyncService.getOrder(uuid, identifier).joining()
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
    ): List<UpbitOrder> {
        return upbitExchangeAsyncService.getOrders(
            market = market,
            state = state,
            states = states,
            uuids = uuids,
            identifiers = identifiers,
            page = page,
            limit = limit,
            orderBy = orderBy
        ).joining()
    }

    override fun deleteOrder(uuid: String?, identifier: String?): UpbitOrderDelete {
        return upbitExchangeAsyncService.deleteOrder(uuid, identifier).joining()
    }

    override fun postOrder(
        market: String,
        side: String,
        volume: String,
        price: String,
        ordType: String,
        identifier: String?
    ): UpbitOrderPost {
        return upbitExchangeAsyncService.postOrder(
            market = market,
            side = side,
            volume = volume,
            price = price,
            ordType = ordType,
            identifier = identifier
        ).joining()
    }

    override fun getWithdraws(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): List<UpbitWithdraw> {
        return upbitExchangeAsyncService.getWithdraws(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            limit = limit,
            page = page,
            orderBy = orderBy
        ).joining()
    }

    override fun getWithdraw(uuid: String, txid: String?, currency: String?): UpbitWithdraw {
        return upbitExchangeAsyncService.getWithdraw(uuid, txid, currency).joining()
    }

    override fun getWithdrawsChance(currency: String): UpbitWithdrawsChance {
        return upbitExchangeAsyncService.getWithdrawsChance(currency).joining()
    }

    override fun postWithdrawCoin(
        currency: String,
        amount: String,
        address: String,
        secondaryAddress: String?,
        transactionType: String?
    ): UpbitWithdrawCoinPost {
        return upbitExchangeAsyncService.postWithdrawCoin(
            currency = currency,
            amount = amount,
            address = address,
            secondaryAddress = secondaryAddress,
            transactionType = transactionType
        ).joining()
    }

    override fun postWithdrawKrw(amount: String): UpbitWithdrawKrwPost {
        return upbitExchangeAsyncService.postWithdrawKrw(amount).joining()
    }

    override fun getDeposits(
        currency: String?,
        state: String?,
        uuids: List<String>,
        txids: List<String>,
        limit: Int?,
        page: Int?,
        orderBy: String?
    ): List<UpbitDeposit> {
        return upbitExchangeAsyncService.getDeposits(
            currency = currency,
            state = state,
            uuids = uuids,
            txids = txids,
            page = page,
            limit = limit,
            orderBy = orderBy
        ).joining()
    }

    override fun getDeposit(uuid: String, txid: String?, currency: String?): UpbitDeposit {
        return upbitExchangeAsyncService.getDeposit(uuid, txid, currency).joining()
    }

    override fun createDepositCoinAddress(currency: String): UpbitCreateDepositCoinAddress {
        return upbitExchangeAsyncService.createDepositCoinAddress(currency).joining()
    }

    override fun getDepositsCoinAddresses(): List<UpbitDepositCoinAddress> {
        return upbitExchangeAsyncService.getDepositsCoinAddresses().joining()
    }

    override fun getDepositsCoinAddress(currency: String): UpbitDepositCoinAddress {
        return upbitExchangeAsyncService.getDepositsCoinAddress(currency).joining()
    }

    override fun postDepositKrw(amount: String): UpbitDepositKrw {
        return upbitExchangeAsyncService.postDepositKrw(amount).joining()
    }

    override fun getWalletStatus(): List<UpbitWalletStatus> {
        return upbitExchangeAsyncService.getWalletStatus().joining()
    }

    override fun getApiKeys(): List<UpbitApiKey> {
        return upbitExchangeAsyncService.getApiKeys().joining()
    }
}
