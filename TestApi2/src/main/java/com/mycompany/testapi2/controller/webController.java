/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.controller;

import com.mycompany.testapi2.entity.Sotrudniki;
import com.mycompany.testapi2.repository.dolhnostRepository;
import com.mycompany.testapi2.repository.rebotnikiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/web")
public class webController {

    @Autowired
    private rebotnikiRepository rebotnikiRepository;

    @Autowired
    private dolhnostRepository dolhnostRepository;

    @GetMapping("/login")
    public ModelAndView LogIn() {
        return new ModelAndView("login");
    }

    @GetMapping("/signin")
    public ModelAndView signIn(
            @RequestParam("pass") String pass,
            @RequestParam("login") String login) {
        if (rebotnikiRepository.SignIn(login, pass) == null) {
            return new ModelAndView("login");
        } else {
            return new ModelAndView("index");
        }
    }

    @GetMapping("/sotrudniki")
    public ResponseEntity AllSotr() {
        if (rebotnikiRepository.findAll() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(rebotnikiRepository.findAll());
        }
    }

    @GetMapping("/getPosition")
    public ResponseEntity Dolhnost(
    @RequestParam("id")String id) {
        Sotrudniki sotr = rebotnikiRepository.findById(Integer.parseInt(id)).get();
        if (sotr.getIdDolshnost().getNazvaniye() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(sotr.getIdDolshnost());
        }
    }
}
