
//plugins {
//    id("org.jreleaser") version "1.15.0" apply false
//}

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
}

subprojects {
    apply(plugin = "java-library")
    apply(plugin = "io.freefair.lombok")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "maven-publish")
//    apply(plugin = "org.jreleaser")

    configure<JavaPluginExtension> {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        withJavadocJar()
        withSourcesJar()
    }

//    configure<PublishingExtension> {
//        publications {
//            create<MavenPublication>("mavenJava") {
//                from(components["java"])
//                groupId = project.group.toString()
//                artifactId = project.name
//                version = project.version.toString()
//
//                pom {
//                    name = "app"
//                    description = "Sample application"
//                    url = "https://github.com/aalmiray/app"
//                    inceptionYear = "2021"
//
//                    licenses {
//                        license {
//                            name = "Apache-2.0"
//                            url = "https://spdx.org/licenses/Apache-2.0.html"
//                        }
//                    }
//
//                    developers {
//                        developer {
//                            id = "MainTainer"
//                            name = "lipanre"
//                        }
//                    }
//
//                    scm {
//                        connection = "scm:git:https://github.com/aalmiray/app.git"
//                        developerConnection = "scm:git:ssh://github.com/aalmiray/app.git"
//                        url = "http://github.com/aalmiray/app"
//                    }
//                }
//                versionMapping {
//                    usage("java-api") {
//                        fromResolutionOf("runtimeClasspath")
//                    }
//                    usage("java-runtime") {
//                        fromResolutionResult()
//                    }
//                }
//            }
//        }
//
//        repositories {
//            maven {
//                url = uri(layout.buildDirectory.dir("staging-deploy"))
//            }
//        }
//    }
//
//    configure<JReleaserExtension> {
//        signing {
//            setActive("ALWAYS")
//            setMode("FILE")
//            armored = true
//            publicKey = "/Users/hanqf/develop_soft/gpg_key/hanqf/public.pgp"
//            secretKey = "/Users/hanqf/develop_soft/gpg_key/hanqf/private.pgp"
//        }
//
//        deploy {
//            maven {
//                mavenCentral {
//                    setActive("ALWAYS")
//                }
//            }
//        }
//    }


    val implementation by configurations
    val annotationProcessor by configurations
    dependencies {
        implementation(platform(Dependencies.HUTOOL_BOM))
        annotationProcessor(Dependencies.MAP_STRUCT_PLUS_PROCESSOR)
        implementation(Dependencies.MAP_STRUCT_PLUS)
    }


    afterEvaluate {
        if (!project.name.endsWith("-example")) {
            project.extensions.getByType<PublishingExtension>().apply {
                publications {
                    create<MavenPublication>("mavenJava") {
                        from(components["java"])
                        groupId = project.group.toString()
                        artifactId = project.name
                        version = project.version.toString()
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
    }

}


