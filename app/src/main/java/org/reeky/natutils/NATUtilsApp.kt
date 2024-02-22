import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.reeky.natutils.ui.theme.NATUtilsTheme

@Suppress("SpellCheckingInspection")
val LOREM_IPSUM = """
    Lorem veniam aliqua laboris ex ad nostrud adipisicing tempor sint eu mollit nulla est voluptate nisi. Deserunt fugiat in aute deserunt et do consequat velit consequat cupidatat nisi laboris. Ex est aliqua eiusmod. Adipisicing incididunt aliqua reprehenderit aute ea consectetur velit duis consequat. Proident esse non eiusmod officia voluptate commodo.
""".trimIndent()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NATUtilsApp() {
    var presses by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("NAT Utils")
                }
            )
        },
        floatingActionButton = {
            Column {
                FloatingActionButton(
                    onClick = { presses++ }
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
                BottomInsetSpacer()
            }
        },
        contentWindowInsets = WindowInsets(0.dp)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "You have pressed the floating action button $presses times.${
                    ("\n\n" + LOREM_IPSUM).repeat(10)
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
