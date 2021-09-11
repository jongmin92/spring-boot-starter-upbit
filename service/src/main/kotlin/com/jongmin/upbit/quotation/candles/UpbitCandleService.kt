package com.jongmin.upbit.quotation.candles

interface UpbitCandleService {

    /**
     * 분봉 캔들 조회
     *
     * @param unit 분 단위
     * @param market 마켓 코드
     * @param to 마지막 캔들시각 (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * @param count 캔들 개수
     * @return 분(Minute) 캔들
     */
    fun getUpbitMinuteCandle(
        unit: Int = 1,
        market: String,
        to: String? = "",
        count: Int? = 1
    ): List<UpbitMinuteCandle>

    /**
     * 일별 캔들을 조회
     *
     * @param market 마켓 코드
     * @param to 마지막 캔들시각 (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * @param count 캔들 개수
     * @param convertingPriceUnit 종가 환산 화폐 단위
     * @return 일(Day) 캔들
     */
    fun getDayCandles(
        market: String,
        to: String? = "",
        count: Int? = 1,
        convertingPriceUnit: String? = "KRW"
    ): List<UpbitDayCandle>

    /**
     * 주별 캔들 조회
     *
     * @param market 마켓 코드
     * @param to 마지막 캔들시각 (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * @param count 캔들 개수
     * @return 주(Week) 캔들
     */
    fun getWeekCandles(
        market: String,
        to: String? = "",
        count: Int? = 1
    ): List<UpbitWeekCandle>

    /**
     * 월별 캔들 조회
     *
     * @param market 마켓 코드
     * @param to 마지막 캔들시각 (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * @param count 캔들 개수
     * @return 월(Month) 캔들
     */
    fun getMonthCandles(
        market: String,
        to: String? = "",
        count: Int? = 1
    ): List<UpbitMonthCandle>
}
