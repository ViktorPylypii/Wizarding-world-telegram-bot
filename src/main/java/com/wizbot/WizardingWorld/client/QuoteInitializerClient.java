package com.wizbot.WizardingWorld.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizbot.WizardingWorld.dto.QuoteApiDto;
import com.wizbot.WizardingWorld.mapper.QuoteMapper;
import com.wizbot.WizardingWorld.model.Character;
import com.wizbot.WizardingWorld.model.Quote;
import com.wizbot.WizardingWorld.repository.CharacterRepository;
import com.wizbot.WizardingWorld.repository.QuoteRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class QuoteInitializerClient {

    private final Logger logger;
    private final QuoteClient quoteClient;
    private final QuoteMapper mapper;
    private final CharacterRepository characterRepository;
    private final QuoteRepository quoteRepository;

    public void initialize() {
        List<QuoteApiDto> quotes = quoteClient.getQuotes();
        for (QuoteApiDto quote : quotes) {
            Quote quoteModel = mapper.toModel(quote.getQuote(), quote.getSource());
            Quote quoteSave = quoteRepository.save(quoteModel);
            Optional<Character> characterByName = characterRepository.findCharacterByName(quote.getSpeaker());
            if(characterByName.isEmpty()){
                continue;
            }
            Character character = characterByName.get();
            if(character.getQuotes()==null){
                character.setQuotes(List.of(quoteSave));
            } else {
                character.getQuotes().add(quoteSave);
            }
            Character save = characterRepository.save(character);
            quoteSave.setCharacter(save);
            quoteRepository.save(quoteSave);
        }
    }

    private void sleeper() {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            logger.warn("Sleep was interrupted");
        }

    }
}
