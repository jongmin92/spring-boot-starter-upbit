package com.jongmin.upbit.exchange.withdraw

import kotlinx.coroutines.Deferred

interface UpbitWithdrawsCoroutineService {

    /**
     * 출금 리스트 조회
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param currency Currency 코드
     * @param state 출금 상태
     *   -submitting : 처리 중
     *   -submitted : 처리 완료
     *   -almost_accepted : 출금대기중
     *   -rejected : 거부
     *   -accepted : 승인됨
     *   -processing : 처리 중
     *   -done : 완료
     *   -canceled : 취소됨
     * @param uuids 출금 UUID의 목록
     * @param txids 출금 TXID의 목록
     * @param limit 갯수 제한
     *   -default: 100, max: 100
     * @param page 요청 페이지
     *   -default: 1
     * @param orderBy 정렬
     *   -asc: 오름차순
     *   -desc: 내림차순(default)
     * @return 출금 리스트
     */
    fun getWithdraws(
        currency: String? = null,
        state: String? = null,
        uuids: List<String> = emptyList(),
        txids: List<String> = emptyList(),
        limit: Int? = null,
        page: Int? = null,
        orderBy: String? = null
    ): Deferred<List<UpbitWithdraw>>

    /**
     * 개별 출금 조회
     * 출금 UUID를 통해 개별 출금 정보를 조회한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param uuid 출금 UUID
     * @param txid 출금 TXID
     * @param currency Currency 코드
     * @return 개별 출금 정보
     */
    fun getWithdraw(uuid: String, txid: String? = null, currency: String? = null): Deferred<UpbitWithdraw>

    /**
     * 출금 가능 정보
     * 해당 통화의 가능한 출금 정보를 확인한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param currency Currency 코드
     * @return 해당 통화의 가능한 출금 정보
     */
    fun getWithdrawsChance(currency: String): Deferred<UpbitWithdrawsChance>

    /**
     * 코인 출금하기
     * 코인 출금을 요청한다.
     *
     * - 허용된 지갑 주소로만 출금을 진행할 수 있습니다.
     * - Open API를 이용하여 출금을 진행하기 위해서는 출금허용주소 등록이 필요합니다. 다음 페이지에서 출금 주소를 등록해주시길 바랍니다.
     * - 업비트 웹 [마이페이지\] > [Open API 관리] > [암호화폐 출금주소 관리] 탭
     *
     * - 업비트 회원의 지갑 주소로만 바로출금을 진행할 수 있습니다.
     * - 업비트 회원의 주소가 아닌 주소로 바로출금을 요청하는 경우, 출금이 정상적으로 수행되지 않습니다.
     * - 반드시 주소를 확인 후 출금을 진행하시기 바랍니다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param currency Currency 코드
     * @param amount 출금 코인 수량
     * @param address 출금 지갑 주소
     * @param secondaryAddress 2차 출금주소 (필요한 코인에 한해서)
     * @param transactionType 출금 유형
     *   -default: 일반출금
     *   -internal: 바로출금
     * @return 코인 출금 결과
     */
    fun postWithdrawCoin(
        currency: String, amount: String, address: String, secondaryAddress: String? = null,
        transactionType: String? = null
    ): Deferred<UpbitWithdrawCoinPost>

    /**
     * 원화 출금하기
     * 원화 출금을 요청한다. 등록된 출금 계좌로 출금된다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param amount 출금 원화 수량
     * @return 원화 출금 결과
     */
    fun postWithdrawKrw(amount: String): Deferred<UpbitWithdrawKrwPost>
}
