

tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}

dependencies {
    api(Dependencies.WE_CHAT_HTTP_CLIENT_V3_SDK)
    implementation(Dependencies.JACKSON_CORE)
    implementation(Dependencies.JACKSON_DATABIND)
    implementation(Dependencies.JACKSON_DATATYPE_JSR310)
}