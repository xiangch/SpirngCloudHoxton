package cn.com.do1cloud.example.api;

/**
 * @author zengxc
 * @since 2020/11/13
 */
public interface EchoService {

    FeignResult<String> echo(String message);
}
