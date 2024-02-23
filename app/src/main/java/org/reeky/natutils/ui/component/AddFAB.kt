package org.reeky.natutils.ui.component

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import org.reeky.natutils.ui.theme.NATUtilsTheme

@Composable
fun AddFAB(onPress: () -> Unit) {
    ExtendedFloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        onClick = { onPress() },
        icon = { Icon(Icons.Default.Add, "Add") },
        text = { Text(text = "Add") },
    )
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AddFABPreview() {
    NATUtilsTheme {
        AddFAB {}
    }
}
