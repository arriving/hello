package org.hello.service;

import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Service
public class ListFileServiceImpl implements ListFileService {

    @Override
    public List<String> listFiles(String path) {
        List<String> list = new ArrayList<>();
        BufferedReader br = null;
        try {
            String cmd = "ls " + path;
            System.out.println(cmd);
            Process process = Runtime.getRuntime().exec(new String[] {"/bin/sh","-c", cmd});
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            int exitVal = process.waitFor();
            System.out.println("Process exitValue: " + exitVal);
        } catch (Exception ei) {
            System.out.println("Exception: " + ei.getMessage());
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
}



