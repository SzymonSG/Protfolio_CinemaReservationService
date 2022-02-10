package com.cinema.booking.mapstructDTO;

import com.cinema.booking.entities.Cinema;
import com.cinema.booking.entities.Movie;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class MovieDTO {

    private Long movieId;
    private String movieName;
    private String movieRoom;
    private Integer seating;
    private String booked;
    //DTO
    //CinemaDTOComplex
    private List<CinemaDTOComplex> cinemas = new ArrayList<>();

}
