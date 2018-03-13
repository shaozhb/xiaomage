package com.example.demo.x1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 2018/3/13.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String getHello(){
        return "hello word!";
    }
}
