package cn.zqs.sqpfile.common;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(200,"请求成功"),
    FAIL(6000,"请求失败")
    ;

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
