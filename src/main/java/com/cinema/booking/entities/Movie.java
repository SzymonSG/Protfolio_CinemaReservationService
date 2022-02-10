package com.cinema.booking.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    @NotBlank(message = "Movie name is requierd")
    @NotEmpty(message = "Movie cannot be empty")
    private String movieName;
    private String movieRoom;
//    @Range(min=0, max =1000, message="Seating")
    @Min(value = 1)
    @Max(value = 100, message = "Maksymalna wartość 100")
    private Integer seating;
    private String booked;

    //@JsonFormat annotation to control the date format on individual classes, instead of globally, for the entire application
    //podjąc z jsona w request body jest ok
//    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="yyyy-MM-dd; HH:mm:ss")
//    private LocalDateTime startTimeOfTheMovie;


    //@JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "seance",
            joinColumns = @JoinColumn(
                    name = "movie_ID",
                    referencedColumnName = "movieId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cinema_ID",
                    referencedColumnName ="cinemaId"
            )
    )
    private List<Cinema> cinemas = new ArrayList<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "property_id",referencedColumnName = "propertyId")
    private ProperitiesMovie properitiesMovie;

    public void enrolledCinema(Cinema cinema) {
        ///cinemas= new ArrayList<>();
        cinemas.add(cinema);
    }

    public void assignProperty(ProperitiesMovie properitiesMovie) {
        this.properitiesMovie = properitiesMovie;
    }
}

