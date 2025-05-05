package com.shubhans.taskmanager.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.shubhans.taskmanager.data.local.TasksDao
import com.shubhans.taskmanager.data.local.TasksDatabase
import com.shubhans.taskmanager.data.manager.LocalUserImpl
import com.shubhans.taskmanager.data.repository.AlarmRepositoryImpl
import com.shubhans.taskmanager.data.repository.TasksRepositoryImpl
import com.shubhans.taskmanager.domain.manager.LocalUserManager
import com.shubhans.taskmanager.domain.repository.AlarmScheduler
import com.shubhans.taskmanager.domain.repository.TasksRepository
import com.shubhans.taskmanager.domain.usecases.tasks.AlarmUseCase
import com.shubhans.taskmanager.domain.usecases.app_entry.GetAppEntry
import com.shubhans.taskmanager.domain.usecases.app_entry.SaveAppEntry
import com.shubhans.taskmanager.domain.usecases.app_theme.GetAppTheme
import com.shubhans.taskmanager.domain.usecases.app_theme.SaveAppTheme
import com.shubhans.taskmanager.domain.usecases.app_theme.ThemeUseCases
import com.shubhans.taskmanager.domain.usecases.tasks.CancelAlarm
import com.shubhans.taskmanager.domain.usecases.tasks.DeleteTask
import com.shubhans.taskmanager.domain.usecases.tasks.GetTasksList
import com.shubhans.taskmanager.domain.usecases.tasks.SetAlarm
import com.shubhans.taskmanager.domain.usecases.tasks.TaskUseCases
import com.shubhans.taskmanager.domain.usecases.tasks.UpsertTask
import com.shubhans.taskmanager.util.Constants.TASKS_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserImpl(application)

    @Provides
    @Singleton
    fun provideDatabase(application: Application): TasksDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = TasksDatabase::class.java,
            name = TASKS_DB
        ).fallbackToDestructiveMigration(true)
            .build()
    }


    @Provides
    @Singleton
    fun provideDao(
        tasksDatabase: TasksDatabase,
    ): TasksDao = tasksDatabase.tasksDao

    @Provides
    @Singleton
    fun provideTasksRepository(tasksDao: TasksDao): TasksRepository = TasksRepositoryImpl(tasksDao)


    @Provides
    @Singleton
    fun provideUseCases(tasksRepository: TasksRepository): TaskUseCases = TaskUseCases(
        upsertTask = UpsertTask(tasksRepository),
        deleteTask = DeleteTask(tasksRepository),
        getTasksList = GetTasksList(tasksRepository),
    )

    @Provides
    @Singleton
    fun provideAlarmUseCases(alarmScheduler: AlarmScheduler): AlarmUseCase =
        AlarmUseCase(setAlarm = SetAlarm(alarmScheduler), cancelAlarm = CancelAlarm(alarmScheduler))

    @Provides
    @Singleton
    fun provideThemeUseCases(localUserManager: LocalUserManager): ThemeUseCases = ThemeUseCases(
        readAppTheme = GetAppTheme(localUserManager),
        saveAppTheme = SaveAppTheme(localUserManager),
        getAppEntry = GetAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )


    @Provides
    @Singleton
    fun provideAlarmRepository(
        @ApplicationContext context: Context,
    ): AlarmScheduler = AlarmRepositoryImpl(context)

}