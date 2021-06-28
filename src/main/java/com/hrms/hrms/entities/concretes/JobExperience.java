package com.hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

import static javax.persistence.Access.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "resume_job_exp")

public class JobExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @ManyToOne(targetEntity = JobTitle.class)
    @JoinColumn(name = "job_title_id", referencedColumnName = "id", nullable = false)
    private JobTitle jobTitle;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "started_at")
    private LocalDate startedAt;

    @Column(name = "ended_at")
    private LocalDate endedAt;

    @Column(name = "created_at")
    private LocalDate createdAt = LocalDate.now();
}
