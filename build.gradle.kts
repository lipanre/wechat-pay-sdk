import kotlin.math.sign

plugins {
    `java-library`
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

allprojects {
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
}


