package com.example.alert.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "email_alerts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailAlertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "to_email", nullable = false)
    private String toEmail;

    @Column(name = "cc_email")
    private String ccEmail;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "status")
    private String status;

    @Column(name = "flag", length = 1)
    private String flag;   // "Y" or "N"
}
