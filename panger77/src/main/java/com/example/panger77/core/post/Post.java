package com.example.panger77.core.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Table(name = "posts")
public class Post {
    @ToString.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "date")
    private String date;

    @Lob
    @Column(name = "content", length = 512)
    private String content;

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
