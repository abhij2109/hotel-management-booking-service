package com.abhi.hotel.management.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {

    private Long id;
    private String roomType;
    private String photoUrl;
    private String roomDescription;
    private BigDecimal roomPrice;
    private List<BookingDTO> bookings;
}
