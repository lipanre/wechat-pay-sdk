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
        const val WE_CHART_HTTP_CLIENT_V3_SDK: String = "0.4.9"

        /**
         * hutool 版本
         */
        const val HUTOOL = "5.8.29"

        /**
         * mapstruct-plus
         */
        const val MAPSTRUCT_PLUS = "1.4.5"

        /**
         * spring
         */
        const val SPRING = "2.7.18"
        const val SPRING_DEPENDENCY_PLUGIN = "1.1.6"

        /**
         * lombok
         */
        const val LOMBOK = "8.10.2"
    }

}

class Deps {
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
        const val MAP_STRUCT_PLUS_PROCESSOR = "io.github.linpeilie:mapstruct-plus-processor:${Versions.MAPSTRUCT_PLUS}"
        const val MAP_STRUCT_PLUS = "io.github.linpeilie:mapstruct-plus:${Versions.MAPSTRUCT_PLUS}"

        /**
         * spring 相关依赖
         */
        const val SPRING_BOOT_STARTER = "org.springframework.boot:spring-boot-starter"
        const val SPRING_BOOT_STARTER_WEB = "org.springframework.boot:spring-boot-starter-web"
    }
}

class Plugin {
    companion object {
        const val SPRING_BOOT_DEPENDENCY = "io.spring.gradle:dependency-management-plugin:${Versions.SPRING_DEPENDENCY_PLUGIN}"
        const val SPRING_BOOT_GRADLE = "org.springframework.boot:spring-boot-gradle-plugin:${Versions.SPRING}"
        const val LOMBOK = "io.freefair.gradle:lombok-plugin:${Versions.LOMBOK}"
    }
}