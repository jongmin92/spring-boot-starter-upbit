package com.jongmin.upbit.client.retrofit

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.linecorp.armeria.client.retrofit2.ArmeriaRetrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitApiFactoryService(
    private val apiBaseUrl: String
) {
    fun <T> default(clazz: Class<T>): T =
        ArmeriaRetrofit.builder(apiBaseUrl)
            .addConverterFactory(JacksonConverterFactory.create(jacksonObjectMapper().apply {
                configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            }))
            .build()
            .create(clazz)
}
