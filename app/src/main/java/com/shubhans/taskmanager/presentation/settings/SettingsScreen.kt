@file:OptIn(ExperimentalMaterial3Api::class)

package com.shubhans.taskmanager.presentation.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.skydoves.colorpicker.compose.AlphaSlider
import com.github.skydoves.colorpicker.compose.ColorEnvelope
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.PaletteContentScale
import com.github.skydoves.colorpicker.compose.rememberColorPickerController
import com.shubhans.taskmanager.R
import com.shubhans.taskmanager.domain.model.AppTheme
import kotlinx.coroutines.processNextEventInCurrentThread

@Composable
fun SettingsScreen(
    viewModel: ThemeViewModel, navigateUp: () -> Unit
) {
    val selectedTheme = viewModel.selectedTheme.value
    val controller = rememberColorPickerController()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.select_theme)) },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navigateUp()
                        }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null
                        )
                    }
                })
        }, modifier = Modifier
            .padding(bottom = 12.dp)
            .statusBarsPadding()
    ) { innerPadding ->
        HsvColorPicker(
            modifier = Modifier
                .fillMaxWidth()
                .height(450.dp)
                .padding(10.dp)
                .padding(innerPadding),
            controller = controller,
            onColorChanged = { colorEnvelope ->
                colorEnvelope.color
                colorEnvelope.hexCode
                colorEnvelope.fromUser
            },
        )
        AlphaSlider(
            wheelRadius = 30.dp,
            wheelColor = Color.White,
            controller = controller,
            borderColor = Color.LightGray,
            borderRadius = 6.dp,
            borderSize = 5.dp,
        )

        Spacer(modifier = Modifier.height(10.dp))
        AlphaSlider(
            wheelRadius = 30.dp,
            wheelColor = Color.White,
            controller = controller,
            borderColor = Color.LightGray,
            borderRadius = 6.dp,
            borderSize = 5.dp,
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp),
        ) {
            Text(text = stringResource(R.string.save))
        }
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


