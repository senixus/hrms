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
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "resume_langs")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @JsonProperty(access = Access.WRITE_ONLY)
    @ManyToOne(targetEntity = Resume.class)
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @Column(name = "language")
    private String language;

    @Column(name = "lang_level")
    private String langLevel;

    @Column(name = "created_at")
    private Date createdAt;
}
