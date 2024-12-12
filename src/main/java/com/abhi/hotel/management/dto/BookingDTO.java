package com.abhi.hotel.management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookingDTO {

    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer numOfAdults;
    private Integer numOfChildren;
    private Integer totalNumOfGuests;
    private String bookingConfirmationCode;
    private UserDTO roomUser;
    private RoomDTO room;
}
