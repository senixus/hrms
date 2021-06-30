package com.hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "employers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handle","jobAdverts"})
public class Employer extends User {

    @NotBlank(message = "Company name cannot be empty")
    @Column(name = "company_name")
    private String companyName;

    @NotBlank(message = "Web address cannot be empty")
    @Column(name = "web_address")
    private String website;

    @NotBlank(message = "Phone number cannot be empty")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "is_update_request")
    private boolean isUpdateRequest;

    @OneToMany(mappedBy = "employer")
    private List<JobAdvert> jobAdverts;

}
