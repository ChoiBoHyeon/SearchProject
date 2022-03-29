package com.example.searchproject.mapper;

import com.example.searchproject.dto.SearchDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SearchMapper {
    void createPost(SearchDto searchDto);

    SearchDto findID(Integer in);

    void change(SearchDto searchDto);

    void delet(SearchDto searchDto);
}
