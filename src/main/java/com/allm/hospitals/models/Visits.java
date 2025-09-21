package com.allm.hospitals.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "visits" )
public class Visits {

    @Id
    @Column(name = "visit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "hospital_id")
    private int hospital_id;

    @Column(name = "patient_id")
    private int patient_id;

    @Column(name = "schedule_date")
    private Date dateTime;

    public Visits(int hospital_id, int patient_id, Date dateTime) {
        this.hospital_id = hospital_id;
        this.patient_id = patient_id;
        this.dateTime = dateTime;
    }
}
