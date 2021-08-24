package com.jongmin.upbit.token

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import java.math.BigInteger
import java.security.MessageDigest

class TokenServiceImpl(
    private val properties: TokenProperties,
    private val nonceGenerator: () -> String
) : TokenService {
    override fun createToken(parameter: Map<String, Any>): String {
        return Jwts.builder().apply {
            claim("access_key", properties.accessKey)
            claim("nonce", nonceGenerator())
            if (parameter.isNotEmpty()) {
                claim("query_hash", parameter.toQueryString().hashing())
                claim("query_hash_alg", "SHA512")
            }
            signWith(Keys.hmacShaKeyFor(properties.secretKey.toByteArray()))
        }.compact()
    }
}

fun Map<String, Any>.toQueryString(): String {
    // TODO
    return "queryString"
}

fun String.hashing(): String {
    val md = MessageDigest.getInstance("SHA-512")
    md.update(this.toByteArray())
    return String.format("%0128x", BigInteger(1, md.digest()))
}
