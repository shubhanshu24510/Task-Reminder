<h1 align="center">📋 Task Reminder </h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0">
    <img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/>
  </a>
  <a href="https://android-arsenal.com/api?level=21">
    <img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/>
  </a>
  <a href="https://github.com/skydoves/pokedex-compose/actions">
    <img alt="Build Status" src="https://github.com/skydoves/pokedex-compose/workflows/Android%20CI/badge.svg"/>
  </a>
</p>

<p align="center">
  <b>Task Reminder</b> is a sleek and efficient <b>Offline First</b> task management app designed to keep you organized and on track. Easily add tasks with custom dates and times, and let the app handle the rest. Using <b>Alarm Manager</b> and Notification Services, Task Reminder ensures you never miss a task—even without an internet connection.
</p>

---

## ✨ Preview

<p align="center">
  <img src="https://github.com/user-attachments/assets/1deff5f2-daae-47e3-a641-40d019a4b8ee" width="260"/>
  <img src="https://github.com/user-attachments/assets/2f915544-1ca9-4ee5-8b00-b04b9f5020e9" width="260"/>
  <img src="https://github.com/user-attachments/assets/3c37dbe3-1238-4b7d-a4bc-c66157838d54" width="260"/>
</p>

---

## 📱 Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/231428ac-91a5-412b-864d-b7d040fd2e56" alt="screen-1" height="500"/>
  <img src="https://github.com/user-attachments/assets/783c2007-7047-472c-98cc-20a1f0eca3db" alt="screen-2" height="500"/>
</p>

---

## ✅ **What Does It Do?**

* 📋 **Organize Your Life**: Add, edit, and manage tasks with a smooth and intuitive UI.
* 🔔 **Get Reminded**: Set reminders that work offline using Alarm Manager & Notification Services.
* 📴 **Offline First**: Store tasks locally with Room DB, no internet needed.
* 📈 **Track Progress**: Beautiful circular progress indicators reflect your productivity.

---

## 🔑 Key Features

- 📦 Room Database for persistent offline data
- 🎞️ Shared animation layout with smooth transitions
- 🧱 Clean MVVM architecture
- 🌀 Nested Scroll Support
- 🔵 Circular Progress Tracker
- 🔍 Filtering & Sorting by priority/date
- 🧹 Swipe to Delete
- 🎨 Multiple App Themes (Light, Dark, etc.)
- 🔔 Alarm Manager & Notification integration

---

## 🛠️ Tech Stack & Libraries

### Core

- **Kotlin** + **Coroutines** + **Flow**
- **Jetpack Compose** (Declarative UI)
- **MVVM Architecture**
- **Room** (Offline-first DB)
- **ViewModel**, **LiveData**, **Navigation**

### Libraries

- **Hilt** for Dependency Injection
- **Lottie Compose** for animations
- **DataStore** for preferences
- **Kotlinx Serialization** for JSON parsing
- **KSP** for code generation
- **Turbine** for Flow testing
- **Baseline Profiles** for runtime performance optimization

---

## 🧱 Architecture Overview

Task Reminder follows MVVM + Repository pattern:

### 🧩 UI Layer
![UI Layer](https://github.com/user-attachments/assets/80d123e6-e72b-4ca8-998b-a9edec78ae19)

- Built with Compose
- ViewModels observe state via Flows
- Navigation and theming handled via Compose APIs

### 🔄 Data Layer
![Data Layer](https://github.com/user-attachments/assets/0bdebc42-69a1-41a2-ad8f-d57d3cbf9124)

- Offline-first using Room
- Repository pattern ensures single source of truth
- Clean separation between local and external sources

### 📐 Architecture Diagram
![Overall Architecture](https://github.com/user-attachments/assets/29f555f6-2339-40dc-899c-79835b0c7fb7)

---

## 🧩 Modularization Strategy

- 🧬 **Reusability**: Common logic abstracted in shared modules
- 🚀 **Parallel Builds**: Modules build independently
- 🔐 **Strict Access Control**: Scoped visibility and encapsulation
- 👥 **Team Focused**: Better code ownership

More on modularization: [Google Guide](https://developer.android.com/topic/modularization)

---

## 🤝 Support

If you like this project, please consider ⭐ starring the repo and following me for more cool Android projects!

☕ You can also support my work by buying me a coffee:

<p align="left">
  <a href="https://buymeacoffee.com/shubhanshu24510" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" height="60" width="217">
  </a>
</p>

---


## 📄 License

```text
Designed and developed by Shubhanshu Singh (2025)

Licensed under the Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0
