/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.test1.repository;

import com.mycompany.test1.entity.Departments;
import com.mycompany.test1.entity.Employees;
import com.mycompany.test1.entity.Positions;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface employeesRepository extends CrudRepository<Employees, Integer> {

    @Query("SELECT empl FROM Employees empl WHERE login = :login AND password = :password")
    Employees findLoginAndPassword(@Param("login") String login, @Param("password") String password);

    @Query("SELECT empl FROM Employees empl WHERE department = :department")
    List<Employees> findByDepartment(@Param("department") Departments department);

    @Query("SELECT empl FROM Employees empl WHERE department = :department AND positionID = :positionID")
    List<Employees> findRoleInDepartment(@Param("department") Departments department, @Param("positionID") Positions positions);
}
