package br.com.devhub.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.devhub.ui.theme.Sky200
import br.com.devhub.ui.theme.Sky50
import br.com.devhub.ui.theme.Sky600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginView(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    fun submitLoginData() {
        navController.navigate("home")
    }

    fun navigateToSignUp() {
        navController.navigate("signup")
    }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
            .background(Sky200).padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TextField(
                value = email,
                onValueChange = {
                    if (it.length <= 64) {
                        email = it
                    }
                },
                label = { Text("E-mail:") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp, Sky600, RoundedCornerShape(12.dp)
                ).fillMaxWidth()
            )
            TextField(
                value = password,
                onValueChange = {
                    if (it.length <= 50) {
                        password = it
                    }
                },
                label = { Text("Senha:") },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp, Sky600, RoundedCornerShape(12.dp)
                ).fillMaxWidth()
            )
            Button(
                onClick = { submitLoginData() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Sky600
                )
            ) {
                Text("Entrar")
            }
            Button(
                onClick = { navigateToSignUp() },
                modifier = Modifier.fillMaxWidth().background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text("Não tem acesso. Cadastra-se")
            }
        }
    }
}