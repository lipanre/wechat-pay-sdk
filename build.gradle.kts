import kotlin.math.sign

plugins {
    `maven-publish`
    signing
}

buildscript {

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/spring")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        mavenCentral()
    }

    dependencies {
        classpath(Plugin.SPRING_BOOT_DEPENDENCY)
        classpath(Plugin.SPRING_BOOT_GRADLE)
        classpath(Plugin.LOMBOK)
    }
}

// 微信支付sdk封装
description = "wechat-pay-sdk"
allprojects {
    group = extra["SDK_GROUP"] as String
    version = extra["WECHAT_PAY_SDK_VERSION"] as String

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/spring")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        mavenCentral()
    }

    tasks.withType<JavaCompile> {
        options.compilerArgs.add("-parameters")
        options.compilerArgs.add("-Xlint:-options")
        options.encoding="UTF-8"
    }


    tasks.withType<Javadoc> {
        options.encoding = "UTF-8"
    }


}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
        withSourcesJar()
    }

    val implementation by configurations
    val annotationProcessor by configurations
    dependencies {
        implementation(platform(Dependencies.HUTOOL_BOM))
        implementation(Dependencies.MAP_STRUCT)
        annotationProcessor(Dependencies.MAP_STRUCT_PROCESSOR)
    }

    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["java"]) // 适用于 Kotlin JVM 项目

                groupId = group.toString() // 你的组织 ID（必须与 Sonatype 申请的匹配）
                artifactId = "wechat-pay-sdk" // 你的库名称
                version = version // 版本号

                pom {
                    name.set(artifactId)
                    description.set("wechat pay sdk")
                    url.set("https://github.com/lipanre/wechat-pay-sdk")

                    licenses {
                        license {
                            name.set("The Apache License, Version 2.0")
                            url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }

                    developers {
                        developer {
                            id.set("lipanre")
                            name.set("lipanre")
                            email.set("lipanre@gmail.com")
                        }
                    }

                    scm {
                        connection.set("scm:git:git://github.com/lipanre/wechat-pay-sdk")
                        developerConnection.set("scm:git:ssh://github.com/lipanre/wechat-pay-sdk")
                        url.set("https://github.com/lipanre/wechat-pay-sdk")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "sonatype"
                url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/") // 适用于正式发布
                credentials {
                    username = project.findProperty("ossrhUsername") as String? ?: System.getenv("OSSRH_USERNAME")
                    password = project.findProperty("ossrhPassword") as String? ?: System.getenv("OSSRH_PASSWORD")
                }
            }
        }
    }

    signing {

    }

}


