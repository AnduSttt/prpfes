/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.controller;

import com.mycompany.test1.entity.Comment;
import com.mycompany.test1.repository.commentaryRepository;
import java.util.ArrayList;
import java.util.List;
import org.json.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/Document")
public class commentController {

    @Autowired
    private commentaryRepository commentaryRepository;

    @GetMapping("/{documentId}/comments")
    public ResponseEntity<List<Comment>> getComment(@PathVariable("documentId") int iddoc) {

        List com = new ArrayList();
        for (Comment c : commentaryRepository.findAll()) {
            if (c.getIdDocument().getIdDocument() == iddoc) {
                com.add(c);
            }
        }
        if (com == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(com);
        }
    }

//    @PostMapping("/{documentId}/coment")
//    public @ResponseBody
//    Iterable addComment(@PathVariable("documentId") int iddoc,
//             @PathVariable("text") String text,
//            @PathVariable("")){
//        
//    }
}
