package com.wizbot.WizardingWorld.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CharacterApiDto {
    List<CharacterInfoDto> data;
}
