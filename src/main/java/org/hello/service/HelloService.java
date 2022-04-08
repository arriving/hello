package org.hello.service;

import java.util.List;

public interface HelloService {
    
    List<String> listFiles(String path);

    String readFileContent(String path);

}



