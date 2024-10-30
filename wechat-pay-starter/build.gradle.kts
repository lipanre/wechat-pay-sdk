dependencies {
    implementation(project(":wechat-pay-core"))
    implementation(Dependencies.SPRING_BOOT_STARTER_WEB)
}


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"])
                groupId = "com.lipanre.sdk"
                artifactId = "wechat-pay-starter"
                version = "0.0.2-SNAPSHOT"
            }
        }
        repositories {
            maven {
                url = uri("https://packages.aliyun.com/6721ee46cc7f222f53c841da/maven/2500548-snapshot-ycars7")
                credentials {
                    username = "662367769bf402bca06965e4"
                    password = "WbQuvKQ[oOSl"
                }
            }
        }
    }
}