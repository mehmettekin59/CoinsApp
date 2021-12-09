package com.mehmettekin.coinsapp.service

import com.mehmettekin.coinsapp.model.Crypto
import com.mehmettekin.coinsapp.model.CryptoList
import retrofit2.http.GET
import retrofit2.http.Query


interface CryptoAPI {
    //https://api.nomics.com/v1/prices?key=9e300b00e01124c032542c65e9d13075395f5ef6
    //https://api.nomics.com/v1/currencies?key=9e300b00e01124c032542c65e9d13075395f5ef6&ids=BTC&attributes=id,name,logo_url

    @GET("prices")
    suspend fun getCryptoList(
        @Query("key") key: String
    ): CryptoList

    @GET("currencies")
    suspend fun getCrypto(
        @Query("key") key: String,
        @Query("ids") id: String,
        @Query("attributes") attributes: String
    ): Crypto

}