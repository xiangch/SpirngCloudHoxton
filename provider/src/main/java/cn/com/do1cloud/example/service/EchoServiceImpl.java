package cn.com.do1cloud.example.service;

import cn.com.do1cloud.example.api.EchoService;
import cn.com.do1cloud.example.api.RpcException;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zengxc
 * @since 2020/11/13
 */
@DubboService
@RestController
public class EchoServiceImpl implements EchoService {
    @GetMapping("/echo")
    @Override
    public String echo(String message) {
        RpcContext context = RpcContext.getContext();
        if("error".equals(message)){
            throw new RpcException(1,"error msg","sssss");
        }
        return context.get("token")+" [echo] Hello, " + message;
    }
}
