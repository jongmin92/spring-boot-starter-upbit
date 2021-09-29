package com.jongmin.upbit.exchange.deposit

import kotlinx.coroutines.Deferred

interface UpbitDepositsCoroutineService {

    /**
     * 입금 리스트 조회
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param currency Currency 코드
     * @param state 입금 상태
     *  -submitting: 처리 중
     *  -submitted: 처리완료
     *  -almost_accepted: 입금 대기 중
     *  -rejected: 거절
     *  -accepted: 승인됨
     *  -processing: 처리 중
     * @param uuids 입금 UUID의 목록
     * @param txids 입금 TXID의 목록
     * @param limit 페이지당 개수
     *   -default: 100, limit: 100
     * @param page 페이지 번호
     *   -default: 1
     * @param orderBy 정렬 방식
     *   -asc: 오름차순
     *   -desc: 내림차순(default)
     * @return 입금 리스트
     */
    fun getDeposits(
        currency: String? = null,
        state: String? = null,
        uuids: List<String> = emptyList(),
        txids: List<String> = emptyList(),
        limit: Int? = null,
        page: Int? = null,
        orderBy: String? = null
    ): Deferred<List<UpbitDeposit>>

    /**
     * 개별 입금 조회
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param uuid 개별 입금의 UUID
     * @param txid 개별 입금의 TXID
     * @param currency Currency 코드
     * @return 개별 입금 정보
     */
    fun getDeposit(uuid: String, txid: String? = null, currency: String? = null): Deferred<UpbitDeposit>

    /**
     * 입금 주소 생성 요청
     * 입금 주소 생성을 요청한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * - 입금 주소 생성 요청 API 유의사항
     *   - 입금 주소의 생성은 서버에서 비동기적으로 이뤄집니다.
     *   - 비동기적 생성 특성상 요청과 동시에 입금 주소가 발급되지 않을 수 있습니다.
     *   - 주소 발급 요청 시 결과로 Response1이 반환되며 주소 발급 완료 이전까지 계속 Response1이 반환됩니다.
     *   - 주소가 발급된 이후부터는 새로운 주소가 발급되는 것이 아닌 이전에 발급된 주소가 Response2 형태로 반환됩니다.
     *   - 정상적으로 주소가 생성되지 않는다면 일정 시간 이후 해당 API를 다시 호출해주시길 부탁드립니다.
     *
     * @param currency Currency 코드
     * @return 입금 주소 생성 요청 결과 (주소 발급 이전) 또는 생성 결과 (주소 발급 완료)
     */
    fun createDepositCoinAddress(currency: String): Deferred<UpbitCreateDepositCoinAddress>

    /**
     * 전체 입금 주소 조회
     * 내가 보유한 자산 리스트를 보여줍니다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * - 입금 주소 조회 요청 API 유의사항
     *   - 입금 주소 생성 요청 이후 아직 발급되지 않은 상태일 경우 deposit_address가 null일 수 있습니다.
     *
     * @return 보유한 입금 주소 리스트
     */
    fun getDepositsCoinAddresses(): Deferred<List<UpbitDepositCoinAddress>>

    /**
     * 개별 입금 주소 조회
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * - 입금 주소 조회 요청 API 유의사항
     *   - 입금 주소 생성 요청 이후 아직 발급되지 않은 상태일 경우 deposit_address가 null일 수 있습니다.
     *
     * @param currency Currency 코드
     * @return 보유한 입금 주소
     */
    fun getDepositsCoinAddress(currency: String): Deferred<UpbitDepositCoinAddress>

    /**
     * 원화 입금하기
     * 원화 입금을 요청한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param amount 입금액
     * @return 입금 결과
     */
    fun postDepositKrw(amount: String): Deferred<UpbitDepositKrw>
}
