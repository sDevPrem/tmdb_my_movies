// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val hilt_version by extra { "2.49" }
    val nav_version by extra { "2.7.6" }
    val lifecycle_version by extra { "2.7.0" }
    val coroutines_version by extra { "1.7.3" }
    val retrofit_version by extra { "2.9.0" }
    val paging_version by extra { "3.2.1" }
}
plugins {
    val hilt_version: String by extra
    val nav_version: String by extra

    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.10" apply false
    id("com.google.dagger.hilt.android") version hilt_version apply false
    id("androidx.navigation.safeargs.kotlin") version nav_version apply false
}