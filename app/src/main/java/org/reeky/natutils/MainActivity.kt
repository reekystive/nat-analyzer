package org.reeky.natutils

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.toArgb
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
        val alpha = (if (isDarkTheme) 0x80 else 0xe6) / 255f
        val background = MaterialTheme.colorScheme.background.copy(alpha = alpha).toArgb()
        DisposableEffect(isDarkTheme) {
            val systemBarStyle = if (isDarkTheme) {
                SystemBarStyle.dark(background)
            } else {
                SystemBarStyle.light(background, background)
            }
            enableEdgeToEdge(navigationBarStyle = systemBarStyle)
            onDispose { }
        }
    }
}
