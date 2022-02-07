package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Robot {
    void sayHello();
}
