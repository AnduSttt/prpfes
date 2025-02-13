/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.test1.repository;

import com.mycompany.test1.entity.Educations;
import com.mycompany.test1.entity.Employees;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface educationsRepository extends CrudRepository<Educations, Integer> {

    /*
    Условие соединения: Убедитесь, что используется empl.education.id вместо empl.education. 
    Это предполагает, что Employeeseducations имеет ссылку на сущность Educations, и вы хотите 
    соединить по ID.

    Ссылка на сотрудника: Если empl.employee — это сущность, вам может понадобиться использовать 
    empl.employee.id, чтобы сравнить его с параметром типа Integer.
     */
    
    @Query("SELECT e FROM Educations e INNER JOIN Employeeseducations empl ON e.idEducation = empl.education.id WHERE empl.employee.id = :employee")
    List<Educations> educationsEmpl(@Param("employee") Integer employee);

}
