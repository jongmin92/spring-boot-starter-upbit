# spring-boot-starter-upbit

![GitHub release (latest by date)](https://img.shields.io/github/v/release/jongmin92/spring-boot-starter-upbit)
[![build](https://github.com/jongmin92/spring-boot-starter-upbit/actions/workflows/build.yml/badge.svg?branch=master&event=push)](https://github.com/jongmin92/spring-boot-starter-upbit/actions/workflows/build.yml)
![GitHub](https://img.shields.io/github/license/jongmin92/spring-boot-starter-upbit)

This is an Upbit Open API Client Spring Boot Starter based on
the [Upbit v1.2.0 reference](https://docs.upbit.com/reference).

## Download

```
repositories {
    mavenCentral()
}

dependencies {
    implementation("io.github.jongmin92:upbit-service-spring-boot-starter:1.0.0")
}
```

## Useage

### Set API Keys

To use it, must issue an API key from [마이페이지 - Open API 관리](https://www.upbit.com/mypage/open_api_management).  
And set the issued API key on `application.yml(properties)`.

```yaml
upbit:
  client:
    access-key: { accessKey }
    secret-key: { secretKey }
```

### Interface

This provides services for Sync, Async, and Coroutine interface.

- `UpbitExchangeService` provides functionality for the `EXCHANGE API`.
- `UpbitQuotationService` provides functionality for the `QUOTATION API`.

#### Sync

```kotlin
@Autowired
lateinit var upbitExchangeService: UpbitExchangeService

@Autowired
lateinit var upbitQuotationService: UpbitQuotationService
```

#### Async

return `CompletableFuture<T>`

```kotlin
@Autowired
lateinit var upbitExchangeAsyncService: UpbitExchangeAsyncService

@Autowired
lateinit var upbitQuotationAsyncService: UpbitQuotationAsyncService
```

#### Coroutine

return `Deferred<T>`

```kotlin
@Autowired
lateinit var upbitExchangeCoroutineService: UpbitExchangeCoroutineService

@Autowired
lateinit var upbitQuotationCoroutineService: UpbitQuotationCoroutineService
```

## License

[MIT](https://github.com/jongmin92/spring-boot-starter-upbit/blob/master/LICENSE)
