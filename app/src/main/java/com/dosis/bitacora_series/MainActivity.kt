package com.dosis.bitacora_series

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dosis.bitacora_series.ui.MainScreen
import com.dosis.bitacora_series.ui.screens.HomeScreen
import com.dosis.bitacora_series.ui.theme.Bitacora_seriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bitacora_seriesTheme {
                //HomeScreen()
                MainScreen()
            }
        }
    }
}
