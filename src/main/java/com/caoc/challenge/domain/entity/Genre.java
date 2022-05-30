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
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    @ManyToMany
    @Cascade({ CascadeType.SAVE_UPDATE, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "movies_genres",
            joinColumns = @JoinColumn(name = "genres_id"),
            inverseJoinColumns = @JoinColumn(name = "movies_id"))
    private List<Movie> Movies;
}
