package com.test.controller;

import com.test.entity.UserEntity;
import com.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TestController {

    @Autowired
    UserService userService;

    @GetMapping("list")
    public List<UserEntity> test() {
        return userService.listAll();
    }

    @GetMapping("find")
    public List<UserEntity> findBy(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "age", required =  false) Integer age,
                                   @RequestParam(value = "sex", required = false) String sex) {
        return userService.findBy(name, age, sex);
    }

    @GetMapping("findById")
    public UserEntity findById(@RequestParam(value = "id", required = true) Integer id) {
        return userService.findById(id);
    }

    @GetMapping("insert")
    public void insert(@RequestParam(value = "name", required = true) String name,
                       @RequestParam(value = "age", required =  true) Integer age,
                       @RequestParam(value = "sex", required = true) String sex) {
        userService.insert(name, age, sex);
    }

    @GetMapping("insertSelective")
    public void insertSelective(@RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "age", required =  false) Integer age,
                                @RequestParam(value = "sex", required = false) String sex) {
        userService.insertSelective(name, age, sex);
    }

    @GetMapping("update")
    public void update(@RequestParam(value = "id", required = true) Integer id,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "age", required =  false) Integer age,
                       @RequestParam(value = "sex", required = false) String sex) {
        userService.updateBy(id, name, age, sex);
    }

    @GetMapping("delete")
    public void delete(@RequestParam(value = "id", required = false) Integer id,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "age", required =  false) Integer age,
                       @RequestParam(value = "sex", required = false) String sex) {
        userService.delete(id, name, age, sex);
    }

    @GetMapping("deleteById")
    public void deleteById(@RequestParam(value = "id", required = true) Integer id) {
        userService.deleteByPrimaryKey(id);
    }
}
