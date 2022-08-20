package com.phoenixhell.springmvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    //1、使用ServletAPI向request域对象共享数据
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */

        ModelAndView mav = new ModelAndView();
        //向请求域共享数据
        mav.addObject("testModelAndView", "hello,ModelAndView");
        //设置视图，实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    //3、使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testModel", "hello,Model");
        System.out.println(model.getClass());  //{testModel=hello,Model}
        return "success";
    }

    //4、使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testMap", "hello,Map");
        System.out.println(map.getClass()); //{testMap=hello,Map}
        return "success";
    }

    //5、使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testModelMap", "hello,ModelMap");
        System.out.println(modelMap.getClass()); //{testModelMap=hello,ModelMap}
        return "success";
    }

    //7、向session域共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //8、向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }

}
