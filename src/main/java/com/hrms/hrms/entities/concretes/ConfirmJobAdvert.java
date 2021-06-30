package com.hrms.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="confirm_job_adverts")
public class ConfirmJobAdvert {

    @Id
    @Column(name="job_advert_id")
    private int jobAdvertId;

    @Column(name="employee_id")
    private int employeeId;

    @Column(name="is_confirmed")
    private boolean isConfirmed = false;

    @Column(name="confirmed_at")
    private LocalDate confirmedAt;

}
