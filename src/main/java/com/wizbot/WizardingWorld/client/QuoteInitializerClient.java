package com.wizbot.WizardingWorld.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizbot.WizardingWorld.dto.QuoteApiDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuoteInitializerClient {

    private final Logger logger;
    private final QuoteClient quoteClient;


    public void initialize() {
        List<QuoteApiDto> quotes = quoteClient.getQuotes();
        System.out.println("a");
    }

    private void sleeper() {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            logger.warn("Sleep was interrupted");
        }

    }
}
