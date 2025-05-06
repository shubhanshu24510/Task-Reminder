<h1 align="center">Task Manager</h1>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://github.com/skydoves/pokedex-compose/actions"><img alt="Build Status" src="https://github.com/skydoves/pokedex-compose/workflows/Android%20CI/badge.svg"/></a> <br>
</p>

<p align="center">  
🗡️ Task Manager demonstrates modern Android development with Jetpack Compose, Hilt, Coroutines, Flow, Jetpack (Room, ViewModel), and Material Design based on MVVM architecture.
</p>

<p align="center">
<img src="https://github.com/user-attachments/assets/e1769fd7-c4df-4f29-8779-878542dbc619"/>
</p> 
<p align="center">
<img src="https://github.com/user-attachments/assets/ac86fd49-06b5-4dd0-827f-a1306126f5d0"/>
</p> 

## Tech stack & Open-source libraries
- Minimum SDK level 21.
- [Kotlin](https://kotlinlang.org/) based, utilizing [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous operations.
- 
- Jetpack Libraries:
  - Jetpack Compose: Android’s modern toolkit for declarative UI development.
  - Lifecycle: Observes Android lifecycles and manages UI states upon lifecycle changes.
  - ViewModel: Manages UI-related data and is lifecycle-aware, ensuring data survival through configuration changes.
  - Navigation: Facilitates screen navigation, complemented by [Hilt Navigation Compose](https://developer.android.com/jetpack/compose/libraries#hilt) for dependency injection.
  - Room: Constructs a database with an SQLite abstraction layer for seamless database access.
  - [Hilt](https://dagger.dev/hilt/): Facilitates dependency injection.
  - datastore:Store data asynchronously, consistently, and transactionally, overcoming some of the drawbacks of SharedPreferences.
  - [lottieCompose]:(https://mvnrepository.com/artifact/com.airbnb.android/lottie-compose):allows developers to easily integrate Lottie animations into their Android apps using Jetpack Compose.
- Architecture:
  - MVVM Architecture (View - ViewModel - Model): Facilitates separation of concerns and promotes maintainability.
  - Repository Pattern: Acts as a mediator between different data sources and the application's business logic.
- [Kotlin Serialization](https://github.com/Kotlin/kotlinx.serialization): Kotlin multiplatform / multi-format reflectionless serialization.
- [ksp](https://github.com/google/ksp): Kotlin Symbol Processing API for code generation and analysis.
- [Turbine](https://github.com/cashapp/turbine): A small testing library for kotlinx.coroutines Flow.
- [Baseline Profiles](https://medium.com/proandroiddev/improve-your-android-app-performance-with-baseline-profiles-297f388082e6): Enhances app performance by including specifications of classes and methods in the APK that can be utilized by Android Runtime.

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

**Task Manager** is an offline-first app, meaning it can perform all or most of its essential functions without an internet connection. This design allows users to access core features reliably, regardless of network availability, reducing their need for constant updates and decreasing data usage. For more details on how to build an offline-first application, you can visit [Build an offline-first app](https://developer.android.com/topic/architecture/data-layer/offline-first).

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
