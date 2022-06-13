package com.example.panger77.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDto {
    @ToString.Exclude
    Long id;
    @JsonProperty("title")
    String title;

    @JsonProperty("date")
    String date;
    @JsonProperty("content")
    String content;

    public PostDto() {
    }

    public PostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public PostDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}