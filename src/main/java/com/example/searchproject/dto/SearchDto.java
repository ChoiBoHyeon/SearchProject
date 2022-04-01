package com.example.searchproject.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SearchDto {
    private Integer id;

    private String title;

    private String content;

    private LocalDateTime postdate;

}

