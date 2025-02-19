/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.testapi2.repository;

import com.mycompany.testapi2.entity.Padrazdeleniya;
import com.mycompany.testapi2.entity.Sotrudniki;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface rebotnikiRepository extends CrudRepository<Sotrudniki, Integer> {

    @Query("SELECT s FROM Sotrudniki s WHERE s.login = :login AND s.password = :password")
    Sotrudniki SignIn(@Param("login") String login, @Param("password") String password);

    @Query("SELECT s FROM Sotrudniki s WHERE s.idPodrazd = :idPodrazd")
    List<Sotrudniki> AllSotrudnikiDepart(@Param("idPodrazd") Padrazdeleniya idPodrazd);
    
}
