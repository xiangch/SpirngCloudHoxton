package cn.com.do1cloud.example.filter;

import cn.com.do1cloud.example.service.TenantService;
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
private TenantService tenantService;

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        context.setInvoker(invoker)
                .setAttachment(TENANT_ID,tenantService.getTenantId());
        if (invocation instanceof RpcInvocation) {
            ((RpcInvocation) invocation).setInvoker(invoker);
        }
        return invoker.invoke(invocation);
    }
    public void setTenantService(TenantService tenantService){
        this.tenantService = tenantService;

    }
}
