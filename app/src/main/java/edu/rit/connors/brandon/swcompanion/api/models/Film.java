package edu.rit.connors.brandon.swcompanion.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Film {

    @JsonProperty("title")
    public String title;

    @JsonProperty("episode_id")
    public int episodeId;

    @JsonProperty("opening_crawl")
    public String openingCrawl;

    @JsonProperty("director")
    public String director;

    @JsonProperty("producer")
    public String producer;

    @JsonProperty("release_date")
    public Date releaseDate;

    @JsonProperty("species")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> species;

    @JsonProperty("starships")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> starships;

    @JsonProperty("vehicles")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> vehicles;

    @JsonProperty("characters")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> characters;

    @JsonProperty("planets")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> planets;

    @JsonProperty("url")
    public String url;

    @JsonProperty("created")
    public String created;

    @JsonProperty("edited")
    public String edited;

    @JsonCreator
    public Film(
            @JsonProperty("url") String url,
            @JsonProperty("created") String created,
            @JsonProperty("edited") String edited,
            @JsonProperty("title") String title,
            @JsonProperty("episode_id") int episodeId,
            @JsonProperty("opening_crawl") String openingCrawl,
            @JsonProperty("director") String director,
            @JsonProperty("producer") String producer,
            @JsonProperty("release_date") Date releaseDate,
            @JsonProperty("species") List<String> species,
            @JsonProperty("starships") List<String> starships,
            @JsonProperty("vehicles") List<String> vehicles,
            @JsonProperty("characters") List<String> characters,
            @JsonProperty("planets") List<String> planets
    ) {
        this.title = title;
        this.episodeId = episodeId;
        this.openingCrawl = openingCrawl;
        this.director = director;
        this.producer = producer;
        this.releaseDate = releaseDate;
        this.species = species;
        this.starships = starships;
        this.vehicles = vehicles;
        this.characters = characters;
        this.planets = planets;
        this.url = url;
        this.created = created;
        this.edited = edited;
    }
}
