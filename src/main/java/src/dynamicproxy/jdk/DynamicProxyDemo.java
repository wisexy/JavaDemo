package src.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {

    public static void main(String[] args) {
        // 1. 创建被代理的对象
        MyRealService myRealService = new MyRealServiceImpl();
        // 2. 获取代理的对象的 ClassLoader
        ClassLoader classLoader = myRealService.getClass().getClassLoader();
        // 3. 获取所有接口的Class，这里的RealServiceImpl只实现了两个接口
        Class[] interfaces = myRealService.getClass().getInterfaces();

        // 4. 创建一个将传给代理类的调用请求处理器，处理所有的代理对象上的方法调用
        InvocationHandler invocationHandler = new MyProxyHandler(myRealService);

        // 5. 通过InvocationHandler对象来创建代理对象
        //      1.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
        //      2.然后根据相应的字节码转换成对应的class
        //      3.然后调用newInstance()创建代理实例
        MyRealService proxy = (MyRealService) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        // 调用代理方法
        proxy.doSomething();
    }

}
