package cn.com.do1cloud.example.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER;
import static org.apache.dubbo.rpc.Constants.TOKEN_KEY;

/**
 * @author zengxc
 * @since 2020/11/20
 */
@Activate(group = CONSUMER)
public class SetTokenFilter  implements Filter {

    private String token="THE TOKEN";
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        context.setInvoker(invoker)
                .setAttachment(TOKEN_KEY,token);
        if (invocation instanceof RpcInvocation) {
            ((RpcInvocation) invocation).setInvoker(invoker);
        }
        return invoker.invoke(invocation);
    }
}
