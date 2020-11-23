package cn.com.do1cloud.example.api;

/**
 * @author zengxc
 * @since 2020/11/20
 */
public class RestException extends RuntimeException {

    private Integer code;
    private String msg;

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

    private String error;

    public RestException(int code ,String msg,String error){
        super(msg);
        this.code = code;
        this.msg = msg;
        this.error = error;
    }







}
