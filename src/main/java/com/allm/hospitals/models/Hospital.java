package com.allm.hospitals.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "hospitals")
public class Hospital {

    @Id
    @Column(name = "hospital_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private  String city;

}
