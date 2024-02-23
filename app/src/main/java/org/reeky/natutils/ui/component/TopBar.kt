package org.reeky.natutils.ui.component

import android.content.res.Configuration
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import org.reeky.natutils.ui.theme.NATUtilsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground,
        ),
        title = {
            Text("NAT Utils")
        }
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Composable
fun TopBarPreview() {
    NATUtilsTheme {
        TopBar()
    }
}
