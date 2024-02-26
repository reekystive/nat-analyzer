package org.reeky.natutils.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NetworkScreen() {
    Text("Network", modifier = Modifier.padding(8.dp))
}

@Preview
@Composable
fun NetworkScreenPreview() {
    NetworkScreen()
}
