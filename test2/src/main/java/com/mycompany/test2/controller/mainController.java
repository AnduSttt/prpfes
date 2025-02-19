/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test2.controller;

import com.mycompany.test2.entity.Departments;
import com.mycompany.test2.repository.DepartamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/t2")
public class mainController {

    @Autowired
    private DepartamentRepository DepartamentRepository;

    @GetMapping("/d")
    public @ResponseBody
    Iterable<Departments> Gd() {

        return DepartamentRepository.findAll();

    }

}
