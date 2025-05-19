package org.dreamy.dreamjournal.dream.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "DREAM_TAGS")
public class DreamTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String name;

    // Tag'ler üzerinden rüyalara erişmeyi sağlar
    @ManyToMany(mappedBy = "tags")
    private Set<Dream> dreams = new HashSet<>();

}
