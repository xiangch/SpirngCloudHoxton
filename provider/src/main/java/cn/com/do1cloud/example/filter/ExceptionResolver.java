package cn.com.do1cloud.example.filter;

import cn.com.do1cloud.example.api.FeignResult;
import cn.com.do1cloud.example.api.RestException;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import static org.apache.dubbo.common.constants.CommonConstants.PROVIDER;

/**
 * @author zengxc
 * @since 2020/11/20
 */
@Activate(group =PROVIDER )
public class ExceptionResolver implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result rpcResult = invoker.invoke(invocation);
        Object object = rpcResult.getValue();
        Throwable ex = rpcResult.getException();
        FeignResult feignResult = null;
        if (object instanceof FeignResult) {
            feignResult = (FeignResult) object;
        }
        if (ex instanceof Throwable) {
            rpcResult.setException(null);
            if (ex instanceof RestException) {
                feignResult = new FeignResult((RestException) ex);
            } else {
                feignResult = new FeignResult();
                feignResult.setError(ex.getMessage());
            }
        }
        if (feignResult != null) {
            rpcResult.setValue(feignResult);
        }

        return rpcResult;
    }
}
