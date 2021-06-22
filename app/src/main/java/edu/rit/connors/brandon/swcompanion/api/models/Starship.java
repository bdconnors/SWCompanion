package edu.rit.connors.brandon.swcompanion.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

public class Starship {
    @JsonProperty("url")
    public String url;

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

    @JsonProperty("name")
    public String name;

    @JsonProperty("model")
    public String model;

    @JsonProperty("manufacturer")
    public String manufacturer;

    @JsonProperty("cost_in_credits")
    public String costInCredits;

    @JsonProperty("length")
    public String length;

    @JsonProperty("crew")
    public String crew;

    @JsonProperty("passengers")
    public String passengers;

    @JsonProperty("max_atmosphering_Speed")
    public String maxAtmospheringSpeed;

    @JsonProperty("cargo_capacity")
    public String cargoCapacity;

    @JsonProperty("consumables")
    public String consumables;

    @JsonProperty("starship_class")
    public String starshipClass;

    @JsonProperty("films")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> films;

    @JsonProperty("pilots")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> pilots;

    @JsonProperty("hyperdrive_rating")
    public String hyperdriveRating;

    @JsonProperty("MGLT")
    public String MGLT;

    @JsonCreator
    public Starship(
            @JsonProperty("name") String name,
            @JsonProperty("model") String model,
            @JsonProperty("manufacturer") String manufacturer,
            @JsonProperty("cost_in_credits") String costInCredits,
            @JsonProperty("length") String length,
            @JsonProperty("max_atmosphering_Speed") String maxAtmospheringSpeed,
            @JsonProperty("crew") String crew,
            @JsonProperty("passengers") String passengers,
            @JsonProperty("cargo_capacity") String cargoCapacity,
            @JsonProperty("consumables") String consumables,
            @JsonProperty("hyperdrive_rating") String hyperdriveRating,
            @JsonProperty("MGLT") String MGLT,
            @JsonProperty("starship_class") String starshipClass,
            @JsonProperty("films") List<String> films,
            @JsonProperty("pilots") List<String> pilots,
            @JsonProperty("url") String url,
            @JsonProperty("created") String created,
            @JsonProperty("edited") String edited
    ) {

        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.costInCredits = costInCredits;
        this.length = length;
        this.maxAtmospheringSpeed = maxAtmospheringSpeed;
        this.crew = crew;
        this.passengers = passengers;
        this.cargoCapacity = cargoCapacity;
        this.consumables = consumables;
        this.starshipClass = starshipClass;
        this.films = films;
        this.pilots = pilots;
        this.url = url;
        this.created = created;
        this.edited = edited;
        this.hyperdriveRating = hyperdriveRating;
        this.MGLT = MGLT;
    }
}
