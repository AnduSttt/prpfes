/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.controller;

import com.mycompany.test1.entity.Document;
import com.mycompany.test1.repository.documentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class documentController {

    @Autowired
    private documentRepository documentRepository;

    @GetMapping("/Documents")
    public @ResponseBody
    Iterable<Document> GetDocuments() {
        return documentRepository.findAll();
    }

}
