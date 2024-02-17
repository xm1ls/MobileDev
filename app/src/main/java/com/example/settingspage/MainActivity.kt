package com.example.settingspage

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settingspage.ui.theme.SettingsPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsPageTheme {
                SettingsPage(
                    modifier = Modifier
                        .background(color = MaterialTheme.colorScheme.background)
                        .padding(horizontal = 21.dp)
                )
            }
        }
    }
}

@Composable
fun getIcons() {
    val icons = listOf<Painter>(
        painterResource(id = R.drawable.ic_accessibility),
        painterResource(id = R.drawable.ic_apps),
        painterResource(id = R.drawable.ic_devices),
        painterResource(id = R.drawable.ic_notifications),
        painterResource(id = R.drawable.ic_search),
        painterResource(id = R.drawable.ic_settings),
        painterResource(id = R.drawable.ic_wifi),
        )
        val strings = stringArrayResource(id = R.array.Options)

    Column {
        for(i in strings) {
//            Profile(image = i, imageHorizontalArrangement = Arrangement.End)
            Text(text = i)
        }
    }
}

fun getAllStrings(context: Context): List<String> {
    val stringArray = context.resources.getStringArray(R.array.Options)
    return stringArray.toList()
}
@Composable
fun SettingsPage(modifier: Modifier = Modifier) {
    val alphaModifier = Modifier.alpha(0.6f)

    Column(
        modifier = modifier
            .fillMaxHeight()
    ) {
        Spacer(modifier = Modifier.height(23.dp))
        Profile(
            image = painterResource(id = R.drawable.img_avatar),
            imageHorizontalArrangement = Arrangement.End,
            imageModifier = Modifier
                .clip(RoundedCornerShape(50))
                .size(51.dp)
            ,
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(23.dp))
        PageItem(
            icon = painterResource(id = R.drawable.ic_settings),
            iconBgModifier = Modifier.size(47.dp),
            primaryText = {
                Text(
                    text = "Get to know your Pixel",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = alphaModifier
                )
            },
            secondaryText = {
                Text(
                    text = "Explore what you can do with your phone",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = alphaModifier.padding(top = 5.dp)
                )
            },
            itemBgModifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
                .background(
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(25.dp)
                ),
        )
        Spacer(modifier = Modifier.height(15.dp))
        PageItem(
            icon = painterResource(id = R.drawable.ic_search),
            iconModifier = Modifier.alpha(0.7f),
            iconBgModifier = Modifier.size(47.dp),
            primaryText = {
                Text(
                    text = "Search Settings...",
                    style = MaterialTheme.typography.titleSmall,
                    modifier = alphaModifier
                )
            },
            itemBgModifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .background(
                    color = MaterialTheme.colorScheme.tertiary,
                    shape = RoundedCornerShape(25.dp)
                ),
        )
        Spacer(modifier = Modifier.height(40.dp))
        PageItem(
            icon = painterResource(id = R.drawable.ic_wifi),
            iconBgModifier = Modifier
                .size(47.dp)
                .clip(RoundedCornerShape(50))
                .background(color = MaterialTheme.colorScheme.surface),
            primaryText = {
                Text(
                    text = "Network & Internet",
                    style = MaterialTheme.typography.titleMedium,
                )
            },
            secondaryText = {
                Text(
                    text = "Wi-Fi, Mobile, Data usage, Hotspot",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = alphaModifier.padding(top = 4.dp)
                )
            },
            textBgModifier = Modifier.padding(start = 17.dp),
            itemBgModifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        PageItem(
            icon = painterResource(id = R.drawable.ic_devices),
            iconBgModifier = Modifier
                .size(47.dp)
                .clip(RoundedCornerShape(50))
                .background(color = MaterialTheme.colorScheme.surface),
            primaryText = {
                Text(
                    text = "Connected devices",
                    style = MaterialTheme.typography.titleMedium,
                )
            },
            secondaryText = {
                Text(
                    text = "Bluetooth, Cast, NFC",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = alphaModifier.padding(top = 4.dp)
                )
            },
            textBgModifier = Modifier.padding(start = 17.dp),
            itemBgModifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        PageItem(
            icon = painterResource(id = R.drawable.ic_apps),
            iconBgModifier = Modifier
                .size(47.dp)
                .clip(RoundedCornerShape(50))
                .background(color = MaterialTheme.colorScheme.surface),
            primaryText = {
                Text(
                    text = "App",
                    style = MaterialTheme.typography.titleMedium,
                )
            },
            secondaryText = {
                Text(
                    text = "Permission, default apps",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = alphaModifier.padding(top = 4.dp)
                )
            },
            textBgModifier = Modifier.padding(start = 17.dp),
            itemBgModifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        PageItem(
            icon = painterResource(id = R.drawable.ic_notifications),
            iconBgModifier = Modifier
                .size(47.dp)
                .clip(RoundedCornerShape(50))
                .background(color = MaterialTheme.colorScheme.surface),
            primaryText = {
                Text(
                    text = "Notifications",
                    style = MaterialTheme.typography.titleMedium,
                )
            },
            secondaryText = {
                Text(
                    text = "Permissions, default apps",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = alphaModifier.padding(top = 4.dp)
                )
            },
            textBgModifier = Modifier.padding(start = 17.dp),
            itemBgModifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(40.dp))
        PageItem(
            icon = painterResource(id = R.drawable.ic_accessibility),
            iconBgModifier = Modifier
                .size(47.dp)
                .clip(RoundedCornerShape(50))
                .background(color = MaterialTheme.colorScheme.surface),
            primaryText = {
                Text(
                    text = "Digital wellbeing",
                    style = MaterialTheme.typography.titleMedium,
                )
            },
            secondaryText = {
                Text(
                    text = "Screen time, app timer, bedtime schedules",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = alphaModifier.padding(top = 4.dp)
                )
            },
            textBgModifier = Modifier.padding(start = 17.dp),
            itemBgModifier = Modifier
                .fillMaxWidth()
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
            contentDescription = "",
            modifier = imageModifier
        )
    }
}

@Composable
fun PageItem(
    icon: Painter,
    primaryText: @Composable () -> Unit,
    secondaryText: @Composable () -> Unit? = { null },
    iconModifier: Modifier = Modifier,
    textBgModifier: Modifier = Modifier,
    iconBgModifier: Modifier = Modifier,
    itemBgModifier: Modifier = Modifier,
    bgModifier: Modifier = Modifier,
) {
    Box(
        modifier = bgModifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = itemBgModifier,
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = iconBgModifier
            ) {
                Image(
                    painter = icon,
                    contentDescription = "",
                    modifier = iconModifier
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = textBgModifier
            ) {
                primaryText()
                secondaryText()
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SettingsPagePreview() {
    SettingsPageTheme {
        SettingsPage(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(horizontal = 21.dp)
        )
//        getIcons()
    }
}