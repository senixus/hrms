package com.hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="resumes")
@JsonIgnoreProperties({"hibernateLazyInitializer","handle","resume"})
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name="candidate_id", referencedColumnName = "id",nullable = false)
    private Candidate candidate;

    @Column(name="github_address")
    private String github;

    @Column(name="linkedin_address")
    private String linkedin;

    @Column(name="photo_url")
    private String photo;

    @Column(name="description")
    private String description;

    @Column(name="created_at")
    private LocalDate createdAt = LocalDate.now();

    @Column(name="updated_at")
    private LocalDate updatedAt;

    @Column(name="is_active")
    private boolean isActive = true;

    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @OneToMany(mappedBy = "resume")
    private List<Technology> technologies;

    @OneToMany(mappedBy = "resume")
    private List<Education> educations;

    @OneToMany(mappedBy = "resume")
    private List<JobExperience> jobExperiences;
}
