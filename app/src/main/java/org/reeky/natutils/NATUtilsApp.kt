package org.reeky.natutils

import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.reeky.natutils.ui.component.NavBar
import org.reeky.natutils.ui.component.TopBar
import org.reeky.natutils.ui.screen.HistoryScreen
import org.reeky.natutils.ui.screen.HomeScreen
import org.reeky.natutils.ui.screen.NetworkScreen
import org.reeky.natutils.ui.screen.SettingsScreen
import org.reeky.natutils.ui.theme.NATUtilsTheme

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun NATUtilsApp() {
    val selectedTabState = remember { mutableIntStateOf(0) }
    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0.dp),
        topBar = { TopBar() },
        bottomBar = {
            if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                NavBar(selectedTabState = selectedTabState)
            }
        },
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            when (selectedTabState.intValue) {
                0 -> HomeScreen()
                1 -> NetworkScreen()
                2 -> HistoryScreen()
                3 -> SettingsScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppPreview() {
    NATUtilsTheme {
        NATUtilsApp()
    }
}
