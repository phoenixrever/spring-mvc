package com.phoenixhell.jsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {
    @GetMapping("/success")
    public String success(){
        return "success";
    }
}
