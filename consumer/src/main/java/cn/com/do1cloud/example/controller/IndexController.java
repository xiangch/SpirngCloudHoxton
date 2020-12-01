package cn.com.do1cloud.example.controller;

import cn.com.do1cloud.example.api.EchoService;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static cn.com.do1cloud.example.api.Constants.TENANT_ID;

/**
 * @author zengxc
 * @since 2020/11/18
 */
@RestController
public class IndexController {
    @DubboReference
    private EchoService echoService;


    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        RpcContext.getContext().setAttachment(TENANT_ID,"bb01a3cd987f469d9e0f04dffa2d3278");
            return JSONObject.toJSONString(echoService.echo(str));
    }

}
