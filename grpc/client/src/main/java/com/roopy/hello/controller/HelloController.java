package com.roopy.hello.controller;

import com.roopy.hello.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Slf4j
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @PostMapping(value = "/hello")
    public Object sayHello(HttpServletRequest request, HttpServletResponse response,
                           @RequestBody HashMap<String,Object> param) {

        Object obj = helloService.sayHello(param);

        return obj;
    }

}
