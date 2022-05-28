package com.caoc.challenge.domain.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "characters")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String name;
    private Integer age;
    private String history;
    //private List<Movie> movies;
}
