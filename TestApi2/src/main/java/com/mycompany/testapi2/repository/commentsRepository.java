/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.testapi2.repository;

import com.mycompany.testapi2.entity.Commentaries;
import com.mycompany.testapi2.entity.Documents;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface commentsRepository extends CrudRepository<Commentaries, Integer> {

    @Query("SELECT c FROM Commentaries c WHERE c.documentId = :documentId")
    List<Commentaries> GetComment(@Param("documentId") Documents documents);
            
}
