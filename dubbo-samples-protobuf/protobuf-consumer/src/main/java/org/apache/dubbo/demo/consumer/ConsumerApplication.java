/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.dubbo.demo.consumer;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.demo.DemoService;
import org.apache.dubbo.demo.HelloReply;
import org.apache.dubbo.demo.HelloRequest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;

public class ConsumerApplication {
    public static void main(String[] args) throws Exception {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

//        for (int i = 0; i < 5; i++) {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
            context.start();

//            Runnable run = ()->{
        DemoService demoService = context.getBean("demoService", DemoService.class);
        HelloRequest request = HelloRequest.newBuilder().setName("Hello").build();
        HelloRequest request2 = HelloRequest.newBuilder().setName("Hello2").build();
        HelloRequest request3 = HelloRequest.newBuilder().setName("Hello3").build();

        HelloReply reply = demoService.sayHello(request);
        System.out.println("result: " + reply.getMessage());

//        CompletableFuture<HelloReply> rep = demoService.sayHelloAsync(request);
//        CompletableFuture<HelloReply> rep2 = demoService.sayHelloAsync(request2);
//        CompletableFuture<HelloReply> rep3 = demoService.sayHelloAsync(request3);
//        System.out.println(rep.get().getMessage());
//        System.out.println(rep2.get().getMessage());
//        System.out.println(rep3.get().getMessage());

//            };
//            new Thread(run).start();
//        }


//        ExtensionLoader<Robot> extensionLoader =
//                ExtensionLoader.getExtensionLoader(Robot.class);
//        Robot optimusPrime = extensionLoader.getExtension("optimusPrime");
//        optimusPrime.sayHello();
//        Robot bumblebee = extensionLoader.getExtension("bumblebee");
//        bumblebee.sayHello();

    }


}
