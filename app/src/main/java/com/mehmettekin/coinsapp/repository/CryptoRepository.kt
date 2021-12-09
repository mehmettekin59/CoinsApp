package com.mehmettekin.coinsapp.repository

import com.mehmettekin.coinsapp.model.Crypto
import com.mehmettekin.coinsapp.model.CryptoList
import com.mehmettekin.coinsapp.service.CryptoAPI
import com.mehmettekin.coinsapp.util.Constants.API_KEY
import com.mehmettekin.coinsapp.util.Constants.CALL_ATTRIBUTES
import com.mehmettekin.coinsapp.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoAPI
){
    suspend fun getCryptoList(): Resource<CryptoList>{
        val response = try {
                api.getCryptoList(API_KEY)
        }catch (e: Exception){
           return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY, id, CALL_ATTRIBUTES)
        }catch (e: Exception){
            return Resource.Error("Sorry ! You have a error")
        }
        return Resource.Success(response)
    }

}