package com.jongmin.upbit.exchange.info

import java.util.concurrent.CompletableFuture

interface UpbitInfoAsyncService {

    /**
     * 입출금 현황
     * 입출금 현황 및 블록 상태를 조회합니다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * - 입출금 현황 데이터는 실제 서비스 상태와 다를 수 있습니다.
     *   - 입출금 현황 API에서 제공하는 입출금 상태, 블록 상태 정보는 수 분 정도 지연되어 반영될 수 있습니다.
     *   - 본 API는 참고용으로만 사용하시길 바라며 실제 입출금을 수행하기 전에는 반드시 업비트 공지사항 및 입출금 현황 페이지를 참고해주시기 바랍니다.
     *
     * @return 입출금 현황 및 블록 상태
     */
    fun getWalletStatus(): CompletableFuture<List<UpbitWalletStatus>>

    /**
     * API 키 리스트 조회
     * API 키 목록 및 만료 일자를 조회합니다.
     *
     * @return API 키 목록 및 만료 일자
     */
    fun getApiKeys(): CompletableFuture<List<UpbitApiKey>>
}
