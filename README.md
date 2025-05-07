<h1 align="center">Task Manager🚀</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/skydoves/pokedex-compose/actions"><img alt="Build Status" src="https://github.com/skydoves/pokedex-compose/workflows/Android%20CI/badge.svg"/></a> <br>
</p>

<p align="center">  
<b>Task Manager</b> is a sleek and efficient <b>Offline First</b> task management app designed to keep you organized and on track. Easily add tasks with custom dates and times, and let the app handle the rest. Using <b>Alarm Manager</b> and Notification Services, Task Manager ensures you never miss a task by sending timely reminders—even without an internet connection.
</p>

---
## ✨ **Preview**
<!-- Simulate light green background using an image row with alt text -->
<p align="center">
  <img src="https://github.com/user-attachments/assets/1deff5f2-daae-47e3-a641-40d019a4b8ee" alt="screen-2" width="260"/>
  <img src="https://github.com/user-attachments/assets/2f915544-1ca9-4ee5-8b00-b04b9f5020e9" alt="screen-1" width="260"/>
    <img src="https://github.com/user-attachments/assets/3c37dbe3-1238-4b7d-a4bc-c66157838d54" alt="screen-3" width="260"/>
</p>

---

## ✨ **What Does It Do?**
* **Organize Your Life**: Add, edit, and manage tasks through an intuitive and responsive interface.
* **Stay Notified**: Set reminders and alarms so you never miss an important deadline.
* **Work Anywhere**: Use the app completely offline — your tasks are stored securely on your device using Room Database.
* **Track Progress**: Keep an eye on your productivity with a beautiful Circular Progress Bar that reflects task completion.
---

🔑 **Key Features**:  
📦 **Room Database**: Securely store all your tasks locally for offline access and fast performance.  
🎞️ **Shared Animation Layout**: Enjoy fluid and visually appealing transitions for a seamless UI experience.  
🧱 **Clean Architecture**: Built with industry-standard best practices (MVVM) for a scalable and maintainable codebase.  
📜 **Nested Scroll Support**: Enhanced scrolling behavior for smoother interaction across nested views.  
🔵 **Circular Progress Bar**: Instantly track your task completion with elegant visual indicators.  
🔍 **Task Filtering & Sorting**: Quickly sort and filter tasks by priority, date, or custom criteria.  
🧹 **Swipe to Delete**: Effortlessly manage your tasks with simple swipe gestures.  
🎨 **Multiple App Themes**: Personalize your experience with 6 vibrant themes, including a Dark Mode.  
⏰ **Alarm Manager & Notifications**: Set reminders and get notified for your tasks on time!  

---

## 🛠️ Tech Stack & Open-Source Libraries
- Minimum SDK level 21.
- [Kotlin](https://kotlinlang.org/) based, utilizing [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous operations.

### 🔧 Jetpack & Android Libraries:
  - Jetpack Compose: Android’s modern toolkit for declarative UI development.
  - Lifecycle: Observes Android lifecycles and manages UI states upon lifecycle changes.
  - Kotlin Coroutines: A concurrency design pattern in Kotlin that simplifies asynchronous code, allowing you to write code that executes asynchronously in a sequential style.
  - ViewModel: Manages UI-related data and is lifecycle-aware, ensuring data survival through configuration changes.
  - Navigation: Facilitates screen navigation, complemented by [Hilt Navigation Compose](https://developer.android.com/jetpack/compose/libraries#hilt) for dependency injection.
  - Room: Constructs a database with an SQLite abstraction layer for seamless database access.
  - [Hilt](https://dagger.dev/hilt/): Facilitates dependency injection.
  - [lottie-Compose](https://mvnrepository.com/artifact/com.airbnb.android/lottie-compose): allows developers to easily integrate Lottie animations into their Android apps using Jetpack Compose.
  - Shared element transitions : A seamless way to transition between composables that have content that is consistent between them.
  - datastore:Store data asynchronously, consistently, and transactionally, overcoming some of the drawbacks of SharedPreferences.

## 🏗️ Architecture & Tooling
* **Architecture Pattern**:
  * **MVVM (Model - View - ViewModel)**: Promotes clear separation of concerns, making the codebase more modular, testable, and maintainable.
  * **Repository Pattern**: Acts as a single source of truth by abstracting data access from various sources (local or remote).

### 🧰 Additional Tools & Libraries:
* **[Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization)**: Multiplatform, format-agnostic, reflectionless serialization library for Kotlin.
* **[KSP (Kotlin Symbol Processing)](https://github.com/google/ksp)**: Lightweight compiler plugin for annotation processing and code generation.
* **[Turbine](https://github.com/cashapp/turbine)**: A lightweight testing library for validating Kotlin Flows in unit tests.
* **[Baseline Profiles](https://medium.com/proandroiddev/improve-your-android-app-performance-with-baseline-profiles-297f388082e6)**: Optimizes runtime performance by pre-compiling critical code paths in your app.

## Architecture
**Task Manager** adheres to the MVVM architecture and implements the Repository pattern, aligning with [Google's official architecture guidance](https://developer.android.com/topic/architecture).

![architecture](https://github.com/user-attachments/assets/09ca369a-968a-435e-bb89-f1856120bac5)

The architecture of **Pokedex Jetpack** is structured into two distinct layers: the UI layer and the data layer. Each layer fulfills specific roles and responsibilities, outlined as follows:

**Task Manager** follows the principles outlined in the [Guide to app architecture](https://developer.android.com/topic/architecture), making it an exemplary demonstration of architectural concepts in practical application.

### Architecture Overview

![architecture](https://github.com/user-attachments/assets/29f555f6-2339-40dc-899c-79835b0c7fb7)

- Each layer adheres to the principles of [unidirectional event/data flow](https://developer.android.com/topic/architecture/ui-layer#udf): the UI layer sends user events to the data layer, and the data layer provides data streams to other layers.
- The data layer operates autonomously from other layers, maintaining purity without dependencies on external layers.

This loosely coupled architecture enhances component reusability and app scalability, facilitating seamless development and maintenance.

### UI Layer

![architecture](https://github.com/user-attachments/assets/80d123e6-e72b-4ca8-998b-a9edec78ae19)

The UI layer encompasses UI elements responsible for configuring screens for user interaction, alongside the [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), which manages app states and restores data during configuration changes.
- UI elements observe the data flow, ensuring synchronization with the underlying data layer.

### Data Layer

![architecture](https://github.com/user-attachments/assets/0bdebc42-69a1-41a2-ad8f-d57d3cbf9124)

The data layer is composed of repositories that handle business logic tasks such as retrieving data from a local database or fetching remote data from a network. This layer is designed to prioritize offline access, functioning primarily as an offline-first repository of business logic. It adheres to the principle of "single source of truth," ensuring that all data operations are centralized and consistent.<br>

## Modularization

**Task Manager** adopted modularization strategies below:

- **Reusability**: Modulizing reusable codes properly enable opportunities for code sharing and limits code accessibility in other modules at the same time.
- **Parallel Building**: Each module can be run in parallel and it reduces the build time.
- **Strict visibility control**: Modules restrict to expose dedicated components and access to other layers, so it prevents they're being used outside the module
- **Decentralized focusing**: Each developer team can assign their dedicated module and they can focus on their own modules.

For more information, check out the [Guide to Android app modularization](https://developer.android.com/topic/modularization).

## Find this repository useful? :heart:
Support it by joining  __[follow me](https://github.com/shubhanshu24510)__ on GitHub for my next creations! 🤩

# License
```xml
Designed and developed by 2025 shubhanshu24510 (Shubhanshu Singh)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
