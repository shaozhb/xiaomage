package com.example.demo.x2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by hp on 2018/3/13.
 */
@RestController
@RequestMapping(value="/users")
public class UserController {
    //线程安全
    static Map<Long,User> users= Collections.synchronizedMap(new HashMap<Long,User>());

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList(){
        List<User> u=new ArrayList<User>(users.values());
        return  u;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        users.put(user.getId(),user);
        return "success !";

    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable Long id){

        return users.get(id);

    }

    @PutMapping(value = "/{id}")
    public String putUser(@PathVariable Long id,@ModelAttribute User user){
        User u=users.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        users.put(id,u);
        return "success";
    }

    @DeleteMapping(value = "/{id}")
    public String 
}
