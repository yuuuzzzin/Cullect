import org.gradle.api.artifacts.dsl.DependencyHandler

internal fun DependencyHandler.implementation(depName: Any) {
    add("implementation", depName)
}

internal fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

internal fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

internal fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

internal fun DependencyHandler.testImplementation(depName: Any) {
    add("testImplementation", depName)
}

internal fun DependencyHandler.androidTestImplementation(depName: Any) {
    add("androidTestImplementation", depName)
}

internal fun DependencyHandler.kaptAndroidTest(depName: Any) {
    add("kaptAndroidTest", depName)
}