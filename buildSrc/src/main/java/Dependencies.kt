import org.gradle.api.artifacts.dsl.DependencyHandler

object Libraries {

    object AndroidX {
        const val APP_COMPAT            = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val MATERIAL              = "com.google.android.material:material:${Versions.MATERIAL}"
        const val CONSTRAINT_LAYOUT     = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val MULTIDEX              = "androidx.multidex:multidex:${Versions.MULTIDEX}"
        const val CORE                  = "androidx.core:core-ktx:${Versions.CORE}"
        const val LIFECYCLE_RUNTIME     = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
        const val LIFECYCLE_VIEW_MODEL  = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
        const val LIFECYCLE_LIVEDATA    = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
        const val ACTIVITY              = "androidx.activity:activity-ktx:${Versions.ACTIVITY}"
        const val FRAGMENT              = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT}"
        const val RECYCLERVIEW          = "androidx.recyclerview:recyclerview:${Versions.RECYCLERVIEW}"
        const val PAGING                = "androidx.paging:paging-runtime:${Versions.PAGING}"
        const val PAGING_COMMON         = "androidx.paging:paging-common:${Versions.PAGING}"
        const val SWIPE_REFRESH_LAYOUT  = "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.SWIPE_REFRESH_LAYOUT}"
    }

    object Kotlin {
        const val KOTLIN_STDLIB         = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"
        const val COROUTINES_ANDROID    = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
        const val COROUTINS_CORE        = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    }

    object Hilt {
        const val ANDROID               = "com.google.dagger:hilt-android:${Versions.HILT}"
        const val ANDROID_COMPILER      = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
        const val ANDROIDX_COMPILER     = "androidx.hilt:hilt-compiler:${Versions.HILT_COMPILER}"
        const val LIFECYCLE_VIEWMODEL   = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.HILT_COMPILER}"
    }

    object Retrofit {
        const val RETROFIT              = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
        const val GSON                  = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
        const val RXJAVA                = "com.squareup.retrofit2:adapter-rxjava3:${Versions.RETROFIT}"
    }

    object OKHttp {
        const val OKHTTP                = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
        const val LOGGING_INTERCEPTOR   = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    }

    const val TIMBER                    = "com.jakewharton.timber:timber:${Versions.TIMBER}"

    object Rx {
        const val JAVA                  = "io.reactivex.rxjava3:rxjava:3.1.2"
        const val KOTLIN                = "io.reactivex.rxjava3:rxkotlin:3.0.1"
        const val ANDROID               = "io.reactivex.rxjava3:rxandroid:3.0.0"
    }

    object Navigation {
        const val FRAGMENT              = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
        const val UI                    = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    }

    object Room {
        const val RUNTIME               = "androidx.room:room-runtime:${Versions.ROOM}"
        const val COMPILER              = "androidx.room:room-compiler:${Versions.ROOM}"
        const val KTX                   = "androidx.room:room-ktx:${Versions.ROOM}"
        const val RXJAVA3               = "androidx.room:room-rxjava3:${Versions.ROOM}"
    }

    object TikXML {
        const val ANNOTATION            = "com.tickaroo.tikxml:annotation:${Versions.TIKXML}"
        const val CORE                  = "com.tickaroo.tikxml:core:${Versions.TIKXML}"
        const val RETROFIT_CONVERTER    = "com.tickaroo.tikxml:retrofit-converter:${Versions.TIKXML}"
        const val PROCESSOR             = "com.tickaroo.tikxml:processor:${Versions.TIKXML}"
    }

    object Glide {
        const val Glide                 = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
        const val COMPILER              = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"
    }

    object Test {
        const val JUNIT                 = "androidx.test.ext:junit:${Versions.JUNIT}"
    }

    object AndroidTest {
        const val ESPRESSO_CORE         = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"
    }

}

fun DependencyHandler.dependOnAndroidX() {
    implementation(Libraries.AndroidX.APP_COMPAT)
    implementation(Libraries.AndroidX.MATERIAL)
    implementation(Libraries.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Libraries.AndroidX.MULTIDEX)
    implementation(Libraries.AndroidX.CORE)
    implementation(Libraries.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Libraries.AndroidX.LIFECYCLE_VIEW_MODEL)
    implementation(Libraries.AndroidX.LIFECYCLE_LIVEDATA)
    implementation(Libraries.AndroidX.ACTIVITY)
    implementation(Libraries.AndroidX.FRAGMENT)
    implementation(Libraries.AndroidX.RECYCLERVIEW)
    implementation(Libraries.AndroidX.PAGING)
    implementation(Libraries.AndroidX.SWIPE_REFRESH_LAYOUT)
}

fun DependencyHandler.dependOnCoroutines() {
    implementation(Libraries.Kotlin.COROUTINS_CORE)
    implementation(Libraries.Kotlin.COROUTINES_ANDROID)
}

fun DependencyHandler.dependOnHilt() {
    implementation(Libraries.Hilt.ANDROID)
    kapt(Libraries.Hilt.ANDROID_COMPILER)
    //kapt(Libraries.Hilt.ANDROIDX_COMPILER)
    //implementation(Libraries.Hilt.LIFECYCLE_VIEWMODEL)
}

fun DependencyHandler.dependOnRetrofit() {
    implementation(Libraries.Retrofit.RETROFIT)
    implementation(Libraries.Retrofit.GSON)
}

fun DependencyHandler.dependOnOkHttp() {
    implementation(Libraries.OKHttp.OKHTTP)
    implementation(Libraries.OKHttp.LOGGING_INTERCEPTOR)
}

fun DependencyHandler.dependOnTimber() {
    implementation(Libraries.TIMBER)
}

fun DependencyHandler.dependOnTikXML() {
    implementation(Libraries.TikXML.ANNOTATION)
    implementation(Libraries.TikXML.CORE)
    implementation(Libraries.TikXML.RETROFIT_CONVERTER)
    kapt(Libraries.TikXML.PROCESSOR)
}

fun DependencyHandler.dependOnRx() {
    implementation(Libraries.Rx.JAVA)
    implementation(Libraries.Rx.KOTLIN)
    implementation(Libraries.Rx.ANDROID)
}

fun DependencyHandler.dependOnNavigation() {
    implementation(Libraries.Navigation.FRAGMENT)
    implementation(Libraries.Navigation.UI)
}

fun DependencyHandler.dependOnRoom() {
    implementation(Libraries.Room.RUNTIME)
    implementation(Libraries.Room.COMPILER)
    implementation(Libraries.Room.KTX)
    implementation(Libraries.Room.RXJAVA3)
}

fun DependencyHandler.dependOnKotlin() {
    implementation(Libraries.Kotlin.KOTLIN_STDLIB)
}

fun DependencyHandler.dependOnGlide() {
    implementation(Libraries.Glide.Glide)
    kapt(Libraries.Glide.COMPILER)
}

fun DependencyHandler.dependOnTest() {
    testImplementation(Libraries.Test.JUNIT)
    androidTestImplementation(Libraries.AndroidTest.ESPRESSO_CORE)
}
