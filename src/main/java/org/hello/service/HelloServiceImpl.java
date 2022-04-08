package org.hello.service;

import org.hello.logger.HelloLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloLogger logger;

    @Override
    public List<String> listFiles(String path) {
        List<String> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            String cmd = "ls " + path;
            logger.info(cmd);
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(new String[] {"/bin/sh", "-c", cmd});
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            int exitVal = process.waitFor();
            logger.info("Process exitValue: " + exitVal);
        } catch (Exception ei) {
            logger.error("Exception: " + ei.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                }
            }
        }
        return list;
    }

    @Override
    public String readFileContent(String path) {
        String content = null;
        try {
            doSomething(path);
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            content = new String(bytes);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        }
        return content;
    }

    private void doSomething(String str) {
        // do something
        logger.info("doSomething: " + str);
    }

}



