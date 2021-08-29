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
        currency: String, state: String, uuids: List<String>, txids: List<String>, limit: Int = 1,
        page: Int = 100, orderBy: String = "desc"
    ): List<UpbitWithdraw>

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

    /**
     * 코인 출금하기
     * 코인 출금을 요청한다.
     *
     * @param currency Currency 코드
     * @param amount 출금 코인 수량
     * @param address 출금 지갑 주소
     * @param secondaryAddress 2차 출금주소 (필요한 코인에 한해서)
     * @param transactionType 출금 유형
     * @return 코인 출금 결과
     */
    fun postWithdrawCoin(
        currency: String, amount: String, address: String, secondaryAddress: String?,
        transactionType: String?
    ): UpbitWithdrawCoinPost

    /**
     * 원화 출금하기
     * 원화 출금을 요청한다. 등록된 출금 계좌로 출금된다.
     *
     * @param amount 출금 원화 수량
     * @return 원화 출금 결과
     */
    fun postWithdrawKrw(amount: String): UpbitWithdrawKrwPost
}
