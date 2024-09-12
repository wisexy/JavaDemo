package src.dynamicproxy.jdk;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyRealServiceImpl implements MyRealService {

    @Override
    public void doSomething() {
        log.info("real service do something.");
    }

}
