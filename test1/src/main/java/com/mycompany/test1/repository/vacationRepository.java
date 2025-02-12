/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.test1.repository;

import com.mycompany.test1.entity.Employees;
import com.mycompany.test1.entity.Vacations;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface vacationRepository extends CrudRepository<Vacations, Integer> {

    @Query("SELECT v FROM Vacations v WHERE v.eployee = :eployee")
    List<Vacations> vacationsEmpl(@Param("eployee") Employees eployee);

}
