package cn.com.do1cloud.example.filter;

import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.util.Map;

import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;
import static org.apache.dubbo.rpc.Constants.TOKEN_KEY;


/**
 * @author zengxc
 * @since 2020/11/20
 */
@Activate(group =PROVIDER )
public class TokenFilter  implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        Map<String, Object> attachments = invocation.getObjectAttachments();
        String remoteToken = (attachments == null ? null : (String) attachments.get(TOKEN_KEY));
        RpcContext.getContext().set(TOKEN_KEY,remoteToken);

        return invoker.invoke(invocation);
    }
}
