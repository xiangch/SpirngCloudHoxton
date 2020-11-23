package cn.com.do1cloud.example.api;

import java.io.Serializable;

public class FeignResult<T> implements Serializable {

    private Integer code;
    private String msg;
    private String error;
    private T data;

    public FeignResult() {

    }
    public FeignResult(RestException exception) {
           this.code = exception.getCode();
           this.msg  =exception.getMsg();
           this.error =  exception.getError();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }


    public void setData(T data) {
        this.data = data;
    }




}
