package com.wizbot.WizardingWorld.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class CharacterInfoDto {
   private CharacterAttributesDto attributes;
}
