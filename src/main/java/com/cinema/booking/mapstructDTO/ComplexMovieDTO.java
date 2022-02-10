package com.cinema.booking.mapstructDTO;

import com.cinema.booking.dto.CinemaDto;
import com.cinema.booking.entities.Cinema;
import com.cinema.booking.entities.ProperitiesMovie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ComplexMovieDTO {

    private Long movieId;
    private String movieName;
    private String movieRoom;
    private Integer seating;
    private String booked;
    //usunięte DTO2
    private List<CinemaDTOComplex> cinemas = new ArrayList<>();
    private PropertiesMovieDTO properitiesMovie;

}
