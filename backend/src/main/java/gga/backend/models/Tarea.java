package gga.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity
// https://docs.oracle.com/javaee/7/api/javax/persistence/Entity.html
// Identifies a class as an entity class. Specifies that the class is an entity. 
// This annotation is applied to the entity class.
// https://thorben-janssen.com/key-jpa-hibernate-annotations/
// Define an Entity Class
// JPA entities don’t need to implement any interface or extend a superclass. 
// They are simple POJOs (Plain Old Java Object). But you still need to 
// identify a class as an entity class, and you might want to adapt 
// the default table mapping.
@Entity
// @Table
// https://docs.oracle.com/javaee/7/api/javax/persistence/Table.html
// Specifies the primary table for the annotated entity.
// Additional tables may be specified using SecondaryTable
// or SecondaryTables annotation.
// If no Table annotation is specified for an entity
// class, the default values apply.
// By default, each entity class maps a database table
// with the same name in the default schema of your database.
// You can customize this mapping using the name, schema,
// and catalog attributes of the @Table annotation.
// The name attribute enables you to change the name of the
// database table which your entity maps.
// The schema attribute specifies the name of the database
// schema in which the table is located.
// And the catalog attribute describes the name of the
// database catalog that stores the metadata information
// of the table.
// The @Table annotation also defines 2 attributes that
// enable you to influence the generation of the database
// table. These are called indexes and uniqueConstraints.
// I don’t recommend to use them. External script and tools
// like Liquibase or Flyway are a much better option to
// create and update your database.
@Table(name = "tarea")
public class Tarea {
    // @Id
    // https://docs.oracle.com/javaee/7/api/javax/persistence/Id.html
    // Specifies the primary key of an entity. The field or property to
    // which the Id annotation is applied should be one of the following
    // types: any Java primitive type; any primitive wrapper type;
    // String; java.util.Date; java.sql.Date; java.math.BigDecimal;
    // java.math.BigInteger.
    // The mapped column for the primary key of the entity is assumed
    // to be the primary key of the primary table.
    @Id
    // @GeneratedValue
    // https://docs.oracle.com/javaee/7/api/javax/persistence/GeneratedValue.html
    // Provides for the specification of generation strategies for the values
    // of primary keys.
    // The GeneratedValue annotation may be applied to a primary key
    // property or field of an entity or mapped superclass in conjunction
    // with the Id annotation. The use of the GeneratedValue annotation
    // is only required to be supported for simple primary keys. Use of
    // the GeneratedValue annotation is not supported for derived primary keys.
    // When we’re talking about primary keys, we also need to talk about sequences
    // and auto-incremented database columns.
    // These are the 2 most common database features to generate unique primary key
    // values.
    // If you annotate your primary key attribute with the @GeneratedValue
    // annotation, you can use a database sequence by setting the strategy
    // attribute to GenerationType.SEQUENCE. Or, if you want to use an
    // auto-incremented
    // database column to generate your primary key values, you need to set
    // the strategy to GenerationType.IDENTITY.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // If no Column annotation is specified, the primary key column
    // name is assumed to be the name of the primary key property or field.
    // JPA and Hibernate require you to specify at least one primary key
    // attribute for each entity.
    @Column(name = "id")
    private Long id;

    // @Column
    // https://docs.oracle.com/javaee/7/api/javax/persistence/Column.html
    // It is an optional annotation.
    // Specifies the mapped column for a persistent property or field.
    // If no Column annotation is specified, the default values apply.
    // You can use the name attribute to specify the name of the
    // database column which the entity attribute map.
    // The attributes updatable and insertable enable you to exclude
    // the attribute from insert or update statements.
    @Column(name = "tarea")
    private String tarea;

    @Column(name = "finalizado")
    private boolean finalizado;

    /**
     * JPA exige este constructor default, sin argumentos.
     * Si no está, se produce una excepción.
     */
    public Tarea() {
    }

    public Tarea(String tarea, boolean finalizado) {
        this.tarea = tarea;
        this.finalizado = finalizado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

}
