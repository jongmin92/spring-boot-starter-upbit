package com.jongmin.upbit.quotation.candles

import java.util.concurrent.CompletableFuture

interface UpbitCandleAsyncService {

    /**
     * 분봉 캔들 조회
     *
     * @throws com.jongmin.upbit.UpbitException
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
        to: String? = null,
        count: Int? = null
    ): CompletableFuture<List<UpbitMinuteCandle>>

    /**
     * 일별 캔들을 조회
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param market 마켓 코드
     * @param to 마지막 캔들시각 (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * @param count 캔들 개수
     * @param convertingPriceUnit 종가 환산 화폐 단위
     * @return 일(Day) 캔들
     */
    fun getUpbitDayCandles(
        market: String,
        to: String? = null,
        count: Int? = null,
        convertingPriceUnit: String? = null
    ): CompletableFuture<List<UpbitDayCandle>>

    /**
     * 주별 캔들 조회
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param market 마켓 코드
     * @param to 마지막 캔들시각 (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * @param count 캔들 개수
     * @return 주(Week) 캔들
     */
    fun getUpbitWeekCandles(
        market: String,
        to: String? = null,
        count: Int? = null
    ): CompletableFuture<List<UpbitWeekCandle>>

    /**
     * 월별 캔들 조회
     *
     * @throws com.jongmin.upbit.UpbitException
     *
     * @param market 마켓 코드
     * @param to 마지막 캔들시각 (yyyy-MM-dd'T'HH:mm:ss'Z' or yyyy-MM-dd HH:mm:ss)
     * @param count 캔들 개수
     * @return 월(Month) 캔들
     */
    fun getUpbitMonthCandles(
        market: String,
        to: String? = null,
        count: Int? = null
    ): CompletableFuture<List<UpbitMonthCandle>>
}
