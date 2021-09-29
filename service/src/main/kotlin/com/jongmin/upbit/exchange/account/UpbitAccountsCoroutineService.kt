package com.jongmin.upbit.exchange.account

import kotlinx.coroutines.Deferred

interface UpbitAccountsCoroutineService {

    /**
     * 전체 계좌 조회.
     * 내가 보유한 자산 리스트를 보여줍니다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @return 자산 리스트
     */
    fun getAccounts(): Deferred<List<UpbitAccount>>
}
