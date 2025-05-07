@file:OptIn(ExperimentalMaterial3Api::class)

package com.shubhans.taskmanager.presentation.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.AlphaTile
import com.github.skydoves.colorpicker.compose.BrightnessSlider
import com.github.skydoves.colorpicker.compose.ColorPickerController
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.drawColorIndicator
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.shubhans.taskmanager.R
import com.shubhans.taskmanager.presentation.navgraph.Route

@Composable
fun SettingsScreen(
    viewModel: ThemeViewModel,
    navigateUp: () -> Unit,
    navController: NavController,
) {
    val controller: ColorPickerController = rememberColorPickerController()
    var hexCode by remember { mutableStateOf("") }
    var textColor by remember { mutableStateOf(Color.Transparent) }
    Column {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.select_theme),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },
            navigationIcon = {
                IconButton(onClick = { navigateUp() }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onBackground
                    )
                }
            },
        )
        Box(modifier = Modifier.weight(4f)) {
            HsvColorPicker(
                modifier = Modifier.padding(50.dp),
                controller = controller,
                drawOnPosSelected = {
                    drawColorIndicator(
                        pos = controller.selectedPoint.value,
                        color = controller.selectedColor.value,
                    )
                },
                onColorChanged = { colorEnvelope ->
                    hexCode = colorEnvelope.hexCode
                    textColor = colorEnvelope.color
                },
                initialColor = Color.Blue,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        AlphaSlider(
            modifier = Modifier
                .testTag("HSV_AlphaSlider")
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(35.dp),
            controller = controller,
        )
        Spacer(modifier = Modifier.height(20.dp))

        BrightnessSlider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .height(35.dp),
            controller = controller,
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "#$hexCode",
            color = textColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )
        AlphaTile(
            modifier = Modifier
                .size(80.dp)
                .clip(RoundedCornerShape(6.dp))
                .align(Alignment.CenterHorizontally),
            controller = controller,
        )
        Spacer(modifier = Modifier.height(40.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp)
                .align(Alignment.CenterHorizontally), colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.onBackground,
                contentColor = MaterialTheme.colorScheme.background,
            ), onClick = {
                viewModel.updateTheme(textColor)
                navController.navigate(Route.Home)
            }) {
            Text(
                text = stringResource(id = R.string.save),
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.weight(0.8f))
    }
}

//
//        val list = AppTheme.entries.toList()
//
//        LazyVerticalStaggeredGrid(
//            modifier = Modifier
//                .padding(innerPadding)
//                .padding(5.dp),
//            columns = StaggeredGridCells.Fixed(2),
//            horizontalArrangement = Arrangement.spacedBy(10.dp), verticalItemSpacing = 5.dp
//        ) {
//            items(list.size) {
//                val theme = list[it]
//
//                Button(
//                    shape = RoundedCornerShape(16.dp),
//                    onClick = { viewModel.updateTheme(theme) }, modifier = Modifier
//                        .height(160.dp)
//                        .width(120.dp),
//                    border = BorderStroke(
//                        width = 3.dp,
//                        color = if (selectedTheme == theme) Color.Green else Color.LightGray
//                    )
//
//                ) {
//                    Text("Theme ${it + 1}")
//                }
//
//            }
//
//        }
//    }
//}

//@Preview(showBackground = true)
//@Composable
//private fun SettingScreenPreview() {
//    SettingScreen()
//}


