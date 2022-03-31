package com.example.searchproject.service;

import com.example.searchproject.dto.SearchDto;
import com.example.searchproject.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SearchService {

    SearchMapper searchMapper;

    @Autowired
    public SearchService(SearchMapper searchMapper) {
        this.searchMapper = searchMapper;
    }

    public void createPost(SearchDto searchDto){
        searchMapper.createPost(searchDto);
    }

    public SearchDto findId(Integer id){
        return searchMapper.findID(id);
    }

    public void change(SearchDto searchDto){
        searchMapper.change(searchDto);
    }

    public void deletePosting(Integer searchDto){
        searchMapper.delete(searchDto);
    }

    public List<Post> titlesearch(String title){
        return  searchMapper.titlesearch(title);
    }

}
