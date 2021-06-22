package edu.rit.connors.brandon.swcompanion.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

public class Planet {

    @JsonProperty("name")
    public String name;

    @JsonProperty("diameter")
    public String diameter;

    @JsonProperty("rotation_period")
    public String rotationPeriod;

    @JsonProperty("orbital_period")
    public String orbitalPeriod;

    @JsonProperty("gravity")
    public String gravity;

    @JsonProperty("population")
    public String population;

    @JsonProperty("climate")
    public String climate;

    @JsonProperty("terrain")
    public String terrain;

    @JsonProperty("surface_water")
    public String surfaceWater;

    @JsonProperty("residents")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> residents;

    @JsonProperty("films")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> films;

    @JsonProperty("url")
    public String url;

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

    @JsonCreator
    public Planet(
            @JsonProperty("url") String url,
            @JsonProperty("created") String created,
            @JsonProperty("edited") String edited,
            @JsonProperty("name") String name,
            @JsonProperty("diameter") String diameter,
            @JsonProperty("rotation_period") String rotationPeriod,
            @JsonProperty("orbital_period") String orbitalPeriod,
            @JsonProperty("gravity") String gravity,
            @JsonProperty("population") String population,
            @JsonProperty("climate") String climate,
            @JsonProperty("terrain") String terrain,
            @JsonProperty("surface_water") String surfaceWater,
            @JsonProperty("residents") List<String> residents,
            @JsonProperty("films") List<String> films
    ) {
        this.name = name;
        this.diameter = diameter;
        this.rotationPeriod = rotationPeriod;
        this.orbitalPeriod = orbitalPeriod;
        this.gravity = gravity;
        this.population = population;
        this.climate = climate;
        this.terrain = terrain;
        this.surfaceWater = surfaceWater;
        this.residents = residents;
        this.films = films;
        this.url = url;
        this.created = created;
        this.edited = edited;
    }
}
