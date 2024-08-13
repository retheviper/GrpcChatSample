plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlinx.serialization)
    //    alias(libs.plugins.kotlinx.rpc) // FIXME kotlin 2.0 not supported yet
    alias(libs.plugins.googleDevtools.ksp)
    application
}

group = "com.retheviper.sample"
version = "1.0.0"
application {
    mainClass.set("com.retheviper.sample.ApplicationKt")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=${extra["io.ktor.development"] ?: "false"}")
}

dependencies {
    implementation(projects.shared)
    implementation(libs.logback)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.kotlinx.rpc.server)
    implementation(libs.kotlinx.rpc.ktor.server)
    implementation(libs.kotlinx.rpc.serialization.json)
    testImplementation(libs.ktor.server.tests)
    testImplementation(libs.kotlin.test.junit)
}