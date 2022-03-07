package com.example.searchproject.service;

import com.example.searchproject.dto.SearchDto;
import com.example.searchproject.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public SearchDto find(String search){
        return searchMapper.find(search);
    }
}
