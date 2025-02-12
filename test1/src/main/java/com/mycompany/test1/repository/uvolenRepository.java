/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.test1.repository;

import com.mycompany.test1.entity.Employees;
import com.mycompany.test1.entity.Uvoleni;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface uvolenRepository extends CrudRepository<Uvoleni, Integer> {

    @Query("SELECT u FROM Uvoleni u WHERE u.idEmployeer = :idEmployeer")
    Uvoleni ReturnUvol(@Param("idEmployeer") Employees idEmployeer);
}
