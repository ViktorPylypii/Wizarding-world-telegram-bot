package com.wizbot.WizardingWorld.repository;

import com.wizbot.WizardingWorld.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {
    @Query("SELECT ch FROM Character ch JOIN FETCH ch.quotes WHERE ch.character_name=:character_name")
    Optional<Character> findCharacterByName (String character_name);
}
