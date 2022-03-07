package com.example.searchproject.controller;

import com.example.searchproject.dto.SearchDto;
import com.example.searchproject.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class SearchController {

    @Autowired
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }
    private SearchService searchService;


    @GetMapping("searchservice/{search}")
    public void find(@PathVariable("search") String search){
        searchService.find(search);
    }

    @PostMapping("/post")
    public ResponseEntity<String> retrieveAllUser(@RequestBody SearchDto searchDto){
        searchService.createPost(searchDto);
        return ResponseEntity.status(HttpStatus.OK).body("생성되었습니다.");
    }
}
