package com.excel.enums;

/**
 * @author zhourui
 * @version 1.0
 * @date 19-8-15 下午5:40
 */
public enum WeekEnum {

    /**
     * 获取星期
     */
    MONDAY("1", "星期一"),
    TUESDAY("2", "星期二"),
    WEDNESDAY("3", "星期三"),
    THURSDAY("4", "星期四"),
    FRIDAY("5", "星期五"),
    SATURDAY("6", "星期六"),
    SUNDAY("7", "星期天");

    private String code;
    private String message;

    WeekEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static WeekEnum getEnum(Integer code) {
        for (WeekEnum weekEnum : WeekEnum.values()) {
            if (Integer.valueOf(weekEnum.getCode()).equals(code)) {
                return weekEnum;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
