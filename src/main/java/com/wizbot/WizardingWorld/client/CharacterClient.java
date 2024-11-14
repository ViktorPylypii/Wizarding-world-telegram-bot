package com.wizbot.WizardingWorld.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizbot.WizardingWorld.dto.CharacterApiDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CharacterClient {
    private static final String CHARACTER_API_URL = "https://api.potterdb.com/v1/characters?page[number]=";

    private final ObjectMapper mapper;
    private final Logger logger;

    public List<CharacterApiDto> getAllCharacters() {
        List<CharacterApiDto> characterApiDtos = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        for (int i = 1; i < 100; i++) {
            sleeper(i);
            HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(CHARACTER_API_URL+i))
                    .build();
            try {
                HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
                if(response.statusCode()/100!=2){
                    logger.warn("Not received 200 status");
                    break;
                }
                CharacterApiDto characterApiDto = mapper.readValue(response.body(), CharacterApiDto.class);
                if (characterApiDto.getData().isEmpty()){
                    break;
                }
                characterApiDtos.add(characterApiDto);

            }catch (IOException | InterruptedException e){
                logger.warn("Can't receive data");
            }
        }
        return characterApiDtos;
    }

     private void sleeper(int index){
        if(index%14 == 0){
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                logger.warn("Sleep was interrupted");
            }
        }
     }
}
