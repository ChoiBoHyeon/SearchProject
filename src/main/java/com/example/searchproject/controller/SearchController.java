package com.example.searchproject.controller;

import com.example.searchproject.dto.SearchDto;
import com.example.searchproject.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
@Slf4j
public class SearchController {

    @Autowired
    public SearchController(SearchService searchService){
        this.searchService = searchService;
    }
    private SearchService searchService;
    private SearchDto searchDto;

    //게시글 작성
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
    @DeleteMapping("/searchservice/deleteposting/{id}")
    public ResponseEntity<String> delete(
            @PathVariable ("id") Integer id){
        try {
            id = searchService.findId(id).getId();
        }
        catch (java.lang.NullPointerException e1) {
            return ResponseEntity.status(HttpStatus.OK).body("해당 게시글은 없습니다.");
        }
        if (id != null){
            searchService.deletePosting(id);
            return ResponseEntity.status(HttpStatus.OK).body(id + "번의 게시글이 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("이 메세지가 나올리가 없다.");
        }
    }

    @GetMapping("/searchervice/search/{title}")
    public List<Post> titlesearch(@PathVariable("title") String title){
        return searchService.titlesearch(title);
        
    }

}
