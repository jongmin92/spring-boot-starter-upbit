package com.jongmin.upbit.exchange.info

data class UpbitWalletStatus(
    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    val currency: String,

    /**
     * 설명: 입출금 상태
     *   -working: 입출금 가능
     *   -withdraw_only: 출금만 가능
     *   -deposit_only: 입금만 가능
     *   -paused: 입출금 중단
     *   -unsupported: 입출금 미지원
     * 타입: String
     */
    val walletState: String,

    /**
     * 설명: 블록 상태
     *   -normal: 정상
     *   -delayed: 지연
     *   -inactive: 비활성 (점검 등)
     * 타입: String
     */
    val blockState: String,

    /**
     * 설명: 블록 높이
     * 타입: Integer
     */
    val blockHeight: Int,

    /**
     * 설명: 블록 갱신 시각
     * 타입: DateString
     */
    val blockUpdatedAt: String
)

data class UpbitApiKey(
    /**
     * 설명: access key
     * 타입: String
     */
    val accessKey: String,

    /**
     * 설명: 만료 시간
     * 타입: String
     */
    val expireAt: String
)
