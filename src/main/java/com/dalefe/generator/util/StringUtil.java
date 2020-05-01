package com.dalefe.generator.util;

import java.io.File;

/**
 * @author dalefe
 * @version  2019/11/07
 */
public class StringUtil {

    public static boolean isBlank(String string) {
        if (string == null || string.trim().equals("")) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 首字母小写
     */
    public static String firstToLowerCase(String string) {
        StringBuilder sb = new StringBuilder();
        sb.append(string.substring(0, 1).toLowerCase()).append(string.substring(1));
        return sb.toString();
    }


    public static String package2Path(String packageName) {
        if (StringUtil.isBlank(packageName)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] packages = packageName.split("\\.");
        for (String str : packages) {
            sb.append(str).append(File.separator);
        }
        return sb.toString();
    }

}
