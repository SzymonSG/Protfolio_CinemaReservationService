package com.cinema.booking.mapstructDTO;

import com.cinema.booking.entities.Movie;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CinemaDTOComplex {

    private Long cinemaId;
    private String cinemaNameDto;
}
