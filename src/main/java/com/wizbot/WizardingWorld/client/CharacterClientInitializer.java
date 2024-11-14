package com.wizbot.WizardingWorld.client;

import com.wizbot.WizardingWorld.dto.CharacterApiDto;
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
    private boolean done = false;
    @PostConstruct
    private void initialize(){
        logger.info("starter client initializer");
        List<CharacterApiDto> allCharacters = characterClient.getAllCharacters();
        done = true;
    }
}
