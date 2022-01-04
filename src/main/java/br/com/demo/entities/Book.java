package br.com.demo.entities;




import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity(name = "book")
@Table(name = "book")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank
    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;


    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }
}
