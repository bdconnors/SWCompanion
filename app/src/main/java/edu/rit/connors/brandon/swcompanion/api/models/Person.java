package edu.rit.connors.brandon.swcompanion.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

public class Person {

    @JsonProperty("name")
    public String name;

    @JsonProperty("birth_year")
    public String birthYear;

    @JsonProperty("eye_color")
    public String eyeColor;

    @JsonProperty("gender")
    public String gender;

    @JsonProperty("hair_color")
    public String hairColor;

    @JsonProperty("height")
    public String height;

    @JsonProperty("mass")
    public String mass;

    @JsonProperty("skin_color")
    public String skinColor;

    @JsonProperty("homeworld")
    public String homeWorld;

    @JsonProperty("species")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> species;

    @JsonProperty("starships")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> starships;

    @JsonProperty("vehicles")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> vehicles;

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
    public Person(
            @JsonProperty("url") String url,
            @JsonProperty("created") String created,
            @JsonProperty("edited") String edited,
            @JsonProperty("name") String name,
            @JsonProperty("birth_year") String birthYear,
            @JsonProperty("eye_color") String eyeColor,
            @JsonProperty("gender") String gender,
            @JsonProperty("hair_color") String hairColor,
            @JsonProperty("height") String height,
            @JsonProperty("mass") String mass,
            @JsonProperty("skin_color") String skinColor,
            @JsonProperty("homeworld") String homeWorld,
            @JsonProperty("starships") List<String> starships,
            @JsonProperty("vehicles") List<String> vehicles,
            @JsonProperty("films") List<String> films,
            @JsonProperty("species") List<String> species
    ) {
        this.name = name;
        this.birthYear = birthYear;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.hairColor = hairColor;
        this.height = height;
        this.mass = mass;
        this.skinColor = skinColor;
        this.homeWorld = homeWorld;
        this.starships = starships;
        this.vehicles = vehicles;
        this.films = films;
        this.species = species;
        this.url = url;
        this.created = created;
        this.edited = edited;
    }
}
