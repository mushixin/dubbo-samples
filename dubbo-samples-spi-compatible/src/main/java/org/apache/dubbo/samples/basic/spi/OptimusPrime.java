package org.apache.dubbo.samples.basic.spi;

public class OptimusPrime implements Robot {
        
        @Override
        public void sayHello() {
            System.out.println("Hello, I am Optimus Prime.");
        }
    }