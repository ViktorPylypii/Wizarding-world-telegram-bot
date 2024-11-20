package com.wizbot.WizardingWorld.mapper;

import com.wizbot.WizardingWorld.config.MapperConfig;
import com.wizbot.WizardingWorld.model.Character;
import com.wizbot.WizardingWorld.model.Quote;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.JoinColumn;
import lombok.EqualsAndHashCode;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface CharacterMapper {
    Character toModel( String character_name,
                       String character_info,
                       String born, String died,
                       String gender,
                       String height,
                       String house,
                       String image,
                       String marital_status,
                       String nationality,
                       String weight,
                       String patronus,
                       List<String> romances,
                       List<String> family_members,
                       List<String> alias_name,
                       List<String> wands,
                       List<String> jobs);
}
