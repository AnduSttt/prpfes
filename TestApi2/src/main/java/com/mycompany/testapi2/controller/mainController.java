/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.controller;

import com.mycompany.testapi2.entity.Commentaries;
import com.mycompany.testapi2.repository.commentsRepository;
import com.mycompany.testapi2.repository.documentRepository;
import com.mycompany.testapi2.repository.rebotnikiRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class mainController {

    public DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private rebotnikiRepository rebotnikiRepository;

    @PostMapping("/SignIn")
    public ResponseEntity SignIn(
            @RequestParam("password") String parol,
            @RequestParam("login") String login) {
        if (rebotnikiRepository.SignIn(login, parol) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Map<String,Object> map = new HashMap<>();
            map.put("name", rebotnikiRepository.SignIn(login, parol).getLogin());
            map.put("password", rebotnikiRepository.SignIn(login, parol).getPassword());
            return ResponseEntity.ok(map);
        }
    }

    @Autowired
    private documentRepository documentRepository;

    @GetMapping("/Documents")
    public ResponseEntity allDocuments() {
        if (documentRepository.findAll() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(documentRepository.findAll());
        }
    }

    @Autowired
    private commentsRepository commentsRepository;

    @GetMapping("/Documents/{documentId}/Comments")
    public ResponseEntity allCommentsThisDocument(
            @PathVariable("documentId") String id) {
        if (commentsRepository.GetComment((documentRepository.findById(Integer.valueOf(id))).get()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(commentsRepository.GetComment((documentRepository.findById(Integer.valueOf(id))).get()));
        }
    }

    @PostMapping("/Documents/{documentId}/Comment")
    public ResponseEntity commentDocument(
            @PathVariable("documentId") String id,
            @RequestParam("author") String idAutor,
            @RequestParam("text") String text,
            @RequestParam("dateUpdated") String dateUpdated,
            @RequestParam("dateCreated") String dateCreated) {
        if (documentRepository.findById(Integer.valueOf(id)).get() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Commentaries com = new Commentaries();
            com.setAuthor(rebotnikiRepository.findById(Integer.parseInt(idAutor)).get());
            try {
                com.setDateCreated(format.parse(dateCreated));
            } catch (ParseException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                com.setDateUpdated(format.parse(dateUpdated));
            } catch (ParseException ex) {
                Logger.getLogger(mainController.class.getName()).log(Level.SEVERE, null, ex);
            }
            com.setDocumentId(documentRepository.findById(Integer.valueOf(id)).get());
            com.setText(text);

            commentsRepository.save(com);
            return ResponseEntity.ok(true);
        }
    }

}
