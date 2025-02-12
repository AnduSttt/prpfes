package com.mycompany.test1.entity;

import com.mycompany.test1.entity.Document;
import com.mycompany.test1.entity.Employees;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-05T14:46:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Comment.class)
public class Comment_ { 

    public static volatile SingularAttribute<Comment, Integer> idComment;
    public static volatile SingularAttribute<Comment, Date> dateUpdate;
    public static volatile SingularAttribute<Comment, Document> idDocument;
    public static volatile SingularAttribute<Comment, String> text;
    public static volatile SingularAttribute<Comment, Date> dateCreate;
    public static volatile SingularAttribute<Comment, Employees> autor;

}