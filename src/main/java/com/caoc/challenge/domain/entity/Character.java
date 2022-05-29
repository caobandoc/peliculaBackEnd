package com.caoc.challenge.domain.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private Double weight;
    private String history;
    @ManyToMany
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "movies_characters",
            joinColumns = @JoinColumn(name = "characters_id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id"))
    private List<Movie> movies;
}
