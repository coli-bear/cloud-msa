package com.example.cloudmember.domains.enums;

import org.apache.commons.lang.StringUtils;

public enum CommonCode {
    ALREADY_EXIST("already exists", 0),
    NOT_FOUND("not found", 1);

    private String value;
    private int code;

    CommonCode(String value, int code) {
        this.code = code;
        this.value = value;
    }

    public static CommonCode findBy(String arg) {
        for (CommonCode code : values()) {
            if (StringUtils.equals(arg, code.name())) {
                return code;
            }
        }

        return null;
    }
}
