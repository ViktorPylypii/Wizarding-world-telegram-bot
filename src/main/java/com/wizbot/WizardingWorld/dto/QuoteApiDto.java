package com.wizbot.WizardingWorld.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteApiDto {
    private String quote;
    private String speaker;
    private String story;
    private String source;
}
