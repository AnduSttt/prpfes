/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.test1.repository;

import com.mycompany.test1.entity.Absents;
import com.mycompany.test1.entity.Employees;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface absentsRepository extends CrudRepository<Absents, Integer>{
    
    @Query("SELECT a FROM Absents a WHERE a.employee = :employee")
    List<Absents> absentsEmpl(@Param("employee") Employees employee);
    
}
