package com.wizbot.WizardingWorld.client;

import com.wizbot.WizardingWorld.dto.CharacterApiDto;
import com.wizbot.WizardingWorld.dto.CharacterInfoDto;
import com.wizbot.WizardingWorld.mapper.CharacterMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CharacterClientInitializer {
    private final Logger logger;
    private final CharacterClient characterClient;
    private final CharacterMapper mapper;

    public void initialize(){
        logger.info("starter client initializer");
        List<CharacterApiDto> allCharacters = characterClient.getAllCharacters();
        for (CharacterApiDto allCharacter : allCharacters) {
            for (CharacterInfoDto characterInfoDto : allCharacter.getData()) {
                mapper.toModel(characterInfoDto.getAttributes().getName(),)
            }
        }
    }


}
