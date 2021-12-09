package com.mehmettekin.coinsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.mehmettekin.coinsapp.model.Crypto
import com.mehmettekin.coinsapp.repository.CryptoRepository
import com.mehmettekin.coinsapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
):ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto>{
        return repository.getCrypto(id)
    }
}