package com.mycompany.test1.entity;

import com.mycompany.test1.entity.Employees;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-05T14:46:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Positions.class)
public class Positions_ { 

    public static volatile SingularAttribute<Positions, String> positionName;
    public static volatile CollectionAttribute<Positions, Employees> employeesCollection;
    public static volatile SingularAttribute<Positions, Integer> positionID;

}