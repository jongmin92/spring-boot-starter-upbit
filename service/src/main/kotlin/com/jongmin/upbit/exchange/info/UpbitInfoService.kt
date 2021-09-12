package com.jongmin.upbit.exchange.info

interface UpbitInfoService {

    /**
     * 입출금 현황
     * 입출금 현황 및 블록 상태를 조회합니다.
     *
     * @return 입출금 현황 및 블록 상태
     */
    fun getWalletStatus(): List<UpbitWalletStatus>

    /**
     * API 키 리스트 조회
     * API 키 목록 및 만료 일자를 조회합니다.
     *
     * @return API 키 목록 및 만료 일자
     */
    fun getApiKeys(): List<UpbitApiKey>
}
