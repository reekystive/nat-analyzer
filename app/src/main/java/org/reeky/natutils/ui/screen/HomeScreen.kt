package org.reeky.natutils.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.reeky.natutils.ui.component.AddFAB

@Suppress("SpellCheckingInspection")
val LOREM_IPSUM = """
    Lorem veniam aliqua laboris ex ad nostrud adipisicing tempor sint eu mollit nulla est voluptate nisi. Deserunt fugiat in aute deserunt et do consequat velit consequat cupidatat nisi laboris. Ex est aliqua eiusmod. Adipisicing incididunt aliqua reprehenderit aute ea consectetur velit duis consequat. Proident esse non eiusmod officia voluptate commodo.
""".trimIndent()

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var presses by remember { mutableIntStateOf(0) }
    Box(modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "You have pressed the floating action button $presses times.${
                    ("\n\n" + LOREM_IPSUM).repeat(28)
                }",
            )
        }
        AddFAB(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            presses++
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
