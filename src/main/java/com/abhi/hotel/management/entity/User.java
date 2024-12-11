package com.abhi.hotel.management.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is required.")
    private String name;

    @NotNull(message = "Email is required.")
    @Column(unique = true)
    private String email;

    @NotNull(message = "Email is required.")
    private String phoneNumber;

    private String role;

    @OneToMany
    private List<Booking> bookings = new ArrayList<>();
}
