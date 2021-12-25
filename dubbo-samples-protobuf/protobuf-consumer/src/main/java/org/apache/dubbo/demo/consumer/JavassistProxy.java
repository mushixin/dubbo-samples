package org.apache.dubbo.demo.consumer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class JavassistProxy extends ClassLoader {

    public static interface IUserApi{
        String queryUserInfo();
    }

    public static class UserApi implements IUserApi{
        @Override
        public String queryUserInfo() {
            return "UserApi";
        }
    }

    public static <T> T getProxy(Class clazz) throws Exception {

        ClassPool pool = ClassPool.getDefault();
        // 获取类
        CtClass ctClass = pool.get(clazz.getName());
        // 获取方法
        CtMethod ctMethod = ctClass.getDeclaredMethod("queryUserInfo");
        // 方法前加强
        ctMethod.insertBefore("{System.out.println(\"" + ctMethod.getName() + " 你被代理了，By Javassist\");}");

        byte[] bytes = ctClass.toBytecode();

        return (T) new JavassistProxy().defineClass(clazz.getName(), bytes, 0, bytes.length).newInstance();
    }

    public static void main(String[] args) throws Exception {
        IUserApi userApi = JavassistProxy.getProxy(UserApi.class);
        String invoke = userApi.queryUserInfo();
        System.out.println("测试结果：{}"+invoke);
    }

/**
 * 测试结果：
 *
 * queryUserInfo 你被代理了，By Javassist
 * 20:23:39.139 [main] INFO  org.itstack.interview.test.ApiTest - 测试结果：小傅哥，公众号：bugstack虫洞栈 | 沉淀、分享、成长，让自己和他人都能有所收获！
 *
 * Process finished with exit code 0
 */

}

