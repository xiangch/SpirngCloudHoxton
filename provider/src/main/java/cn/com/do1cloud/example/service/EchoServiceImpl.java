package cn.com.do1cloud.example.service;

import cn.com.do1cloud.example.api.EchoService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author zengxc
 * @since 2020/11/13
 */
@DubboService
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String message) {
        return "[echo] Hello, " + message;
    }
}
