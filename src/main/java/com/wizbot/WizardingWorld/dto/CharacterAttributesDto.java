package com.wizbot.WizardingWorld.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CharacterAttributesDto {
    private String born;
    private String died;
    private String gender;
    private String height;
    private String house;
    private String image;
    private String marital_status;
    private String nationality;
    private String weight;
    private String patronus;
    private List<String> alias_names;
    private String animagus;
    private String blood_status;
    private String boggart;
    private String eye_color;
    private List<String> family_members;
    private String hair_color;
    private List<String> jobs;
    private String name;
    private List<String> romances;
    private String skin_color;
    private String species;
    private List<String> titles;
    private List<String> wands;



}
