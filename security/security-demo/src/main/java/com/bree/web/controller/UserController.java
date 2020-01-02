package com.bree.web.controller;

import com.bree.exception.UserNotExistException;
import com.bree.web.dto.User;
import com.bree.web.dto.UserQueryCondition;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

//    pageable 分页注解
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,@PageableDefault(page = 2 ,size = 17,sort = "username,asc") Pageable pageable){
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

//  @PathVariable 该注解将路径中的值映射到参数上
//   \d+ 该正则表达时表示只能接受数字
//    @JSONView 该注解通过接口视图的方式，确定要展示哪个字段（参考实体类定义）
    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable(name = "id") String du){
//        throw new UserNotExistException(du);
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().stream().forEach(error -> {
                FieldError fieldError = (FieldError)error;
                String message =fieldError.getField()+" "+ error.getDefaultMessage();
                System.out.println(message);
                System.out.println(error.getDefaultMessage());
            }
                );
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getId());
        user.setId("1");
        return user;
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable(name = "id") String du){
        System.out.println(du);
    }
}
