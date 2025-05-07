@file:OptIn(ExperimentalMaterial3Api::class)

package com.shubhans.taskmanager.presentation.create

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shubhans.taskmanager.R
import com.shubhans.taskmanager.domain.model.Priority
import com.shubhans.taskmanager.domain.model.Task
import com.shubhans.taskmanager.presentation.components.PriorityDropDown
import com.shubhans.taskmanager.presentation.components.TaskTextField
import com.shubhans.taskmanager.presentation.components.TaskDateTimePicker
import com.shubhans.taskmanager.presentation.settings.ThemeViewModel
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun CreateScreen(
    event: (CreateScreenEvent) -> Unit,
    sheetState: SheetState,
    onDismiss: () -> Unit,
    themeViewModel: ThemeViewModel = hiltViewModel(),
) {
    var priority by remember { mutableStateOf(Priority.LOW) }
    val title = remember { mutableStateOf("") }
    val description = remember { mutableStateOf("") }
    var taskDate by remember { mutableStateOf(LocalDate.now()) }
    var taskTime by remember { mutableStateOf(LocalTime.now()) }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
        containerColor = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(40.dp))
                Text(
                    text = stringResource(R.string.add_a_task),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.add_a_task_desc),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp)
                )
                TaskTextField(
                    placeHolder = stringResource(R.string.task_title),
                    text = title
                )
                Spacer(modifier = Modifier.height(16.dp))

                TaskTextField(
                    lines = 9,
                    placeHolder = stringResource(R.string.description),
                    text = description
                )
                Spacer(modifier = Modifier.height(16.dp))
                PriorityDropDown(priority = priority) {
                    priority = it
                }
                Spacer(modifier = Modifier.height(16.dp))

                HorizontalDivider(modifier = Modifier.fillMaxWidth())
                TaskDateTimePicker(
                    onDateChanged = { taskDate = it },
                    onTimeChanged = { taskTime = it })
                HorizontalDivider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = {
                        if (title.value.isNotEmpty()) {
                            event(
                                CreateScreenEvent.UpsertTask(
                                    Task(
                                        title = title.value.trim(),
                                        description = description.value.trim(),
                                        priority = priority,
                                        dueDate = taskDate,
                                        time = taskTime
                                    )
                                )
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    elevation = ButtonDefaults.elevatedButtonElevation(2.dp),
                    colors = ButtonDefaults.buttonColors(themeViewModel.selectedTheme)
                ) {
                    Text(
                        text = stringResource(id = R.string.add_task),
                        fontSize = 18.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }
            }
        }
    }
}

