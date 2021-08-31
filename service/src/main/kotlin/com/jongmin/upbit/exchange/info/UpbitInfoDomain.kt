package com.jongmin.upbit.exchange.info

data class UpbitWalletStatus(
    /**
     * 설명: 화폐를 의미하는 영문 대문자 코드
     * 타입: String
     */
    val currency: String,

    /**
     * 설명: 입출금 상태
     * 타입: String
     */
    val walletState: String,

    /**
     * 설명: 블록 상태
     * 타입: String
     */
    val blockState: String,

    /**
     * 설명: 블록 높이
     * 타입: Integer
     */
    val blockHeight: String,

    /**
     * 설명: 블록 갱신 시각
     * 타입: DateString
     */
    val blockUpdatedAt: String
)

data class UpbitApiKeys(
    val apiKeys: List<ApiKey>
) {
    data class ApiKey(
        /**
         * 설명: access key
         * 타입: String
         */
        val accessKey: String,

        /**
         * 설명: 만료 시간
         * 타입: String
         */
        val expireAt: String,
    )
}
