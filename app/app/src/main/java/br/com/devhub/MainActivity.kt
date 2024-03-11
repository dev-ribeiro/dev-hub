package br.com.devhub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.devhub.ui.theme.DevHubTheme
import br.com.devhub.views.homeView
import br.com.devhub.views.loginView
import br.com.devhub.views.profileView
import br.com.devhub.views.signUpView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DevHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "login") {
                        composable("login") { loginView(navController) }
                        composable("signup") { signUpView(navController) }
                        composable("home") { homeView(navController) }
                        composable("profile") { profileView(navController) }
                    }
                }
            }
        }
    }
}