package com.tada.summerboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) // GenerationType.TABLE will allow auto-increment of id
    private Integer id;

    @Column(nullable = true) // allow null value in this column
    private String title;

    @Column(nullable = true, columnDefinition="mediumblob")
    private byte[] image;

    @Column(nullable = true, columnDefinition="TEXT") // allow null value in this column
    private String content;

    @Column(nullable = true) // allow null value in this column
    private String imageURL;


    @Column(nullable = true) // allow null value in this column
    private Timestamp timestamp;

    public Post(Integer id, String title, String content, Integer user_id, byte[] bytes, Timestamp timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.image = bytes;
        this.timestamp = timestamp;

    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    // Required for the @OneToMany relationship with a User
    @Column(name = "user_id")
    private Integer user_id;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

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

    public Post(String title, String content, Integer user_id, String imageURL) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
    }

    public Post(String title, String content, Integer user_id, String imageURL, Timestamp timestamp) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.imageURL = imageURL;
        this.timestamp = timestamp;
    }

    public Post(String title, String content, Integer user_id, Timestamp timestamp) {
        this.title = title;
        this.content = content;
        this.user_id = user_id;
        this.timestamp = timestamp;
    }


}