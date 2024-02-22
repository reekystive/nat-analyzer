package org.reeky.natutils.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable

@Composable
fun AddFAB(onPress: () -> Unit) {
    FloatingActionButton(
        onClick = { onPress() }
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}
