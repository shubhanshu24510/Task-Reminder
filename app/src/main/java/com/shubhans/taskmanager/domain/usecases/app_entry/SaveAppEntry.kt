package com.shubhans.taskmanager.domain.usecases.app_entry

import com.shubhans.taskmanager.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager,
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}
