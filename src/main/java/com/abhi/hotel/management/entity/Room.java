package com.abhi.hotel.management.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "rooms")
public class Room {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roomType;
    private String photoUrl;
    private String roomDescription;
    private BigDecimal roomPrice;
    private List<Booking> bookings = new ArrayList<>();

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomType='" + roomType + '\'' +
                ", photoUrl='" + photoUrl + '\'' +
                ", roomDescription='" + roomDescription + '\'' +
                ", roomPrice=" + roomPrice +
                '}';
    }
}
