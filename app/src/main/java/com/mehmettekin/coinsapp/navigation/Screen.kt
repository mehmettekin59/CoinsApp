package com.mehmettekin.coinsapp.navigation


const val ID = "id"
const val PRICE = "price"

sealed class Screen(val route: String){
    object Home: Screen( route = "crypto_list_screen")
    object Detail: Screen(route = "crypto_detail_screen/{$ID}/{$PRICE}"){
        fun passIdAndPrice(id: String, price: String): String{
            return "crypto_detail_screen/{$id}/{$price}"
        }
    }
}
