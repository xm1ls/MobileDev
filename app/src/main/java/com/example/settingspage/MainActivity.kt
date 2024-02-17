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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.settingspage.ui.theme.SettingsPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsPageTheme {
//                SettingsPage(
//                    modifier = Modifier
//                        .background(color = MaterialTheme.colorScheme.background)
//                        .padding(horizontal = 21.dp)
//                )
                ArtSpacePage()
            }
        }
    }
}

@Composable
fun ArtSpacePage() {
    val strings = stringArrayResource(id = R.array.Options)

    val fields = R.drawable::class.java.fields
    val drawables = mutableListOf<Int>()

    for(field in fields) {
        if("img_" in field.name)
            drawables.add(field.getInt(null))
    }

    var currentImageId = remember {
        mutableIntStateOf(0)
    }


    var currentImage =  when(currentImageId.value) {
        0 -> drawables[0]
        1 -> drawables[1]
        2 -> drawables[2]
        3 -> drawables[3]
        4 -> drawables[4]
        5 -> drawables[5]
        else -> R.drawable.img_avatar
    }

    var photoDescription = when(currentImageId.value) {
        0 -> "title 0, artist 0, year 0"
        1 -> "title 1, artist 1, year 1"
        2 -> "title 2, artist 2, year 2"
        3 -> "title 3, artist 3, year 3"
        4 -> "title 4, artist 4, year 4"
        5 -> "title 5, artist 5, year 5"
        else -> "title x, artist x, year x"
    }

    var (title, artist, year) = photoDescription.split(", ").map{
        it.trim()
    }

    Column(
    ) {
        ArtSpaceImage(
            image = currentImage,
            modifier = Modifier.weight(.70f)
        )
        ArtSpaceText(
            title = title,
            artist = artist,
            year = year,
            modifier = Modifier.weight(.2f)
        )
        ArtSpaceButtons(
            prevButton = {
                if(currentImageId.value <= 0)
                    currentImageId.value
                else currentImageId.value--
                },
            nextButton = {
                if(currentImageId.value >= drawables.size-1)
                    currentImageId.value
                else currentImageId.value++
            },
            modifier = Modifier.weight(.1f)
        )
    }

}

@Composable
fun ArtSpaceImage(
    image: Int,
    modifier: Modifier = Modifier) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = RoundedCornerShape(5)
            )

    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .clip(RoundedCornerShape(3))
            ,
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun ArtSpaceText(
    title: String = "Unknown Title",
    artist: String = "Unknown Artist",
    year: String = "Unknown Year",
    modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .background(
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(5)
            )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge
        )
        Text(
            text = "$artist $year",
            style = MaterialTheme.typography.labelSmall
        )
    }
}

@Composable
fun ArtSpaceButtons(
    prevButton: () -> Unit = { },
    nextButton: () -> Unit = { },
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Button(
            onClick = { prevButton() },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.tertiary
            ),
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .fillMaxHeight()
                .weight(.5f)
                .shadow(
                    4.dp,
                    shape = MaterialTheme.shapes.extraSmall
                )
        ) {
            Text(
                text = "Previous",
                style = MaterialTheme.typography.labelSmall
            )
        }
        Spacer(Modifier.width(10.dp))
        Button(
            onClick = { nextButton() },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.tertiary
            ),
            shape = RoundedCornerShape(10),
            modifier = Modifier
                .fillMaxHeight()
                .weight(.5f)
                .shadow(
                    4.dp,
                    shape = MaterialTheme.shapes.extraSmall
                )
            ) {
            Text(
                text = "Next",
                style = MaterialTheme.typography.labelSmall
            )
        }

    }
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
            icon = painterResource(id = R.drawable.icon_settings),
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
            icon = painterResource(id = R.drawable.icon_search),
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
            icon = painterResource(id = R.drawable.icon_wifi),
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
            icon = painterResource(id = R.drawable.icon_devices),
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
            icon = painterResource(id = R.drawable.icon_apps),
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
            icon = painterResource(id = R.drawable.icon_notifications),
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
            icon = painterResource(id = R.drawable.icon_accessibility),
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
fun ArtSpacePreview() {
    SettingsPageTheme {
        ArtSpacePage()
    }
}

//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
@Composable
fun SettingsPagePreview() {
    SettingsPageTheme {
//        SettingsPage(
//            modifier = Modifier
//                .background(color = MaterialTheme.colorScheme.background)
//                .padding(horizontal = 21.dp)
//        )
//        getIcons()
    }
}

