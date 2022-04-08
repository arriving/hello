package org.hello.logger;

import org.springframework.stereotype.Component;

@Component
public class HelloLogger {

    public void info(String str) {
        System.out.println(str);
    }

    public void error(String str) {
        info(str);
    }
}
