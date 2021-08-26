package com.jongmin.upbit.quotation.candles

interface UpbitCandleService {

    /**
     * 분봉 캔들 조회
     *
     * @param
     * market: 마켓 코드
     * to: 마지막 캔들시각 (yyyy-MM-dd'T'HH;mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * count: 캔들 개수
     * unit: 분 단위 (유닛)
     *
     * @return 분봉 캔들
     */
    fun getUpbitMinuteCandle(market: String, to: String?, count: Int = 1, unit: Int = 1): MinuteCandles

    /**
     * 일별 캔들을 조회
     *
     * @param
     * market: 마켓 코드
     * to: 마지막 캔들시각 (yyyy-MM-dd'T'HH;mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * count: 캔들 개수
     *
     * @return Day 캔들
     */
    fun getDayCandles(market: String, to: String?, count: Int = 1, convertingPriceUnit: String = "KRW"): DayCandles

    /**
     * 주별 캔들 조회
     *
     * @param
     * market: 마켓 코드
     * to: 마지막 캔들시각 (yyyy-MM-dd'T'HH;mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * count: 캔들 개수
     * unit: 분 단위 (유닛)
     *
     * @return week 캔들
     */
    fun getWeekCandles(market: String, to: String?, count: Int = 1): WeekCandles

    /**
     * 월별 캔들 조회
     *
     *  @param
     * market: 마켓 코드
     * to: 마지막 캔들시각 (yyyy-MM-dd'T'HH;mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * count: 캔들 개수
     *
     * @return Month 캔들
     */
    fun getMonthCandles(market: String, to: String?, count: Int = 1): MonthCandles
}
