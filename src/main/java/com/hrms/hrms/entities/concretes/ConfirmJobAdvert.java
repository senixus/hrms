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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @OneToOne
    @JoinColumn(name="job_adverts_id")
    private JobAdvert jobAdvert;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @Column(name="is_confirmed")
    private boolean isConfirmed = false;

    @Column(name="confirmed_at")
    private LocalDate confirmedAt;

}
