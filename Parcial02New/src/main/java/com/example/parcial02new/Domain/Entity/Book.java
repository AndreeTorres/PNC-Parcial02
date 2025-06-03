package com.example.parcial02new.Domain.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String title;

    @Column
    private String author;

    @Column(unique = true)
    @Length(max = 13)
    @Length(min = 13)
    private String isbn;

    @Column
    private Integer publicationYear;

    @Column
    private String language;

    @Column
    @Min(100)
    @Max(300)
    private Integer pages;

    @Column
    private String genre;

}