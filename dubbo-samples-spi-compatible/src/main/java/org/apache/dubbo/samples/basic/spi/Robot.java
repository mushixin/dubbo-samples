package org.apache.dubbo.samples.basic.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Robot {
    void sayHello();
}
