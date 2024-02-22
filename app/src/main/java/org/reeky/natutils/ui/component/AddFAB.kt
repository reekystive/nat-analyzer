package org.reeky.natutils.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AddFAB(onPress: () -> Unit) {
    ExtendedFloatingActionButton(
        onClick = { onPress() },
        icon = { Icon(Icons.Default.Add, "Add") },
        text = { Text(text = "Add") },
    )
}
