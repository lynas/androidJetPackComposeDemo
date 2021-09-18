package com.lynas.mailapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lynas.mailapp.ui.theme.MailAppTheme
import com.lynas.mailapp.ui.view.HomeView
import com.lynas.mailapp.ui.view.LoginView

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MailAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AppViewNavigator()
                }
            }
        }
    }
}

@Composable
fun AppViewNavigator() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = VIEW_LOGIN){
        composable(VIEW_LOGIN){
            LoginView(navController)
        }
        composable(VIEW_HOME){
            HomeView()
        }
    }

}

// View names
const val VIEW_LOGIN = "LoginView"
const val VIEW_HOME = "HomeView"