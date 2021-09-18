package com.lynas.mailapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lynas.mailapp.ui.view.HomeView
import com.lynas.mailapp.ui.view.LoginView


// View names
const val VIEW_LOGIN = "LoginView"
const val VIEW_HOME = "HomeView"

// View Argument names
const val VIEW_HOME_ARG_USER_NAME = "userName"


@Composable
fun AppViewNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = VIEW_LOGIN) {
        composable(VIEW_LOGIN) {
            LoginView(navController)
        }
        composable(
            route = "$VIEW_HOME/{$VIEW_HOME_ARG_USER_NAME}",
            arguments = listOf(navArgument(name = VIEW_HOME_ARG_USER_NAME) {})
        ) {
            HomeView(username = it.arguments?.getString(VIEW_HOME_ARG_USER_NAME))
        }
    }

}


