package edu.rit.connors.brandon.swcompanion.api.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Species {

    @JsonProperty("name")
    public String name;

    @JsonProperty("classification")
    public String classification;

    @JsonProperty("designation")
    public String designation;

    @JsonProperty("average_height")
    public String averageHeight;

    @JsonProperty("average_lifespan")
    public String averageLifespan;

    @JsonProperty("eye_colors")
    public String eyeColors;

    @JsonProperty("hair_colors")
    public String hairColors;

    @JsonProperty("skin_colors")
    public String skinColors;

    @JsonProperty("language")
    public String language;

    @JsonProperty("homeworld")
    public String homeworld;

    @JsonProperty("people")
    @JsonDeserialize(as = ArrayList.class, contentAs = String.class)
    public List<String> people;

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
    public Species(
            @JsonProperty("url") String url,
            @JsonProperty("created") String created,
            @JsonProperty("edited") String edited,
            @JsonProperty("name") String name,
            @JsonProperty("classification") String classification,
            @JsonProperty("designation") String designation,
            @JsonProperty("average_height") String averageHeight,
            @JsonProperty("average_lifespan") String averageLifespan,
            @JsonProperty("eye_colors") String eyeColors,
            @JsonProperty("hair_colors") String hairColors,
            @JsonProperty("skin_colors") String skinColors,
            @JsonProperty("language") String language,
            @JsonProperty("homeworld") String homeworld,
            @JsonProperty("people") List<String> people,
            @JsonProperty("films") List<String> films
    ) {
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.averageHeight = averageHeight;
        this.averageLifespan = averageLifespan;
        this.eyeColors = eyeColors;
        this.hairColors = hairColors;
        this.skinColors = skinColors;
        this.language = language;
        this.homeworld = homeworld;
        this.people = people;
        this.films = films;
        this.url = url;
        this.created = created;
        this.edited = edited;
    }
}
