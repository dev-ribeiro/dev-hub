package br.com.devhub.views

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.devhub.dto.PostDTO
import br.com.devhub.services.AuthenticationService
import br.com.devhub.services.PostService
import br.com.devhub.ui.theme.Sky50
import br.com.devhub.ui.theme.Sky600
import br.com.devhub.utils.messages.ToastService

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun postView(navController: NavController, authenticationService: AuthenticationService) {
    val applicationContext = LocalContext.current

    val postService: PostService = viewModel()
    val toastService = ToastService()

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    fun navigateToHome() {
        navController.navigate("home")
    }

    fun createPost() {
        val user = authenticationService.authenticatedUser
        user.value?.let {
            val postTO = PostDTO(it, title, description)
            postService.createPost(
                postTO = postTO,
                onSuccess = {
                    toastService.emitToast("Post cadastrado com sucesso", applicationContext)
                    title = ""
                    description = ""
                    navigateToHome()
                },
                onFailure = {
                    toastService.emitToast("Não foi possível cadastrar o post", applicationContext  )
                }
            );
        }
    }

    Column(
        modifier = Modifier.fillMaxSize()
            .background(Sky50),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.background(Sky600).padding(12.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { navigateToHome() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Icon(
                    Icons.Filled.ArrowBackIos,
                    "arrow-back-ios",
                )
            }
            Text(text = "DEV HUB", color = Color.White, fontSize = 24.sp)
        }
        Column(
            modifier = Modifier.padding(vertical = 12.dp, horizontal = 18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            TextField(
                value = title,
                onValueChange = {
                    if (it.length <= 50) {
                        title = it
                    }
                },
                label = { Text("Título (até 50 caracteres)") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp,
                    Sky600,
                    RoundedCornerShape(12.dp)
                ).fillMaxWidth()
            )
            TextField(
                value = description,
                onValueChange = {
                    if (it.length <= 500) {
                        description = it
                    }
                },
                label = { Text("Descrição (até 500 caracteres)") },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Sky50
                ),
                modifier = Modifier.border(
                    1.dp,
                    Sky600,
                    RoundedCornerShape(12.dp)
                ).requiredHeight(300.dp).fillMaxWidth()
            )
            Button(
                onClick = { createPost() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Sky600
                )
            ) {
                Text("Criar post")
            }
        }
    }
}