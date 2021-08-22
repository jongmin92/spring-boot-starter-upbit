package com.jongmin.upbit.exchange.order

interface UpbitOrdersService {

    /**
     * 개별 주문 조회
     * 주문 UUID 를 통해 개별 주문건을 조회한다.
     *
     * @param uuid 주문 UUID
     * @param identifier 조회용 사용자 지정 값
     * @return 개별 주문건
     */
    fun getOrder(uuid: String, identifier: String): UpbitOrder

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
        page: Int, limit: Int, orderBy: String
    ): UpbitOrders

    /**
     * 주문 가능 정보
     * 마켓별 주문 가능 정보를 확인한다.
     *
     * @param market Market ID
     * @return 마켓별 주문 가능 정보
     */
    fun getOrdersChance(market: String): UpbitOrdersChance
}
