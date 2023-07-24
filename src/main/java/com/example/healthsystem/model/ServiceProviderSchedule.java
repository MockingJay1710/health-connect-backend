package com.example.healthsystem.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "service_provider_schedule")
public class ServiceProviderSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn (name = "service_provider_id", updatable = false, nullable = false)
    private User service_provide_id;

    @ManyToOne
    @JoinColumn (name = "patient_id", updatable = false, nullable = false)
    private User patient_id;

    @Column (nullable = false)
    private LocalDateTime date;


    @ColumnDefault("false")
    private Boolean reservation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date created_at;

    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getServiceProviderId() {
        return service_provide_id;
    }

    public void setServiceProviderId(User user) {
        this.service_provide_id = service_provide_id;
    }

    public User getPatient() {
        return patient_id;
    }

    public void setPatient(User user) {
        this.patient_id = patient_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Boolean getReservation() {
        return reservation;
    }

    public void setReservation(Boolean reservation) {
        this.reservation = reservation;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(Date created_at) {
        this.created_at = created_at;
    }
}
