# MyMovies

In My Movies app, you can explore top rated and popular movies.
It is an Android client implementation
of [TMDB](https://developer.themoviedb.org/docs/getting-started)
API using MVVM and clean architecture.

## Features

1. Explore top rated and popular movies.
2. Single Activity Architecture and uses Jetpack navigation to navigate
   through destination (fragments).
3. Retrofit to do api calls and gson to parse response.
4. Paging3 to load only required Movies.
5. Hilt for dependency injection.

|                                                                                                                     |                                                                                                                        |
|---------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| ![my_movies_home](https://github.com/sDevPrem/tmdb_my_movies/assets/130966261/6a1d43a4-894f-4073-9ec8-ca2b15be0920) | ![my_movies_details](https://github.com/sDevPrem/tmdb_my_movies/assets/130966261/56a28ecc-e0f1-4ebe-ba50-23783e4ced23) |

## TODO

* Show a progress bar when api is being called.
* Show a Error message and give the user a button to retry.
* Also do the above in pagination (showing error and loading at bottom).
* Implement deeplink and share deeplink of the detail screen when user click
  on share button.

## Architecture

This app follows MVVM architecture with Clean architecture, Uni Directional Flow (UDF) pattern
and Single Activity architecture pattern.

### Packages

* [`:data:`](app/src/main/java/com/example/mymovies/data) -
  The data origin point.
* [`:di:`](app/src/main/java/com/example/mymovies/di) -
  Hilt modules.
* [`:domain:`](app/src/main/java/com/example/mymovies/domain) -
  Central nervous system of the app containing the contract between UI and Data layer.
* [`:ui:`](app/src/main/java/com/example/mymovies/ui) -
  All the Screens UI lies here in subpackages.

## Build With

[Kotlin](https://kotlinlang.org/):
As the programming language.

[Jetpack Navigation](https://developer.android.com/guide/navigation) :
To navigate between destinations(fragments).

[Hilt](https://developer.android.com/training/dependency-injection/hilt-android) :
As a dependency injector.

[Paging3](https://developer.android.com/topic/libraries/architecture/paging/v3-overview):
For infinite scrolling.

[Retrofit](https://square.github.io/retrofit):
As Api Client.

[Coroutines](https://developer.android.com/kotlin/coroutines):
For Asynchronous programming.

## Installation

Simple clone this app and open in Android Studio.
