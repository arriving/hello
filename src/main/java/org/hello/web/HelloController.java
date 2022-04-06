package org.hello.web;

import org.hello.util.MagicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hello.service.FileService;

@Controller
public class HelloController {

    @Autowired
    FileService fileService;

    @RequestMapping(value = "/hello/ls", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List> listFiles(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (!MagicUtil.checkRight(request)) {
            return new ResponseEntity<>(Collections.EMPTY_LIST, HttpStatus.FORBIDDEN);
        }
        String path = request.getParameter("path");
	    path = MagicUtil.processPath(path);

        List<String> list = fileService.listFiles(path);
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/hello/content", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<String> readContent(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getParameter("path");
        path = MagicUtil.processPath(path);

        return new ResponseEntity<String>(fileService.readFileContent(path), HttpStatus.OK);
    }
}


