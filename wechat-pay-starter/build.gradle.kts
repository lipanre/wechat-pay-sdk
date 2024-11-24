
tasks.jar {
    enabled = true
}

tasks.bootJar {
    enabled = false
}
dependencies {
    api(project(":wechat-pay-core"))
    implementation(Dependencies.SPRING_BOOT_STARTER_WEB)
    compileOnly(Dependencies.SPRING_BOOT_CONFIGURATION_PROCESSOR)
    annotationProcessor(Dependencies.SPRING_BOOT_CONFIGURATION_PROCESSOR)

    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}