package org.hello.service;

import org.hello.logger.HelloLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloLogger logger;

    @Override
    public List<String> listFiles(String path) {
        String cmd = "ls " + path;
        logger.info("cmd: " + cmd);
        List<String> list = exec(new String[] {"/bin/sh", "-c", cmd});
        logger.info("list size:" + list.size());
        return list;
    }

    @Override
    public String readFileContent(String path) {
        String content = null;
        try {
            byte[] bytes = readAllBytes(path);
            content = new String(bytes);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
        }
        return content;
    }

    private List<String> exec(String[] cmdArray) {
        List<String> list = new ArrayList<>();
        BufferedReader br = null;
        try {
        /*
        Process process = exec(new String[] {"/bin/sh", "-c", cmd});
        br = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        int exitVal = process.waitFor();
        */
            int exitVal = 0;
            logger.info("Process exitValue: " + exitVal);
        } catch (Exception e) {
            logger.error("Exception: " + e.getMessage());
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

    private byte[] readAllBytes(String path) {
       // return Files.readAllBytes(Paths.get(path));
        return null;
    }

}



