package com.shuoshu.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by mutou on 2016/8/28.
 */
public class UUIDUtil {
    /**
     * 时间格式化
     */
    protected static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMdd");

    /**
     * 产生唯一 的序列号。
     *
     * @return String
     */
    public static String getSerialNumber() {
        int hashCode = UUID.randomUUID().toString().hashCode();
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return SDF.format(new Date()).substring(2, 8) + String.format("%010d", hashCode);
    }

    public static void main(String[] args) {
        System.out.println(getSerialNumber());
    }
}
