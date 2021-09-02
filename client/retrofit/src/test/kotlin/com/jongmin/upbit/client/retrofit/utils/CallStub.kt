package com.jongmin.upbit.client.retrofit.utils

import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import retrofit2.Call
import retrofit2.Response

internal fun <T> success(response: T): Call<T> {
    return mock {
        on { execute() } doReturn Response.success(response)
    }
}
