package com.wizbot.WizardingWorld.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "characters")
@Data
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;
    private String character_name;
    private String character_ukr_name;
    @Lob
    private String character_info;
    private String born;
    private String died;
    private String gender;
    private String height;
    private String house;
    @Lob
    private String image;
    private String marital_status;
    private String nationality;
    private String weight;
    private String patronus;
    @OneToMany(mappedBy = "character",fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private List<Quote> quotes;
    @ElementCollection
    @CollectionTable(name = "character_romances",joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "romances")
    @EqualsAndHashCode.Exclude
    private List<String> romances;
    @ElementCollection
    @CollectionTable(name = "character_family_members",joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "family_members")
    @EqualsAndHashCode.Exclude
    private List<String> family_members;
    @ElementCollection
    @CollectionTable(name = "character_alias_name",joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "alias_name")
    @EqualsAndHashCode.Exclude
    private List<String> alias_name;
    @ElementCollection
    @CollectionTable(name = "character_wands",joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "wands")
    @EqualsAndHashCode.Exclude
    private List<String> wands;
    @ElementCollection
    @CollectionTable(name = "character_jobs",joinColumns = @JoinColumn(name = "character_id"))
    @Column(name = "jobs")
    @EqualsAndHashCode.Exclude
    private List<String> jobs;






}
