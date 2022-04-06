package org.hello.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hello.service.ListFileService;

@Controller
public class HelloController {

    @Autowired
    ListFileService listFileService;

    @RequestMapping(value = "/hello/ls", method = RequestMethod.GET)
    public @ResponseBody
    ResponseEntity<List> listFiles(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String path = request.getParameter("path");
	path = URLDecoder.decode(path, "UTF-8");

        List<String> list = listFileService.listFiles(path);
        return new ResponseEntity<List>(list, HttpStatus.OK);
    }

}


