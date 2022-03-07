package com.example.searchproject.mapper;

import com.example.searchproject.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchMapper {
    void createPost(SearchDto searchDto);

    SearchDto find(String find);
}
