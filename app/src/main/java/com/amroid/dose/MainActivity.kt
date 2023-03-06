package com.amroid.dose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController
import com.amroid.dose.navigation.MainScreen
import com.amroid.dose.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            AppTheme {
                val navController = rememberNavController()
                MainScreen(navController)
            }
        }
    }



}