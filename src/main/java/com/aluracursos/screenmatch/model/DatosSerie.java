package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title") String titulo,
        Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion,
        @JsonAlias("Poster") String poster,
        @JsonAlias("Genre") String genero,
        @JsonAlias("Actors") String actores,
        @JsonAlias("Plot") String sinopsis
) {

    @JsonCreator
    public static DatosSerie of(
            @JsonProperty("Title") String titulo,
            @JsonProperty("totalSeasons") String totalTemporadas,
            @JsonProperty("imdbRating") String evaluacion,
            @JsonProperty("Poster") String poster,
            @JsonProperty("Genre") String genero,
            @JsonProperty("Actors") String actores,
            @JsonProperty("Plot") String sinopsis
    ) {

        Integer totalTemporadasInt;
        try {
            totalTemporadasInt = Integer.parseInt(totalTemporadas);
        } catch (NumberFormatException e) {
            totalTemporadasInt = 1; // o cualquier otro valor predeterminado
        }

        return new DatosSerie(titulo, totalTemporadasInt, evaluacion, poster, genero, actores, sinopsis);
    }


}

