/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.testapi2.repository;

import com.mycompany.testapi2.entity.Padrazdeleniya;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface padrazdeleniyaRepository extends CrudRepository<Padrazdeleniya, Integer>{
    
}
