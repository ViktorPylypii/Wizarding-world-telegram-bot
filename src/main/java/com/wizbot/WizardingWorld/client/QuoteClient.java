package com.wizbot.WizardingWorld.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wizbot.WizardingWorld.dto.QuoteApiDto;
import com.wizbot.WizardingWorld.mapper.QuoteMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class QuoteClient {

    private final QuoteMapper mapper;
    private final Logger logger;
    private static final String PATH = "data/quotes.json";
    public List<QuoteApiDto> getQuotes(){
        JSONParser jsonParser = new JSONParser();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<QuoteApiDto> quoteApiDtoList = new ArrayList<>();
        try (InputStream inputStream = classLoader.getResourceAsStream(PATH);
             InputStreamReader reader = new InputStreamReader(inputStream)) {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(reader);
            for (Object obj: jsonArray){
                JSONObject jsonObject = (JSONObject) obj;
                quoteApiDtoList.add(
                        mapper.toDto((String) jsonObject.get("quote"),
                                (String) jsonObject.get("speaker"),
                                (String) jsonObject.get("story"),
                                (String) jsonObject.get("source")
                ));
            }
        } catch (IOException | ParseException e) {
            logger.warn("Can't fiend resources");
        }

       return quoteApiDtoList;
    }
}
