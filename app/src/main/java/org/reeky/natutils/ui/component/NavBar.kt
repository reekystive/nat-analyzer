package org.reeky.natutils.ui.component

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.SettingsEthernet
import androidx.compose.material.icons.filled.TravelExplore
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.SettingsEthernet
import androidx.compose.material.icons.outlined.TravelExplore
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import org.reeky.natutils.ui.theme.NATUtilsTheme

@Composable
fun NavBar(selectedTabState: MutableIntState) {
    val items = listOf("Analyze", "Network", "History", "Settings")
    val icons = listOf(
        Icons.Outlined.TravelExplore,
        Icons.Outlined.SettingsEthernet,
        Icons.Outlined.History,
        Icons.Outlined.Settings,
    )
    val selectedIcons = listOf(
        Icons.Filled.TravelExplore,
        Icons.Filled.SettingsEthernet,
        Icons.Filled.History,
        Icons.Filled.Settings,
    )

    NavigationBar {
        items.forEachIndexed { index, item ->
            val icon = if (selectedTabState.intValue == index) selectedIcons[index] else icons[index]
            NavigationBarItem(
                icon = { Icon(imageVector = icon, contentDescription = item) },
                label = { Text(item) },
                selected = selectedTabState.intValue == index,
                onClick = { selectedTabState.intValue = index },
                alwaysShowLabel = true
            )
        }
    }
}

@Preview(name = "Light Mode", wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE
)
@Composable
fun NavBarPreview() {
    val state = remember { mutableIntStateOf(0) }
    NATUtilsTheme {
        Surface {
            NavBar(selectedTabState = state)
        }
    }
}
