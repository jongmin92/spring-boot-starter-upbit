package com.jongmin.upbit.exchange.withdraw

interface UpbitWithdrawsService {

    /**
     * 출금 리스트 조회
     *
     * @param currency Currency 코드
     * @param state 출금 상태
     * @param uuids 출금 UUID의 목록
     * @param txids 출금 TXID의 목록
     * @param limit 갯수 제한
     * @param page 요청 페이지
     * @param orderBy 정렬
     * @return 출금 리스트
     */
    fun getWithdraws(
        currency: String, state: String, uuids: List<String>, txids: List<String>, limit: Int,
        page: Int, orderBy: String
    ): UpbitWithdraws
}
