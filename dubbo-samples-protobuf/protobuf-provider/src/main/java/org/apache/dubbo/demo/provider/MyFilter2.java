package org.apache.dubbo.demo.provider;

import com.alibaba.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.SPI;
import org.apache.dubbo.rpc.*;

@SPI("myFilter2")
@Activate(group = Constants.PROVIDER)
public class MyFilter2 implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("MyFilter2");
        return invoker.invoke(invocation);
    }
}