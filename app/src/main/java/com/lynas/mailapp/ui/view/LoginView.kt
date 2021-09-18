package com.lynas.mailapp.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lynas.mailapp.VIEW_HOME

@Composable
fun LoginView(navHostController: NavHostController) {
    val viewName = "LoginView"

    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mail App",
            modifier = Modifier.padding(16.dp),
            fontSize = 30.sp
        )
        Text(
            text = "Sign In View",
            modifier = Modifier.padding(16.dp),
            fontSize = 20.sp
        )
        TextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("User Name") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            )
        )
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            onClick = {
                println(userName)
                println(password)
                navHostController.navigate(route = "$VIEW_HOME/$userName")
            },
            modifier = Modifier.padding(16.dp),

            ) {
            Text(text = "Log in")
        }

    }

}
