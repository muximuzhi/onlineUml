package com.onlineUml.item.controller;

import com.onlineUml.item.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.ws.Response;

@Controller
@RequestMapping("user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 注册用户
     * @param name
     * @param password
     * @return
     */
    @PostMapping()
    public ResponseEntity<Void> addUser(@RequestParam("name") String name,
                                        @RequestParam("passsword") String password) {
        this.userService.addUser(name, password);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * 登录，成功返回1，失败返回0
     * @param name
     * @param password
     * @return
     */
    @GetMapping("login")
    public ResponseEntity<Integer> checkUser(@RequestParam("name") String name,
                                          @RequestParam("password") String password) {
        if(this.userService.checkUser(name, password)) return ResponseEntity.ok(1);
        else return ResponseEntity.ok(0);
    }
}
