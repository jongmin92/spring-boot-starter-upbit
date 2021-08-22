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

    /**
     * 개별 출금 조회
     * 출금 UUID를 통해 개별 출금 정보를 조회한다.
     *
     * @param uuid 출금 UUID
     * @param txid 출금 TXID
     * @param currency Currency 코드
     * @return 개별 출금 정보
     */
    fun getWithdraw(uuid: String, txid: String, currency: String): UpbitWithdraw

    /**
     * 출금 가능 정보
     * 해당 통화의 가능한 출금 정보를 확인한다.
     *
     * @param currency Currency 코드
     * @return 해당 통화의 가능한 출금 정보
     */
    fun getWithdrawsChance(currency: String): UpbitWithdrawsChance
}
