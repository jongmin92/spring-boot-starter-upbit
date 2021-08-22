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

    /**
     * 개별 입금 조회
     *
     * @param uuid 개별 입금의 UUID
     * @param txid 개별 입금의 TXID
     * @param currency Currency 코드
     * @return 개별 입금 정보
     */
    fun getDeposit(uuid: String, txid: String, currency: String): UpbitDeposit

    /**
     * 입금 주소 생성 요청
     * 입금 주소 생성을 요청한다.
     *
     * @param currency Currency 코드
     * @return 입금 주소 생성 요청 결과 (주소 발급 이전)
     */
    fun createDepositCoinAddress(currency: String): UpbitCreateDepositCoinAddress

    /**
     * 입금 주소 생성 결과 확인
     * 입금 주소 생성 결과를 확인한다.
     *
     * @param currency Currency 코드
     * @return 입금 주소 생성 결과 (주소 발급 완료)
     */
    fun verifyToCreateDepositCoinAddress(currency: String): UpbitCreatedDepositCoinAddress
}
