package me.jmfs.pattern.constant;

import java.util.Objects;

/**
 * @Author: 囧么肥事
 * @Date: 2023/3/20
 * @Email: jiongmefeishi@163.com
 * @Url("https://gitee.com/jiongmefeishi")
 * @Description: 
 */
public enum ProductEnum {
    
    A(1, "产品A"),
    B(2, "产品B")
    ;

    private int code;
    private String desc;


    ProductEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByName(String name) {
        for (ProductEnum roleEnum : ProductEnum.values()) {
            if (roleEnum.name().equalsIgnoreCase(name)) {
                return roleEnum.getDesc();
            }
        }

        return null;
    }

    public static ProductEnum getByCode(Integer code) {
        for (ProductEnum s : ProductEnum.values()) {
            if (Objects.equals(s.getCode(), code)) {
                return s;
            }
        }
        return null;
    }
}
