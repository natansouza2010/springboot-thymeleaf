package br.com.demo.entities;


import lombok.*;

import javax.persistence.*;

@Table(name ="author")
@Entity(name = "author")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;


}
