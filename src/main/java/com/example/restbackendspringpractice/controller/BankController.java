package com.example.restbackendspringpractice.controller;

import com.example.restbackendspringpractice.domain.LoginInfo;
import com.example.restbackendspringpractice.domain.UserInfo;
import com.example.restbackendspringpractice.exception.InvalidUserNameException;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
public class BankController {

    private Map<String, UserInfo> users = Map.of(
            "Masha", UserInfo.builder().userName("Masha").build(),
    "Tima", UserInfo.builder().userName("Tima").build(),
    "Patonya", UserInfo.builder().userName("Patonya").build()
    );

    @PostMapping("user/login")
    @ApiOperation("Authorization")
    public UserInfo doLogin(@RequestBody LoginInfo loginInfo) {
        if (loginInfo.getUserName().equals("Tima")) {
            return UserInfo.builder()
                    .loginDate(new Date())
                    .userName(loginInfo.getUserName())
                    .build();
        } else {
            throw new InvalidUserNameException();
        }
    }

    @GetMapping("user/getAll")
    @ApiOperation("Getting list of Users")
    public List<UserInfo> getAllUsersInfo(){
        return users.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
