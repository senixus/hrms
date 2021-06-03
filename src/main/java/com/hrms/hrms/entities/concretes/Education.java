package com.hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="resume_edu")
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name= "resume_id",referencedColumnName = "id")
    private Resume resume;

    @ManyToOne(targetEntity = Graduate.class)
    @JoinColumn(name="graduate_id",referencedColumnName = "id",nullable = false)
    private Graduate graduate;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "school_department")
    private String schoolDepartment;

    @Column(name = "started_at")
    private Date startedAt;

    @Column(name = "graduate_at")
    private Date graduateAt;

    @Column(name = "created_at")
    private Date createdAt;

}
