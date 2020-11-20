package cn.com.do1cloud.example.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import static org.apache.dubbo.rpc.Constants.TOKEN_KEY;

/**
 * @author zengxc
 * @since 2020/11/20
 */
@Activate
public class SetTokenFilter  implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        context.setInvoker(invoker)
                .setAttachment(TOKEN_KEY,"123456");
        if (invocation instanceof RpcInvocation) {
            ((RpcInvocation) invocation).setInvoker(invoker);
        }
        return invoker.invoke(invocation);
    }
}
