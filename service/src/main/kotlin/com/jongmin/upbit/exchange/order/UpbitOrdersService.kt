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
}
