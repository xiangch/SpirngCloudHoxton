package cn.com.do1cloud.example.api;

/**
 * @author zengxc
 * @since 2020/11/20
 */
public class RpcException extends RuntimeException {

    private Integer code;
    private String msg;
    private String error;

    public RpcException(int code ,String msg,String error){
        super(msg);
        this.code = code;
        this.msg = msg;
        this.error = error;
    }



}
