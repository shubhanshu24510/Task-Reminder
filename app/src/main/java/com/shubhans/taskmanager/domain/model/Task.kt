package com.shubhans.taskmanager.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shubhans.taskmanager.domain.model.Priority
import kotlinx.parcelize.Parcelize
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Parcelize
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String, // Optional
    val priority: Priority,
    val dueDate: LocalDate,
    val time: LocalTime, // LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm a"))
    val done: Boolean = false,
): Parcelable
