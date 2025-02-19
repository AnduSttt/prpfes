/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testapi2.controller;

import com.mycompany.testapi2.entity.Sotrudniki;
import com.mycompany.testapi2.repository.dolhnostRepository;
import com.mycompany.testapi2.repository.padrazdeleniyaRepository;
import com.mycompany.testapi2.repository.rebotnikiRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class descktopController {

    public DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private padrazdeleniyaRepository padrazdeleniyaRepository;

    @Autowired
    private dolhnostRepository dolhnostRepository;

    @Autowired
    private rebotnikiRepository rebotnikiRepository;

    @GetMapping("/departments")
    public ResponseEntity AllDepart() {
        if (padrazdeleniyaRepository.findAll() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(padrazdeleniyaRepository.findAll());
        }
    }

    @GetMapping("/departments/sotrudniki")
    public ResponseEntity AllDepartSotrudniki(
            @RequestParam("idDepart") String idDepart) {
        if (rebotnikiRepository.AllSotrudnikiDepart(padrazdeleniyaRepository.findById(Integer.parseInt(idDepart)).get()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(rebotnikiRepository.AllSotrudnikiDepart(padrazdeleniyaRepository.findById(Integer.parseInt(idDepart)).get()));
        }
    }

    @GetMapping("/dolhnost")
    public ResponseEntity AllDolhnost() {
        if (dolhnostRepository.findAll() == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(dolhnostRepository.findAll());
        }
    }

    @GetMapping("/sotrudnik")
    public ResponseEntity SotrById(
            @RequestParam("id") String id) {
        if (rebotnikiRepository.findById(Integer.parseInt(id)) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(rebotnikiRepository.findById(Integer.parseInt(id)));
        }
    }

    @GetMapping("/sotrudnikAdd")
    public ResponseEntity AllDolhnost(
            @RequestParam("familiya") String familiya,
            @RequestParam("imya") String imya,
            @RequestParam("otchestvo") String otchestvo,
            @RequestParam("workNomer") String workNomer,
            @RequestParam("persolalNomer") String persolalNomer,
            @RequestParam("cabinet") String cabinet,
            @RequestParam("corporatEmail") String corporatEmail,
            @RequestParam("denRoshdeniya") String denRoshdeniya,
            @RequestParam("idDolshnost") String idDolshnost,
            @RequestParam("idPosition") String idPosition
    ) {
        Sotrudniki sotr = new Sotrudniki();

        sotr.setCabinet(cabinet);
        sotr.setCorporatEmail(corporatEmail);
        try {
            sotr.setDenRoshdeniya(format.parse(denRoshdeniya));
        } catch (ParseException ex) {
            Logger.getLogger(descktopController.class.getName()).log(Level.SEVERE, null, ex);
        }
        sotr.setFamiliya(familiya);
        sotr.setIdDolshnost(dolhnostRepository.findById(Integer.parseInt(idDolshnost)).get());
        sotr.setIdPodrazd(padrazdeleniyaRepository.findById(Integer.parseInt(idDolshnost)).get());
        sotr.setImya(imya);
        sotr.setOtchestvo(otchestvo);
        sotr.setPersolalNomer(persolalNomer);
        sotr.setWorkNomer(workNomer);
        rebotnikiRepository.save(sotr);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/sotrudnikUpdate")
    public ResponseEntity AllDolhnost(
            @RequestParam("id") String id,
            @RequestParam("familiya") String familiya,
            @RequestParam("imya") String imya,
            @RequestParam("otchestvo") String otchestvo,
            @RequestParam("workNomer") String workNomer,
            @RequestParam("persolalNomer") String persolalNomer,
            @RequestParam("cabinet") String cabinet,
            @RequestParam("corporatEmail") String corporatEmail,
            @RequestParam("denRoshdeniya") String denRoshdeniya,
            @RequestParam("idDolshnost") String idDolshnost,
            @RequestParam("idPosition") String idPosition
    ) {
        Sotrudniki sotr = rebotnikiRepository.findById(Integer.parseInt(id)).get();

        sotr.setCabinet(cabinet);
        sotr.setCorporatEmail(corporatEmail);
        try {
            sotr.setDenRoshdeniya(format.parse(denRoshdeniya));
        } catch (ParseException ex) {
            Logger.getLogger(descktopController.class.getName()).log(Level.SEVERE, null, ex);
        }
        sotr.setFamiliya(familiya);
        sotr.setIdDolshnost(dolhnostRepository.findById(Integer.parseInt(idDolshnost)).get());
        sotr.setIdPodrazd(padrazdeleniyaRepository.findById(Integer.parseInt(idDolshnost)).get());
        sotr.setImya(imya);
        sotr.setOtchestvo(otchestvo);
        sotr.setPersolalNomer(persolalNomer);
        sotr.setWorkNomer(workNomer);
        rebotnikiRepository.save(sotr);
        return ResponseEntity.ok(true);
    }

}
