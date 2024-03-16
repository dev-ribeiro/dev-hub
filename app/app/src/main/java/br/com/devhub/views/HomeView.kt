package br.com.devhub.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
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
import br.com.devhub.models.Post
import br.com.devhub.services.AuthenticationService
import br.com.devhub.services.PostService
import br.com.devhub.ui.theme.Sky50
import br.com.devhub.ui.theme.Sky600
import br.com.devhub.utils.enums.Direction
import br.com.devhub.utils.messages.ToastService

@Composable
fun homeView(navController: NavController, authenticationService: AuthenticationService) {
    val applicationContext = LocalContext.current
    val postService: PostService = viewModel()
    val toastService: ToastService = ToastService()

    fun navigateToProfile() {
        navController.navigate("profile")
    }

    fun navigateToPost() {
        navController.navigate("post")
    }

    LaunchedEffect(null) {
        val to = PostDTO(
            page = 1,
            size = 10,
            direction = Direction.DESC,
            by = arrayListOf("createdAt")
        )

        postService.findAll(
            postTO = to,
            onSuccess = {
                toastService.emitToast(
                    "Posts recuperados com sucess",
                    applicationContext
                )
            },
            onFailure = {
                toastService.emitToast(
                    "Não foi possível recuperar os posts",
                    applicationContext
                )
            }
        )
    }

    Column(
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
            .background(Sky50),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.background(Sky600).padding(12.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "DEV HUB", color = Color.White, fontSize = 24.sp)
            Button(
                onClick = { navigateToProfile() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                )
            ) {
                Icon(
                    Icons.Filled.Settings,
                    "settings",
                )
            }
        }
        Column(
            modifier = Modifier.padding(horizontal = 16.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            listPostsComponent(postService.posts)
            Row(
                modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth().requiredHeight(100.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { navigateToPost() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Sky600
                    )
                ) {
                    Icon(
                        Icons.Filled.Add,
                        "add"
                    )
                }
            }
        }
    }
}

@Composable
fun listPostsComponent(posts: List<Post>) {
    if (posts.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Não há posts", fontSize = 24.sp)
        }
    } else {
        for (post in posts) {
            Row {
                Text(post.title)
            }
        }
    }
}