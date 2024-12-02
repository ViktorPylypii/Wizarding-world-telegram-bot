package com.wizbot.WizardingWorld.repository;

import com.wizbot.WizardingWorld.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote,Long>, JpaSpecificationExecutor<Quote> {
    @Query("SELECT q FROM Quote q JOIN FETCH q.character WHERE q.quote=:quote")
    Optional<Quote> findQuote(String quote);
}
