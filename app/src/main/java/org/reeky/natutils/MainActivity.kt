package org.reeky.natutils

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import org.reeky.natutils.ui.theme.NATUtilsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NATUtilsTheme(dynamicColor = true) {
                ApplySystemBarsEffect()
                NATUtilsApp()
            }
        }
    }

    @Composable
    private fun ApplySystemBarsEffect() {
        val isDarkTheme = isSystemInDarkTheme()
        DisposableEffect(isDarkTheme) {
            val systemBarStyle = if (isDarkTheme) {
                SystemBarStyle.dark(Color.TRANSPARENT)
            } else {
                SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT)
            }
            enableEdgeToEdge(navigationBarStyle = systemBarStyle)
            onDispose { }
        }
    }
}
