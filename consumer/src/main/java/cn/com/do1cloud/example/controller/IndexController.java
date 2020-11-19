package cn.com.do1cloud.example.controller;

import cn.com.do1cloud.example.api.EchoService;
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
   // @Autowired
   // private AuthDepartmentClient departmentClient;

    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    public String echo(@PathVariable String str) {
        return echoService.echo(str);
    }
    @RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
    public String queryDepartmentId(@PathVariable String id) {
        //return departmentClient.queryDepartmentInfo(id).getMsg();
        return null;
    }
}
