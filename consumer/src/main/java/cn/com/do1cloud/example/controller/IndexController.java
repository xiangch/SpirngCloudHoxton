package cn.com.do1cloud.example.controller;

import cn.com.do1cloud.example.api.EchoService;
import com.alibaba.fastjson.JSONObject;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
            return JSONObject.toJSONString(echoService.echo(str));
    }

}
