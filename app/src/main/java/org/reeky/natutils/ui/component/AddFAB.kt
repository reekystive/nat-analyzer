package org.reeky.natutils.ui.component

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import org.reeky.natutils.ui.theme.NATUtilsTheme

@Composable
fun AddFAB(modifier: Modifier = Modifier, onPress: () -> Unit) {
    ExtendedFloatingActionButton(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary,
        onClick = { onPress() },
        icon = { Icon(Icons.Default.Add, "Add") },
        text = { Text(text = "Add") },
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE)
@Composable
fun AddFABPreview() {
    NATUtilsTheme {
        AddFAB {}
    }
}
