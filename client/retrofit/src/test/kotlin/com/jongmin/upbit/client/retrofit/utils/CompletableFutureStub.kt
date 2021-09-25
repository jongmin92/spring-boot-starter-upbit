package com.jongmin.upbit.client.retrofit.utils

import java.util.concurrent.CompletableFuture

internal fun <T> success(response: T): CompletableFuture<T> {
    return CompletableFuture.completedFuture(response)
}
