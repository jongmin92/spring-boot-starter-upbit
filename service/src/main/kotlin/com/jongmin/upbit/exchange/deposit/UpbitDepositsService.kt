package com.jongmin.upbit.exchange.deposit

interface UpbitDepositsService {

    /**
     * 입금 리스트 조회
     *
     * @param currency Currency 코드
     * @param state 입금 상태
     * @param uuids 입금 UUID의 목록
     * @param txids 입금 TXID의 목록
     * @param limit 페이지당 개수
     * @param page 페이지 번호
     * @param orderBy 정렬 방식
     * @return 입금 리스트
     */
    fun getDeposits(
        currency: String, state: String, uuids: List<String>, txids: List<String>, limit: Int,
        page: Int, orderBy: String
    ): List<UpbitDeposits>
}
