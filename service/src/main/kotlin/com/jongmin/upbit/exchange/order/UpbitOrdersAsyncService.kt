package com.jongmin.upbit.exchange.order

import java.util.concurrent.CompletableFuture

interface UpbitOrdersAsyncService {

    /**
     * 주문 가능 정보.
     * 마켓별 주문 가능 정보를 확인한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param market Market ID
     * @return 마켓별 주문 가능 정보
     */
    fun getOrdersChance(market: String): CompletableFuture<UpbitOrdersChance>

    /**
     * 개별 주문 조회.
     * 주문 UUID 를 통해 개별 주문건을 조회한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param uuid 주문 UUID
     * @param identifier 조회용 사용자 지정 값
     * (uuid, identifier 둘 중 하나의 값이 반드시 포함되어야 합니다.)
     * @return 개별 주문건
     */
    fun getOrder(uuid: String? = null, identifier: String? = null): CompletableFuture<UpbitOrderWithTrades>

    /**
     * 주문 리스트 조회.
     * 주문 리스트를 조회한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param market Market ID
     * @param state 주문 상태
     *   -wait: 체결 대기(default)
     *   -watch: 예약주문 대기
     *   -done: 전체 체결 완료
     *   -cancel: 주문 취소
     * @param states 주문 상태의 목록
     *  -미체결 주문(wait, watch)과 완료 주문(done, cancel)은 혼합하여 조회하실 수 없습니다.
     * @param uuids 주문 UUID의 목록
     * @param identifiers 주문 identifier의 목록
     * @param page 요청 페이지
     *   -default: 1
     * @param limit 요청 개수 (1 ~ 100)
     *   -default: 100
     * @param orderBy 정렬
     *   -asc: 오름차순
     *   -desc: 내림차순(default)
     * (2021년 3월 22일부터 미체결 주문(wait, watch)과 완료 주문(done, cancel)을 혼합하여 조회하실 수 없습니다.
     *  예시1) done, cancel 주문을 한 번에 조회 => 가능
     *  예시2) wait, done 주문을 한 번에 조회 => 불가능 (각각 API 호출 필요))
     * @return 주문 리스트
     */
    fun getOrders(
        market: String? = null,
        state: String? = null,
        states: List<String> = emptyList(),
        uuids: List<String> = emptyList(),
        identifiers: List<String> = emptyList(),
        page: Int? = null,
        limit: Int? = null,
        orderBy: String? = null
    ): CompletableFuture<List<UpbitOrder>>

    /**
     * 주문 취소 접수.
     * 주문 UUID를 통해 해당 주문에 대한 취소 접수를 한다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param uuid 주문 UUID
     * @param identifier 조회용 사용자 지정값
     * @return 주문 취소
     */
    fun deleteOrder(uuid: String? = null, identifier: String? = null): CompletableFuture<UpbitOrderDelete>

    /**
     * 주문하기.
     * 주문 요청을 한다.
     *
     * - 원화 마켓 가격 단위를 확인하세요.
     *   - 원화 마켓에서 주문을 요청 할 경우, 원화 마켓 주문 가격 단위 를 확인하여 값을 입력해주세요.
     * - 시장가 주문
     *   - 시장가 주문은 ord_type 필드를 price or market 으로 설정해야됩니다.
     *   - 매수 주문의 경우 ord_type을 price로 설정하고 volume을 null 혹은 제외해야됩니다.
     *   - 매도 주문의 경우 ord_type을 market로 설정하고 price을 null 혹은 제외해야됩니다.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param market Market ID
     * @param side 주문 종류
     *   -bid: 매수
     *   -ask: 매도
     * @param volume 주문 수량 (지정가, 시장가 매도 시 필수)
     * @param price 유닛당 주문 가격 (지정가, 시장가 매수 시 필수)
     *   -ex) KRW-BTC 마켓에서 1BTC당 1,000 KRW로 거래할 경우, 값은 1000 이 된다.
     *   -ex) KRW-BTC 마켓에서 1BTC당 매도 1호가가 500 KRW 인 경우, 시장가 매수 시 값을 1000으로 세팅하면 2BTC가 매수된다.
     *   -(수수료가 존재하거나 매도 1호가의 수량에 따라 상이할 수 있음)
     * @param ordType 주문 타입
     *   -limit: 지정가 주문
     *   -price: 시장가 주문(매수)
     *   -market: 시장가 주문(매도)
     * @param identifier 조회용 사용자 지정 값
     *   -서비스에서 발급하는 uuid가 아닌 이용자가 직접 발급하는 키값으로, 주문을 조회하기 위해 할당하는 값입니다.
     *   -해당 값은 사용자의 전체 주문 내 유일한 값을 전달해야하며, 비록 주문 요청시 오류가 발생하더라도 같은 값으로 다시 요청을 보낼 수 없습니다.
     *   -주문의 성공 / 실패 여부와 관계없이 중복해서 들어온 identifier 값에서는 중복 오류가 발생하니, 매 요청시 새로운 값을 생성해주세요.
     * @return 주문 결과
     */
    fun postOrder(
        market: String, side: String, volume: String, price: String, ordType: String, identifier: String? = null
    ): CompletableFuture<UpbitOrderPost>
}
