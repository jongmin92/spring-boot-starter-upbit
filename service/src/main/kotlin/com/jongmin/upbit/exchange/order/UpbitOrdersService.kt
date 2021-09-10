package com.jongmin.upbit.exchange.order

interface UpbitOrdersService {

    /**
     * 주문 가능 정보
     * 마켓별 주문 가능 정보를 확인한다.
     *
     * @param market Market ID
     * @return 마켓별 주문 가능 정보
     */
    fun getOrdersChance(market: String): UpbitOrdersChance

    /**
     * 개별 주문 조회
     * 주문 UUID 를 통해 개별 주문건을 조회한다.
     *
     * @param uuid 주문 UUID
     * @param identifier 조회용 사용자 지정 값
     * @return 개별 주문건
     */
    fun getOrder(uuid: String? = null, identifier: String? = null): UpbitOrderIncludingTrades

    /**
     * 주문 리스트 조회
     * 주문 리스트를 조회한다.
     *
     * @param market Market ID
     * @param state 주문 상태
     * @param uuids 주문 UUID의 목록
     * @param identifiers 주문 identifier의 목록
     * @param page 요청 페이지
     * @param limit 요청 개수 (1 ~ 100)
     * @param orderBy 정렬
     * @return 주문 리스트
     */
    fun getOrders(
        market: String, state: String, states: List<String>, uuids: List<String>, identifiers: List<String>,
        page: Int = 1, limit: Int = 100, orderBy: String = "desc"
    ): List<UpbitOrder>

    /**
     * 주문 취소 접수
     * 주문 UUID를 통해 해당 주문에 대한 취소 접수를 한다.
     *
     * @param uuid 주문 UUID
     * @param identifier 조회용 사용자 지정값
     * @return 주문 취소
     */
    fun deleteOrder(uuid: String?, identifier: String?): UpbitOrderDelete

    /**
     * 주문하기
     * 주문 요청을 한다.
     *
     * @param market Market ID
     * @param side 주문 종류
     * @param volume 주문 수량
     * @param price 유닛당 주문 가격
     * @param ordType 주문 타입
     * @param identifier 조회용 사용자 지정 값
     * @return 주문 결과
     *
     */
    fun postOrder(
        market: String, side: String, volume: String, price: String, ordType: String, identifier: String?
    ): UpbitOrderPost
}
