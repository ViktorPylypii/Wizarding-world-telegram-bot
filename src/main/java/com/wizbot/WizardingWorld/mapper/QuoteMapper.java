package com.wizbot.WizardingWorld.mapper;

import com.wizbot.WizardingWorld.config.MapperConfig;
import com.wizbot.WizardingWorld.dto.QuoteApiDto;
import com.wizbot.WizardingWorld.model.Quote;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface QuoteMapper {
    QuoteApiDto toDto (String quote, String speaker, String story, String source);
    Quote toModel (String quote, String source);

}
