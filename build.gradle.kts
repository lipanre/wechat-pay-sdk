import com.vanniktech.maven.publish.SonatypeHost
plugins {
    `java-library`
    id("com.vanniktech.maven.publish") version "0.31.0"
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
    apply(plugin = "com.vanniktech.maven.publish")
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

    if (!project.name.endsWith("example")) {
        mavenPublishing {
            // Define coordinates for the published artifact
            coordinates(
                groupId = "io.github.lipanre",
                artifactId = project.name,
                version = "1.0.0"
            )

            // Configure POM metadata for the published artifact
            pom {
                name.set("WeChat Pay SDK")
                description.set("Wechat http v3 Pay SDK")
                inceptionYear.set("2025")
                url.set("https://github.com/lipanre/wechat-pay-sdk")

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                // Specify developers information
                developers {
                    developer {
                        id.set("lipanre")
                        name.set("lipanre")
                        email.set("lipanre@qq.com")
                    }
                }

                // Specify SCM information
                scm {
                    url.set("https://github.com/lipanre/wechat-pay-sdk")
                }
            }

            // Configure publishing to Maven Central
            publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

            // Enable GPG signing for all publications
            signAllPublications()
        }

    }

}


