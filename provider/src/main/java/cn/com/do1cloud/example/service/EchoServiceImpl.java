package cn.com.do1cloud.example.service;

import cn.com.do1cloud.example.api.EchoService;
import cn.com.do1cloud.example.api.FeignResult;
import cn.com.do1cloud.example.api.RestException;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static cn.com.do1cloud.example.api.Constants.TENANT_ID;


/**
 * @author zengxc
 * @since 2020/11/13
 */
@DubboService
@RestController
public class EchoServiceImpl implements EchoService {

    @GetMapping("/echo")
    @Override
    public FeignResult echo(String message) {
        RpcContext context = RpcContext.getContext();
        if("error".equals(message)){
            throw new RestException(1,"error msg","sssss");
        }
        String token  = RpcContext.getContext().getAttachment(TENANT_ID);
        FeignResult result = new FeignResult();
        result.setData("["+token+"] Hello, " + message);
        return result;
    }
}
