package br.com.devhub.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.devhub.dto.UserDTO
import br.com.devhub.models.User
import br.com.devhub.services.AuthenticationService
import br.com.devhub.ui.theme.Sky200
import br.com.devhub.ui.theme.Sky50
import br.com.devhub.ui.theme.Sky600

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUpView(navController: NavController) {
    val applicationContext = LocalContext.current
    val authenticationService: AuthenticationService = viewModel()

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var cellPhone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    fun emitToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    fun navigateToLogin() {
        navController.navigate("login")
    }

    fun navigateToHome() {
        navController.navigate("home")
    }

    fun submitSignUpData() {
        val user = UserDTO(
            firstName = firstName,
            lastName = lastName,
            email = email,
            cellPhone = cellPhone,
            password = password
        )

        if (user.firstName?.isBlank() == true || user.lastName?.isBlank() == true
            || user.email?.isBlank() == true || user.password?.isBlank() == true
        ) {
            emitToast("Por favor, preencha todos os campos")
            return
        }

        authenticationService.registerUser(
            user = user,
            onSuccess = {
                emitToast("Sucesso")
                navigateToHome()
            },
            onFailure = {
                emitToast("Houve um erro")
            }
        )
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
                value = firstName,
                onValueChange = {
                    if (it.length <= 50) {
                        firstName = it
                    }
                },
                label = { Text("Primeiro nome: *") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp, Sky600, RoundedCornerShape(12.dp)
                ).fillMaxWidth()
            )
            TextField(
                value = lastName,
                onValueChange = {
                    if (it.length <= 100) {
                        lastName = it
                    }
                },
                label = { Text("Sobrenome: *") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp, Sky600, RoundedCornerShape(12.dp)
                ).fillMaxWidth()
            )
            TextField(
                value = email,
                onValueChange = {
                    if (it.length <= 64) {
                        email = it
                    }
                },
                label = { Text("E-mail: *") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp, Sky600, RoundedCornerShape(12.dp)
                ).fillMaxWidth()
            )
            TextField(
                value = cellPhone,
                onValueChange = {
                    if (it.length <= 15) {
                        cellPhone = it
                    }
                },
                label = { Text("Celular: (apenas números)") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp, Sky600, RoundedCornerShape(12.dp)
                ).fillMaxWidth(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                )
            )
            TextField(
                value = password,
                onValueChange = {
                    if (it.length <= 50) {
                        password = it
                    }
                },
                label = { Text("Senha*: (até 50 caracteres)") },
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp, Sky600, RoundedCornerShape(12.dp)
                ).fillMaxWidth()
            )
            Button(
                onClick = { submitSignUpData() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Sky600
                )
            ) {
                Text("Registrar")
            }
            Button(
                onClick = { navigateToLogin() },
                modifier = Modifier.fillMaxWidth().background(Color.Transparent),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Text("Já tem acesso. Entrar")
            }
        }
    }
}