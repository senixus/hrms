package com.hrms.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrms.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activation_codes")
public class ActivationCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User userId;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "is_confirmed")
    private boolean isConfirmed;

    @Column(name = "confirmed_at")
    private LocalDate confirmedAt;

    @Column(name = "created_at")
    private LocalDate createdAt;




}
