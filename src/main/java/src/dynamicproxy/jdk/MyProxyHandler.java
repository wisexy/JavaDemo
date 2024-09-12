package src.dynamicproxy.jdk;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 代理类
 *
 */
@Slf4j
@AllArgsConstructor
public class MyProxyHandler implements InvocationHandler {

    Object target;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        log.info("before invoke.");
    }

    private void after() {
        log.info("after invoke.");
    }

}
