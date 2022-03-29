package com.example.searchproject.controller;

import com.example.searchproject.dto.SearchDto;
import com.example.searchproject.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@Slf4j
public class SearchController {

    @Autowired
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }
    private SearchService searchService;
    SearchDto searchDto;

    @GetMapping("searchservice/{id}")
    public ResponseEntity<String> findID(@PathVariable("id") Integer id) {
        searchService.findId(id);
        String DBTitle = searchService.findId(id).getTitle();
        String DBContent = searchService.findId(id).getContent();
        return ResponseEntity.status(HttpStatus.OK).body(DBTitle + "  |  " + DBContent);
    }

    //게시글 작성
    @PostMapping("/post")
    public ResponseEntity<String> retrieveAllUser(@RequestBody SearchDto searchDto){
        searchService.createPost(searchDto);
        return ResponseEntity.status(HttpStatus.OK).body("생성되었습니다.");
    }

    //게시글 수정
    @GetMapping("/searchservice/changeposting/{id}")
    public ResponseEntity change(
            @PathVariable("id") Integer id,
            @RequestBody SearchDto searchDto){
        searchDto.setId(id);
        searchService.change(searchDto);
        return ResponseEntity.status(HttpStatus.OK).body(searchDto); //vo 고쳐보기
    }

    //게시물 삭제
    @DeleteMapping("/searchservice/deletposting/{id}")
    public ResponseEntity delet(
            @PathVariable("id") Integer id,
            @RequestBody SearchDto searchDto){
        searchDto.setId(id);
        searchService.delet(searchDto);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("게시물이 삭제 되었습니다.");
    }
}
