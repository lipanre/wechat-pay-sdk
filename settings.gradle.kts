pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/gradle-plugin")
        maven("https://maven.aliyun.com/repository/spring-plugin")
        gradlePluginPortal()
    }
}

rootProject.name = "wechat-pay-sdk"
include("wechat-pay-common")
include("wechat-pay-core")
include("wechat-pay-starter")
include("wechat-pay-example")


