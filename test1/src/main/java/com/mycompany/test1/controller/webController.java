/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.controller;

import ch.qos.logback.core.model.Model;
import com.mycompany.test1.entity.Employees;
import com.mycompany.test1.repository.employeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/web")
@SessionAttributes("UserId")
public class webController {

    @Autowired
    private employeesRepository employeesRepository;

    @GetMapping("/login")
    public ModelAndView LogIn() {
        return new ModelAndView("document");
    }

    @GetMapping("/signIn")
    public ModelAndView SignIn(@RequestParam("login") String login,
            @RequestParam("password") String password, Model model) {
        Employees emp1 = employeesRepository.findLoginAndPassword(login, password);
        if (emp1 != null) {
            ModelAndView enter = new ModelAndView("hello");
            enter.addObject("message", emp1.getName());
            return enter;
        } else {
            return new ModelAndView("document");
        }

    }

}
