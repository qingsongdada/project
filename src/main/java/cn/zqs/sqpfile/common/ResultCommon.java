package cn.zqs.sqpfile.common;

import lombok.Data;

import java.io.Serializable;

@Data
//@Builder
public class ResultCommon<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public ResultCommon(ResultEnum resultEnum) {
        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public ResultCommon(ResultEnum resultEnum,T data){
        this(resultEnum);
        this.data = data;
    }

    public static ResultCommon success(){
        return new ResultCommon(ResultEnum.SUCCESS);
    }

    public static ResultCommon fail(){
        return new ResultCommon(ResultEnum.FAIL);
    }

    public static <T> ResultCommon success(T data){
        return new ResultCommon(ResultEnum.SUCCESS,data);
    }

    public static <T> ResultCommon fail(T data){
        return new ResultCommon(ResultEnum.FAIL,data);
    }
}
