package cn.com.do1cloud.example.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import static cn.com.do1cloud.example.api.Constants.TENANT_ID;
import static org.apache.dubbo.common.constants.CommonConstants.CONSUMER;

/**
 * @author zengxc
 * @since 2020/11/20
 */
@Activate(group = CONSUMER)
public class SetTenantFilter  implements Filter {

    private String tenant_id="DO1";
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        context.setInvoker(invoker)
                .setAttachment(TENANT_ID,tenant_id);
        if (invocation instanceof RpcInvocation) {
            ((RpcInvocation) invocation).setInvoker(invoker);
        }
        return invoker.invoke(invocation);
    }
}
