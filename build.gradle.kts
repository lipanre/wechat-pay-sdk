

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
        classpath(Plugin.SPRING_BOOT_DEPENDENCY)
        classpath(Plugin.SPRING_BOOT_GRADLE)
        classpath(Plugin.LOMBOK)
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
        implementation(platform(Deps.HUTOOL_BOM))
        annotationProcessor(Deps.MAP_STRUCT_PLUS_PROCESSOR)
        implementation(Deps.MAP_STRUCT_PLUS)
    }
}


