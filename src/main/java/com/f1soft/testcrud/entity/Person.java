package com.f1soft.testcrud.entity;

import com.sun.xml.internal.bind.v2.model.core.ID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "person")
public class Person extends AbstractAuditableEntity<String,Long> implements Serializable{

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}
