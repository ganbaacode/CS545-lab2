package com.example.lab1.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;
    private String author;
    @ManyToOne
    @JoinColumn
    private User user;
}
