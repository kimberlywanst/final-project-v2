package com.tada.summerboot.model;

import javax.persistence.*;


import lombok.Setter;
import lombok.Getter;

import java.sql.Timestamp;


@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE will allow auto-increment of id
    private Integer id;
    private String title;
    private String content;
    private String imageURL;
    private Timestamp timestamp;

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    // Required for the @OneToMany relationship with a User
    @Column(name = "user_id")
    private Integer user_id;

    @Column(nullable = true, columnDefinition="mediumblob")
    private byte[] image;

    public Post(Integer id, String title, String content, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
    }

    public Post(String title, String content, String imageURL) {
        this.title = title;
        this.content = content;
        this.imageURL = imageURL;
    }

    public Post(){
        super();
    }

    public Post(String title, String content, Integer user_id) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
    }

    public Post(String title, String content, Integer user_id, byte[] image, Timestamp timestamp) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.image = image;
        this.timestamp = timestamp;
    }

    public Post(String title, String content, Integer user_id, String imageURL) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
    }

    public Post(Integer id, String title, String content, Integer user_id, String imageURL) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
    }

}

//Lines 23/25/29/64/69 edited