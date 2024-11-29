package com.lipanre.wechat.pay.sdk.util;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 *
 * @author lipanre
 */
public class StrUtil {

    private static final Matcher matcher = Pattern.compile("([A-Z])").matcher("");

    /**
     * 替换正则表达式
     */
    public static final String REPLACEMENT_REGEXP = "_$1";

    /**
     * 驼峰转下划线
     *
     * @param str 需要转换的字符串
     * @return 下划线字符串
     */
    public static String toUnderLine(String str) {
        matcher.reset(str);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            matcher.appendReplacement(sb, REPLACEMENT_REGEXP);
        }
        matcher.appendTail(sb);
        return sb.toString().toLowerCase(Locale.CHINA);
    }
}
