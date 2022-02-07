package org.apache.dubbo.demo.consumer;

import com.alibaba.dubbo.common.Constants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.extension.SPI;
import org.apache.dubbo.rpc.*;

@SPI("myFilter")
@Activate(group = Constants.CONSUMER)
public class MyFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println("MyFilter");
        return invoker.invoke(invocation);
    }
}