package com.example.settingspage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import com.example.settingspage.ui.theme.SettingsPageTheme
import com.example.settingspage.ui.theme.robotoFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsPageTheme {
                SettingsPage("Android")
            }
        }
    }
}

@Composable
fun SettingsPage(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
    )
}


@Preview(showBackground = true)
@Composable
fun SettingsPagePreview() {
    SettingsPageTheme {
        SettingsPage("Android")
    }
}