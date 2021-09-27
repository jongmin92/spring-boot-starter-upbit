package com.jongmin.upbit.client.retrofit

import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException

fun <T> CompletableFuture<T>.joining(): T = try {
    join()
} catch (e: CompletionException) {
    throw e.cause ?: e
}
