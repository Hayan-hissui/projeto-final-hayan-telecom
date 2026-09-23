package com.example.hayantelecom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.hayantelecom.ui.navigation.NavGraph
import com.example.hayantelecom.ui.theme.HayanTelecomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HayanTelecomTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
