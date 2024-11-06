/**
 * 依赖相关
 *
 * @author lipanre
 */
class Versions {

    companion object {
        /**
         * 微信http-client sdk v3版本
         */
        const val WE_CHART_HTTP_CLIENT_V3_SDK: String = "0.4.8"

        /**
         * hutool 版本
         */
        const val HUTOOL = "5.8.29"

        /**
         * mapstruct-plus
         */
        const val MAPSTRUCT = "1.6.2"

        /**
         * spring
         */
        const val SPRING = "2.7.18"
        const val SPRING_DEPENDENCY_PLUGIN = "1.1.6"

        /**
         * lombok
         */
        const val LOMBOK = "8.10.2"

        /**
         * jackson
         */
        const val JACKSON_VERSION = "2.18.1"
    }

}

class Dependencies {
    companion object {
        /**
         * 微信http-client sdk v3
         */
        const val WE_CHAT_HTTP_CLIENT_V3_SDK = "com.github.wechatpay-apiv3:wechatpay-apache-httpclient:${Versions.WE_CHART_HTTP_CLIENT_V3_SDK}"

        /**
         * hutool bom
         */
        const val HUTOOL_BOM = "cn.hutool:hutool-bom:${Versions.HUTOOL}"

        /**
         * mapstruct-plus
         */
        const val MAP_STRUCT = "org.mapstruct:mapstruct:${Versions.MAPSTRUCT}"
        const val MAP_STRUCT_PROCESSOR = "org.mapstruct:mapstruct-processor:${Versions.MAPSTRUCT}"

        /**
         * jackson
         */
        const val JACKSON_CORE = "com.fasterxml.jackson.core:jackson-core:${Versions.JACKSON_VERSION}"
        const val JACKSON_DATABIND = "com.fasterxml.jackson.core:jackson-databind:${Versions.JACKSON_VERSION}"
        const val JACKSON_DATATYPE_JSR310 = "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:${Versions.JACKSON_VERSION}"

        /**
         * spring 相关依赖
         */
        const val SPRING_BOOT_STARTER = "org.springframework.boot:spring-boot-starter"
        const val SPRING_BOOT_STARTER_WEB = "org.springframework.boot:spring-boot-starter-web"
        const val SPRING_BOOT_CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"
        const val SPRING_BOOT_AUTOCONFIGURE_PROCESSOR = "org.springframework.boot:spring-boot-autoconfigure-processor"

        /**
         * logback配置
         */
        const val LOG_BACK_CORE = "ch.qos.logback:logback-core"
        const val LOG_BACK_CLASSIC = "ch.qos.logback:logback-classic"
    }
}

class Plugin {
    companion object {
        const val SPRING_BOOT_DEPENDENCY = "io.spring.gradle:dependency-management-plugin:${Versions.SPRING_DEPENDENCY_PLUGIN}"
        const val SPRING_BOOT_GRADLE = "org.springframework.boot:spring-boot-gradle-plugin:${Versions.SPRING}"
        const val LOMBOK = "io.freefair.gradle:lombok-plugin:${Versions.LOMBOK}"
    }
}