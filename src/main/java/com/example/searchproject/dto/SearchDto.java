package com.example.searchproject.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SearchDto {
    private Integer id;
    private String title;
    private String writer;
    private LocalDateTime date;

//    public SearchEntity toEntity(){
//
//    }


    public SearchDto(Integer id, String title, String writer, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.writer = writer;
        this.date = date;
    }
}