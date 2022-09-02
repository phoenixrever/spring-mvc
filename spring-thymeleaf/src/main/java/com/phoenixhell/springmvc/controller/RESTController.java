package com.phoenixhell.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RESTController {
    @PutMapping("/user")
    public String success(HttpServletRequest request, Model model){
        String method = request.getMethod();
        System.out.println(method);
        model.addAttribute("method",method);
        return "rest";
    }
}
