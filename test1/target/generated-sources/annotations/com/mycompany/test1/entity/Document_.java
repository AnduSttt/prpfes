package com.mycompany.test1.entity;

import com.mycompany.test1.entity.Comment;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-02-05T14:46:00", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Document.class)
public class Document_ { 

    public static volatile SingularAttribute<Document, Date> dateUpdate;
    public static volatile SingularAttribute<Document, Integer> idDocument;
    public static volatile CollectionAttribute<Document, Comment> commentCollection;
    public static volatile SingularAttribute<Document, Boolean> hasComents;
    public static volatile SingularAttribute<Document, String> title;
    public static volatile SingularAttribute<Document, Date> dateCreate;
    public static volatile SingularAttribute<Document, String> categoryDocument;

}