package com.example.settingspage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.settingspage.ui.theme.SettingsPageTheme
import com.example.settingspage.ui.theme.robotoFontFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsPageTheme {
                SettingsPage()
            }
        }
    }
}

@Composable
fun SettingsPage(modifier: Modifier = Modifier) {
    Column(

    ) {
        Profile(
            image = painterResource(id = R.drawable.img_avatar),
            imageHorizontalArrangement = Arrangement.End,
            imageModifier = Modifier
                .clip(RoundedCornerShape(50))
                .size(51.dp)
            ,
            bgModifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(horizontal = 21.dp, vertical = 15.dp)
        )
        Label(
            text = "Settings",
            fontFamily = robotoFontFamily,
            fontSize = 36.sp,
            fontWeight = FontWeight.Normal,
            textModifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colorScheme.background)
                .padding(start = 21.dp, top = 0.dp, end = 21.dp, bottom = 23.dp)
        )
    }

}

@Composable
fun Profile(
    image: Painter,
    imageHorizontalArrangement: Arrangement.Horizontal,
    imageVerticalAlignment: Alignment.Vertical = Alignment.CenterVertically,
    imageModifier: Modifier = Modifier,
    bgModifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = imageHorizontalArrangement,
        verticalAlignment = imageVerticalAlignment,
        modifier = bgModifier.fillMaxWidth(),
    ) {
        Image(
            painter = image,
            contentDescription = "Profile Image",
            modifier = imageModifier
        )
    }
}

@Composable
fun Label(
    text: String,
    fontFamily: FontFamily,
    fontSize: TextUnit,
    fontWeight: FontWeight,
    textModifier: Modifier = Modifier,
    bgModifier: Modifier = Modifier,
) {
    Row(
        modifier = bgModifier
    ) {
        Text(
            text = text,
            fontFamily = fontFamily,
            fontSize = fontSize,
            fontWeight = fontWeight,
            modifier = textModifier
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SettingsPagePreview() {
    SettingsPageTheme {
        SettingsPage()
    }
}