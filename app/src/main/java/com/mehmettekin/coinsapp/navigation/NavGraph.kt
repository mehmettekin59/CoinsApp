package com.mehmettekin.coinsapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mehmettekin.coinsapp.view.CryptoDetailScreen
import com.mehmettekin.coinsapp.view.CryptoListScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(
            Screen.Home.route
        ){
            CryptoListScreen(navController = navController)
        }

        composable(
            Screen.Detail.route,
            arguments = listOf(
                navArgument(ID){
                    type = NavType.StringType
                },
                navArgument(PRICE){
                    type = NavType.StringType
                }
            )
        ){
            val id = remember {it.arguments?.getString(ID)!!}
            val price = remember {it.arguments?.getString(PRICE)!!}
            CryptoDetailScreen(navController = navController, id = id, price = price)
        }
    }

}