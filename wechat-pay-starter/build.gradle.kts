
tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}
dependencies {
    api(project(":wechat-pay-core"))
    implementation(Dependencies.SPRING_BOOT_STARTER_WEB)
    implementation(Dependencies.MAP_STRUCT_PLUS_STATER)
    compileOnly(Dependencies.SPRING_BOOT_CONFIGURATION_PROCESSOR)
    annotationProcessor(Dependencies.SPRING_BOOT_CONFIGURATION_PROCESSOR)
}


