package com.mycompany.test1.entity;

import com.mycompany.test1.entity.Comment;
import com.mycompany.test1.entity.Departments;
import com.mycompany.test1.entity.Positions;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-05T14:46:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile SingularAttribute<Employees, Date> birthday;
    public static volatile SingularAttribute<Employees, String> patronymic;
    public static volatile SingularAttribute<Employees, Positions> positionID;
    public static volatile SingularAttribute<Employees, String> surname;
    public static volatile CollectionAttribute<Employees, Comment> commentCollection;
    public static volatile SingularAttribute<Employees, String> name;
    public static volatile SingularAttribute<Employees, Integer> employeeID;
    public static volatile SingularAttribute<Employees, String> workPhone;
    public static volatile SingularAttribute<Employees, String> corporateEmail;
    public static volatile SingularAttribute<Employees, String> personalNumber;
    public static volatile SingularAttribute<Employees, String> office;
    public static volatile SingularAttribute<Employees, Departments> department;

}