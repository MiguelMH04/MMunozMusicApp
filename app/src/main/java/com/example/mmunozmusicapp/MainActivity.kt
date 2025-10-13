package com.example.mmunozmusicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mmunozmusicapp.Screens.DetailScreen
import com.example.mmunozmusicapp.Screens.HomeScreen
import com.example.mmunozmusicapp.ui.theme.DetailRoute
import com.example.mmunozmusicapp.ui.theme.HomeRoute
import com.example.mmunozmusicapp.ui.theme.MMunozMusicAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MMunozMusicAppTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(navController = navController,
                        startDestination = HomeRoute){
                        composable<HomeRoute>{
                            HomeScreen(navController)
                        }
                        composable<DetailRoute> { backStack->
                            val args = backStack.toRoute<DetailRoute>()
                            DetailScreen(args.id)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MMunozMusicAppTheme {

    }
}

