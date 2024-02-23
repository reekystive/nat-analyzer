package org.reeky.natutils

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.reeky.natutils.ui.component.AddFAB
import org.reeky.natutils.ui.component.TopBar
import org.reeky.natutils.ui.theme.NATUtilsTheme

@Suppress("SpellCheckingInspection")
val LOREM_IPSUM = """
    Lorem veniam aliqua laboris ex ad nostrud adipisicing tempor sint eu mollit nulla est voluptate nisi. Deserunt fugiat in aute deserunt et do consequat velit consequat cupidatat nisi laboris. Ex est aliqua eiusmod. Adipisicing incididunt aliqua reprehenderit aute ea consectetur velit duis consequat. Proident esse non eiusmod officia voluptate commodo.
""".trimIndent()

@Composable
fun NATUtilsApp() {
    var presses by remember { mutableIntStateOf(0) }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0.dp),
        topBar = { TopBar() },
        floatingActionButton = {
            Column {
                AddFAB { presses++ }
                BottomInsetSpacer()
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "You have pressed the floating action button $presses times.${
                    ("\n\n" + LOREM_IPSUM).repeat(28)
                }",
            )
            BottomInsetSpacer()
        }
    }
}

@Composable
fun BottomInsetSpacer() {
    Spacer(
        Modifier.windowInsetsBottomHeight(
            WindowInsets.systemBars
        )
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AppPreview() {
    NATUtilsTheme {
        NATUtilsApp()
    }
}
