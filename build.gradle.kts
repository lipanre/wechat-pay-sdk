

// 微信支付sdk封装
description = "wechat-pay-sdk"
allprojects {
    group = extra["SDK_GROUP"] as String
    version = extra["WECHAT_PAY_SDK_VERSION"] as String
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
        classpath("io.spring.gradle:dependency-management-plugin:1.1.6")
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.7.18")
        classpath("io.freefair.gradle:lombok-plugin:8.10.2")
    }
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/central")
        maven("https://maven.aliyun.com/repository/spring")
        maven("https://maven.aliyun.com/repository/google")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
        mavenCentral()
    }

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }


    val implementation by configurations
    val annotationProcessor by configurations



    dependencies {

        ext {
            set("mapstruct-plus.version", "1.4.5")
            set("hutool.version", "5.8.29")
        }

        implementation(platform("cn.hutool:hutool-bom:${ext.get("hutool.version")}"))

        annotationProcessor("io.github.linpeilie:mapstruct-plus-processor:${ext.get("mapstruct-plus.version")}")
        implementation("io.github.linpeilie:mapstruct-plus:${ext.get("mapstruct-plus.version")}")


    }
}


