package com.wizbot.WizardingWorld.client;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientInitializer {
    private final CharacterClientInitializer characterClientInitializer;
    private final QuoteInitializerClient quoteInitializerClient;

    @PostConstruct
    private void initialize(){
        characterClientInitializer.initialize();
        quoteInitializerClient.initialize();
    }

}
