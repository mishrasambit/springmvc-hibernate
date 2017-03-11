package com.speed.mixer.controller;

import com.speed.mixer.model.Emp;
import com.speed.mixer.model.User;
import com.speed.mixer.service.EmpService;
import com.speed.mixer.service.UserProfileService;
import com.speed.mixer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by sambit on 2/10/2017.
 */

@RestController
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {
    @Autowired
    UserService userService;

    @Autowired
    EmpService empService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    MessageSource messageSource;

    /**
     * This method will list all existing users.
     */
    @RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
    public List<User> listUsers() {
        List<User> users = userService.findAllUsers();
        return users;
    }

    @RequestMapping(value = { "/newuser" }, method = RequestMethod.POST)
    public User saveUser(@RequestBody @Valid User user) {
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value = { "/emp" }, method = RequestMethod.GET)
    public List<Emp> listEmp() {
        List<Emp> emplist = empService.findAllEmp();
        /*List<Emp> emplist = new ArrayList<Emp>();
        Emp emp = new Emp();
        emp.setId(9);
        emp.setEmail("sambit@abc.com");
        emp.setFirstName("Sambit");
        emp.setLastName("Mishra");
        emplist.add(emp);*/
        return emplist;
    }

    @RequestMapping(value = { "/emp" }, method = RequestMethod.POST)
    public Emp addEmp(@RequestBody Emp emp) {
        empService.saveEmp(emp);
        return emp;
    }

    @RequestMapping(value = { "/emp/{id}" }, method = RequestMethod.GET)
    public Emp showEmp(@PathVariable String id) {
        Emp emp = new Emp();
        emp.setId(Integer.parseInt(id));
        emp.setEmail("sambit@abc.com");
        emp.setFirstName("Sambit");
        emp.setLastName("Mishra");
        return emp;
    }
}
