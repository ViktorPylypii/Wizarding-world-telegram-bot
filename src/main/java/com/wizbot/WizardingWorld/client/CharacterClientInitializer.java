package com.wizbot.WizardingWorld.client;

import com.wizbot.WizardingWorld.dto.CharacterApiDto;
import com.wizbot.WizardingWorld.dto.CharacterInfoDto;
import com.wizbot.WizardingWorld.mapper.CharacterMapper;
import com.wizbot.WizardingWorld.model.Character;
import com.wizbot.WizardingWorld.repository.CharacterRepository;
import com.wizbot.WizardingWorld.util.TranslatorUtil;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class CharacterClientInitializer {
    private final Logger logger;
    private final CharacterClient characterClient;
    private final CharacterMapper mapper;
    private final TranslatorUtil translatorUtil;
    private final CharacterRepository characterRepository;


    public void initialize(){
        logger.info("starter client initializer");
        List<CharacterApiDto> allCharacters = characterClient.getAllCharacters();
        for (CharacterApiDto allCharacter : allCharacters) {
            for (CharacterInfoDto characterInfoDto : allCharacter.getData()) {
                String characterInfo = validateString(characterInfoDto.getAttributes().getAnimagus())+
                        validateString(characterInfoDto.getAttributes().getBlood_status())+
                        validateString(characterInfoDto.getAttributes().getBoggart())+
                        validateString(characterInfoDto.getAttributes().getEye_color())+
                        validateString(characterInfoDto.getAttributes().getHair_color())+
                        validateString(characterInfoDto.getAttributes().getSkin_color())+
                        validateString(characterInfoDto.getAttributes().getSpecies())+
                        validateString(characterInfoDto.getAttributes().getTitles().toString());
                Character character = mapper.toModel(characterInfoDto.getAttributes().getName(),
                        characterInfo,
                        characterInfoDto.getAttributes().getBorn(),
                        characterInfoDto.getAttributes().getDied(),
                        characterInfoDto.getAttributes().getGender(),
                        characterInfoDto.getAttributes().getHeight(),
                        characterInfoDto.getAttributes().getHouse(),
                        characterInfoDto.getAttributes().getImage(),
                        characterInfoDto.getAttributes().getMarital_status(),
                        characterInfoDto.getAttributes().getNationality(),
                        characterInfoDto.getAttributes().getWeight(),
                        characterInfoDto.getAttributes().getPatronus(),
                        characterInfoDto.getAttributes().getRomances(),
                        characterInfoDto.getAttributes().getFamily_members(),
                        characterInfoDto.getAttributes().getAlias_names(),
                        characterInfoDto.getAttributes().getWands(),
                        characterInfoDto.getAttributes().getJobs());
                characterRepository.save(character);
            }
        }
    }
    private String validateString(String data){
        if(data == null){
            return "";
        }
        return data+" ";
    }


}
