package com.blazen.server.logIn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {
    @RequestMapping(value = "login")
    public String logIn() {
        return "logIn";
    }
}