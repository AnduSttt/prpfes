/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test1.controller;

import com.mycompany.test1.entity.Employees;
import com.mycompany.test1.entity.Uvoleni;
import com.mycompany.test1.repository.departmentsRepository;
import com.mycompany.test1.repository.employeesRepository;
import com.mycompany.test1.repository.positionsRepository;
import com.mycompany.test1.repository.uvolenRepository;
import com.mycompany.test1.repository.vacationRepository;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/v1/employee")
public class employeesController {

    public DateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private employeesRepository employeesRepository;
    @Autowired
    private departmentsRepository departmentsRepository;
    @Autowired
    private positionsRepository positionsRepository;

    @GetMapping("/SignIn")
    public @ResponseBody
    Employees
            SignIn(@RequestParam("login") String login,
                    @RequestParam("password") String password) {
        Employees emp1 = employeesRepository.findLoginAndPassword(login, password);
        if (emp1 != null) {
            return emp1;
        }
        return null;
    }

    @PostMapping("/AddEmpl")
    public @ResponseBody
    boolean AddEmp(@RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("patron") String potron,
            @RequestParam("department") String department,
            @RequestParam("workPh") String workPh,
            @RequestParam("position") String position,
            @RequestParam("password") String password,
            @RequestParam("login") String login,
            @RequestParam("bd") String bd,
            @RequestParam("cEmail") String email,
            @RequestParam("office") String office,
            @RequestParam("personalNumber") String personalNumber) {

        Employees e = new Employees();
        try {
            e.setBirthday(format.parse(bd));
        } catch (ParseException ex) {
            Logger.getLogger(employeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.setCorporateEmail(email);
        e.setName(name);
        e.setPersonalNumber(personalNumber);
        e.setCorporateEmail(email);
        e.setDepartment(departmentsRepository.findById(Integer.parseInt(department)).get());
        e.setLogin(login);
        e.setPassword(password);
        e.setPatronymic(potron);
        e.setPositionID(positionsRepository.findById(Integer.parseInt(position)).get());
        e.setSurname(surname);
        e.setWorkPhone(workPh);

        employeesRepository.save(e);
        return true;
    }

    @PostMapping("/UpdateEmpl")
    public @ResponseBody
    boolean UpdateEmp(@RequestParam("name") String name,
            @RequestParam("surname") String surname,
            @RequestParam("patron") String potron,
            @RequestParam("department") String department,
            @RequestParam("workPh") String workPh,
            @RequestParam("position") String position,
            @RequestParam("password") String password,
            @RequestParam("login") String login,
            @RequestParam("bd") String bd,
            @RequestParam("cEmail") String email,
            @RequestParam("idEmpl") String idEmpl,
            @RequestParam("office") String office,
            @RequestParam("personalNumber") String personalNumber) {

        Employees e = employeesRepository.findById(Integer.parseInt(idEmpl)).get();
        try {
            e.setBirthday(format.parse(bd));
        } catch (ParseException ex) {
            Logger.getLogger(employeesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.setOffice(office);
        e.setPersonalNumber(personalNumber);
        e.setCorporateEmail(email);
        e.setName(name);
        e.setDepartment(departmentsRepository.findById(Integer.parseInt(department)).get());
        e.setLogin(login);
        e.setPassword(password);
        e.setPatronymic(potron);
        e.setPositionID(positionsRepository.findById(Integer.parseInt(position)).get());
        e.setSurname(surname);
        e.setWorkPhone(workPh);

        employeesRepository.save(e);
        return true;
    }

    @Autowired
    private uvolenRepository uvolenRepository;

    @GetMapping("/DeletteEmployeer")
    public ResponseEntity DelEmpl(
            @RequestParam("idUser") String idUser) {
        if (employeesRepository.findById(Integer.valueOf(idUser)) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            Uvoleni uv = new Uvoleni();
            Date d = new Date();
            uv.setDate(d);
            uv.setIdEmployeer(employeesRepository.findById(Integer.valueOf(idUser)).get());
            uvolenRepository.save(uv);
            return ResponseEntity.ok(true);
        }

    }

    @GetMapping("/getEployeer")
    public ResponseEntity GetEmpl(
            @RequestParam("idEmpl") Integer idEmpl) {
        if (employeesRepository.findById(idEmpl) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(employeesRepository.findById(idEmpl));
        }
    }

    @GetMapping("/AllEmpl")
    public ResponseEntity<List<Employees>> AllEmpl() {
        List list = new ArrayList();
        if (employeesRepository.findAll() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            for (Employees epl : employeesRepository.findAll()) {
                list.add(epl);
            }
            return ResponseEntity.ok(list);
        }
    }

    @GetMapping("/StatusWork")
    public ResponseEntity ReturnStatusWork(
            @RequestParam("idUser") String idUser) {
        if (uvolenRepository.ReturnUvol(employeesRepository.findById(Integer.valueOf(idUser)).get()) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(uvolenRepository.ReturnUvol(employeesRepository.findById(Integer.valueOf(idUser)).get()));
        }
    }

    @GetMapping("/AllEmplDep")
    public @ResponseBody
    Iterable<Employees> AllEmplDep(@RequestParam("department") Integer Department) {

        return employeesRepository.findByDepartment(departmentsRepository.findById(Department).get());

    }

    @GetMapping("/HeadDepartment")
    public ResponseEntity HeadDepartment(
            @RequestParam("idDepart") Integer idDepart,
            @RequestParam("idRole") Integer idRole) {
        if (employeesRepository.findRoleInDepartment(departmentsRepository.findById(idDepart).get(),
                positionsRepository.findById(idRole).get()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(employeesRepository.findRoleInDepartment(departmentsRepository.findById(idDepart).get(),
                    positionsRepository.findById(idRole).get()));
        }
    }

    @Autowired
    private vacationRepository vacationRepository;

    @GetMapping("/GetVacationsEmployees")
    public ResponseEntity GetVacacionEmployee(
            @RequestParam("idUser") String idUser) {
        if (vacationRepository.vacationsEmpl(employeesRepository.findById(Integer.valueOf(idUser)).get()) == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            return ResponseEntity.ok(vacationRepository.vacationsEmpl(employeesRepository.findById(Integer.valueOf(idUser)).get()));
        }
    }

}
