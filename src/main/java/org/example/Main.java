package org.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //将动态代理生成的class文件保存起来
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        ApiService apiService = (ApiService) Proxy.newProxyInstance(ApiService.class.getClassLoader(),
                new Class[]{ApiService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method = " + method.getName() + " , args = " + Arrays.toString(args));
                        return null;
                    }
                });

        System.out.println("ApiService class: " + apiService.getClass());
        apiService.search("keyArgs");
    }

}