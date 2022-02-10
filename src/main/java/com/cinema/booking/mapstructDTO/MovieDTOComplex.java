package com.cinema.booking.mapstructDTO;

import lombok.Data;

@Data
public class MovieDTOComplex {
    private Long movieId;
    private String movieName;
    private String movieRoom;
    private Integer seating;
    private String booked;
}
