package com.shubhans.taskmanager.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.shubhans.taskmanager.R

@Composable
fun SortDropdown(onSortClicked: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    val sortOptions = listOf("Priority: High to Low", "Priority: Low to High  ")

    Box {
        IconButton(onClick = { expanded = true }) {
            Icon(
                painter = painterResource(R.drawable.ic_filter_list),
                contentDescription = stringResource(R.string.filter)
            )
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            sortOptions.forEachIndexed { index, option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSortClicked(index)
                        expanded = false
                    }
                )
            }
        }
    }
}