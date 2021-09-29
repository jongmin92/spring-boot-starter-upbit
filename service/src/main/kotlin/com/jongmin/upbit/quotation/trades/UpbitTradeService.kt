package com.jongmin.upbit.quotation.trades

interface UpbitTradeService {

    /**
     * 최근 체결 내역
     * 최근 체결된 내역의 리스트들을 보여줌.
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param market 마켓 코드,
     * @param to 마지막 체결 시각 범위 [HHmmss or HH:mm:ss]
     * @param count 체결 개수
     * @param cursor 페이지네이션 커서 (sequentialId)
     * @param daysAgo 최근 체결 날짜 기준 이전 날짜 ( 7일까지 가능)
     * @return 체결 내역 리스트
     */
    fun getUpbitTicks(
        market: String,
        to: String? = null,
        count: Int? = null,
        cursor: String? = null,
        daysAgo: Int? = null
    ): List<UpbitTick>
}
