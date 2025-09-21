package com.allm.hospitals.models;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
