package com.jongmin.upbit.exchange.info

interface UpbitInfoService {

    /**
     * 입출금 현황
     * 입출금 현황 및 블록 상태를 조회합니다.
     *
     * @return 입출금 현황 및 블록 상태
     */
    fun getWalletStatus(): UpbitWalletStatus
}
